package apachehttpclientuse.jdbc;

import java.util.Arrays;

import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class HttpClientReadAllLuckyPhone {

	CloseableHttpClient httpclient = HttpClients.createDefault();
	ResponseHandler<PhoneBean> responseHandler = new PhoneResponseHandler();
	
	public PhoneBean readLuckyInfoByPhoneNumber(String phoneNumber)
			throws Exception {
		String url = "http://life.httpcn.com/mobile.asp#main";
		// try {
		HttpPost httppost = new HttpPost(url);
		// NameValuePair nvp = new BasicNameValuePair("word", "17091950974");
		NameValuePair nvp = new BasicNameValuePair("word", phoneNumber);
		NameValuePair nvp1 = new BasicNameValuePair("isbz", "0");
		NameValuePair nvp2 = new BasicNameValuePair("data_type", "0");
		NameValuePair nvp3 = new BasicNameValuePair("year", "1980");
		NameValuePair nvp4 = new BasicNameValuePair("month", "7");
		NameValuePair nvp5 = new BasicNameValuePair("day", "4");
		NameValuePair nvp6 = new BasicNameValuePair("hour", "13");
		NameValuePair nvp7 = new BasicNameValuePair("minute", "10");
		NameValuePair nvp8 = new BasicNameValuePair("pid", "");
		NameValuePair nvp9 = new BasicNameValuePair("cid", "");
		NameValuePair nvp10 = new BasicNameValuePair("name", "");
		NameValuePair nvp11 = new BasicNameValuePair("sex", "1");
		NameValuePair nvp12 = new BasicNameValuePair("act", "submit");

		StringEntity entity = new UrlEncodedFormEntity(Arrays.asList(nvp, nvp1,
				nvp2, nvp3, nvp4, nvp5, nvp6, nvp7, nvp8, nvp9, nvp10, nvp11,
				nvp12));
		httppost.setEntity(entity);
		//System.out.println("Executing request " + httppost.getRequestLine());
		if(phoneNumber.equals("17091950020")) {
			System.out.println("test");
		}
		PhoneBean phoneBean = httpclient.execute(httppost, responseHandler);
		httppost.releaseConnection();
		return phoneBean;
		// } finally {
		// httpclient.close();
		// }
	}
	
}
