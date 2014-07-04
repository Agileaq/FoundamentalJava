package apachehttpclientuse.jdbc;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

public class PhoneResponseHandler implements ResponseHandler<PhoneBean> {

	private static String PATTERN0 = "<a href=\"mobile.asp\">手机号码测吉凶</a> > (\\d*)</span></div>";
	private static String PATTERN1 = "<b>数理评分：</b><font class=\".*?\">(\\d*?)分</font>";
	private static String PATTERN2 = "<img src=\"/images/ico/jia.gif\" align=\"absmiddle\" /> 事业：.*?\\[<span class=\"red\">(.*?)分</span>]";
	// private static String PATTERN3 =
	// "<img src=\"/images/img/filebox.gif\" /> <b>后四位数：</b><span style=\"font-size:18px;font-weight:bold;color:#E24223;\">.*?</span> → <span style=\"font-size:18px;font-weight:bold;color:#E24223;\">.*?</span>（<span class=\".*?\">代表获得号码后十年的运势</span>）\\r\\n<br />\r\n<img src=\"/images/ico/jia.gif\" align=\"absmiddle\" />.*?\\[<span class=\".*?\">(.*?)分</span>\\]";

	private Pattern p0 = Pattern.compile(PATTERN0);
	private Pattern p1 = Pattern.compile(PATTERN1);
	private Pattern p2 = Pattern.compile(PATTERN2);

	// private Pattern p3 = Pattern.compile(PATTERN3);

	public PhoneBean handleResponse(HttpResponse response)
			throws ClientProtocolException, IOException {
		int status = response.getStatusLine().getStatusCode();
		if (status >= 200 && status < 300) {
			HttpEntity entity = response.getEntity();
			String source = new String(EntityUtils.toByteArray(entity),
					"GB2312");

			String phoneNumber = null;
			Matcher m0 = p0.matcher(source);
			if (m0.find()) {
				String g = m0.group(1);
				phoneNumber = g;
			}

			Matcher m1 = p1.matcher(source);
			Integer numberValue = null;
			if (m1.find()) {
				String g = m1.group(1);
				numberValue = Integer.valueOf(g);
			}
			Integer lastTwoNumberValue = null;
			Integer lastFourNumberValue = null;
			try {
				Matcher m2 = p2.matcher(source);
				if (m2.find()) {
					String g = m2.group(1);
					lastTwoNumberValue = Integer.valueOf(g);
					System.out.println(lastTwoNumberValue);
				}
				int start = m2.end();
				Matcher m3 = p2.matcher(source.substring(start));
				if (m3.find()) {
					String g = m3.group(1);
					lastFourNumberValue = Integer.valueOf(g);
					System.out.println(lastFourNumberValue);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Matcher m3 = p3.matcher(source);
			// if(m3.find()) {
			// String g = m3.group(1);
			// lastFourNumberValue = Integer.valueOf(g);
			// }

			PhoneBean pb = new PhoneBean();
			// System.out.println(source);
			pb.setPhoneNumber(phoneNumber);
			pb.setNumberValue(numberValue);
			pb.setLastFourNumberValue(lastFourNumberValue);
			pb.setLastTwoNumberValue(lastTwoNumberValue);
			return pb;

		} else {
			throw new ClientProtocolException("Unexpected response status: "
					+ status);
		}
	}
}
