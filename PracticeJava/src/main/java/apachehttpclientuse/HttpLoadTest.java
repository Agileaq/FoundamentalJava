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

public class HttpLoadTest {
	
	public static int threadCounts = 10000;
	public static int initialThreadCounts = threadCounts;
	
	public synchronized static void  minusCounts() {
		threadCounts --;
	}
	
	public synchronized static void  plusCounts() {
		threadCounts ++;
	}
	
	public static void main(String args[]) throws InterruptedException {
		long start = System.currentTimeMillis();
		for(int i=0; i < initialThreadCounts; i++) {
			Thread t = new Thread(new LoadRunner());
			t.start();
		}
		while(threadCounts > 100) {
			Thread.sleep(100);
			//System.out.println(threadCounts);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start + "ms");
	}
}

class LoadRunner implements Runnable {
	String url = "http://hpitcdckm.duapp.com/views/event-detail.html?eventId=5417e566e4b0b04729bd3f0e&openUserID=123456";
	CloseableHttpClient httpclient = HttpClients.createDefault();

	public void run() {
		//System.out.println(Thread.currentThread().getName() + "start");
		try {
			HttpGet httpget = new HttpGet(url);
			HttpHost proxy = new HttpHost("proxy.houston.hp.com", 8080, "http");
			RequestConfig config = RequestConfig.custom().setProxy(proxy)
					.build();
			httpget.setConfig(config);
			//System.out.println("Executing request " + httpget.getRequestLine());
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				public String handleResponse(final HttpResponse response)
						throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity)
								: null;
					} else {
						throw new ClientProtocolException(
								"Unexpected response status: " + status);
					}
				}
			};
			String responseBody = httpclient.execute(httpget, responseHandler);
			//System.out.println("---------------------------");
			//System.out.println(responseBody);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		HttpLoadTest.minusCounts();
		//System.out.println(Thread.currentThread().getName() + "end");
	}

}
