package apachehttpclientuse;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientVisitBaidu {
	
	public static void main(String args[]) throws Exception{
		String url = "http://www.baidu.com";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet httpget = new HttpGet(url);
			HttpHost proxy = new HttpHost("proxy.houston.hp.com", 8080, "http");
			RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
			httpget.setConfig(config);
			System.out.println("Executing request " + httpget.getRequestLine());
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if(status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}
			};
			String responseBody = httpclient.execute(httpget, responseHandler);
			System.out.println("---------------------------");
			System.out.println(responseBody);
		} finally {
			httpclient.close();
		}
	}
	
}
