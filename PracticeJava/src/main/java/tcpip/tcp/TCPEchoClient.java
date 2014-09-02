package tcpip.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPEchoClient {
	public static void main(String args[]) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 62222);
		InputStream is = socket.getInputStream();
		//BufferedReader br = new BufferedReader(new InputStreamReader(is));
		OutputStream os = socket.getOutputStream();
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
		String dataOut = "test socket client aaabbbccc end";
		os.write(dataOut.getBytes());
		os.flush();
		System.out.println("client data send out");
		byte[] dataIn = new byte[50];
		String result = "";
		int len = 0;
		while((len = is.read(dataIn)) != -1) {
			result += new String(dataIn, 0 , len);
			if(result.endsWith("end")) {
				break;
			}
		}
		System.out.println("Client received the server returned data £º " + result);
		is.close();
		os.close();
		socket.close();
	}
}
