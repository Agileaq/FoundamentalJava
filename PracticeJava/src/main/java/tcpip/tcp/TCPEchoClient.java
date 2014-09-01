package tcpip.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPEchoClient {
	public static void main(String args[]) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 62222);
		InputStream is = socket.getInputStream();
		//BufferedReader br = new BufferedReader(new InputStreamReader(is));
		OutputStream os = socket.getOutputStream();
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
		String dataOut = "test socket client aaa";
		os.write(dataOut.getBytes());
		os.flush();
		os.close();
		byte[] dataIn = new byte[255];
		while(is.read(dataIn) != -1) {
			System.out.println(new String(dataIn));
		}
		socket.close();
	}
}
