package tcpip.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPEchoServer {
	public static void main(String args[]) throws IOException {
		ServerSocket socketServer = new ServerSocket(62222);
		System.out.println("socket server started");
		boolean flag = true;
		while(flag) {
			Socket socket = socketServer.accept();
			System.out.println("socket server get one socket: " + socket.getInetAddress().getCanonicalHostName());
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			byte[] data = new byte[2];
			int len = 0;
			String result = "";
			while((len = is.read(data)) != -1) {
				result += new String(data);
				if(result.endsWith("end")){
					break;
				}
			}
			System.out.println("Server received " + result);
			os.write(result.getBytes());
			os.flush();
			os.close();
			is.close();
			socket.close();
			System.out.println("socket end");
		}
		socketServer.close();
		System.out.println("socket server end");
	}
}
