package tcpip.udp;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClientTimeout {
	private static final int TIMEOUT = 3000;
	private static final int MAXTRIES = 5;
	public static void main(String args[]) throws Exception {
		InetAddress serverAddress = InetAddress.getByName("localhost");
		System.out.println(serverAddress.getCanonicalHostName());
		byte[] bytesToSend = "Bytes to send Test".getBytes();
		int servPort = 3131;
		DatagramSocket socket = new DatagramSocket(servPort);
		socket.setSoTimeout(TIMEOUT);
		DatagramPacket sendPacket = new DatagramPacket(bytesToSend, bytesToSend.length, serverAddress, servPort);
		DatagramPacket receivePacket = new DatagramPacket(new byte[bytesToSend.length], bytesToSend.length);
		int tries = 0;
		boolean receivedResponse = false;
		do {
			socket.send(sendPacket);
			try {
				socket.receive(receivePacket);
				if(!receivePacket.getAddress().equals(serverAddress)) {
					throw new IOException("Received packet from unknown source");
				}
				receivedResponse = true;
			} catch(InterruptedIOException e) {
				tries += 1;
				System.out.println("Timed out, " + (MAXTRIES - tries) + "more times...");
			}
		} while((!receivedResponse) && (tries < MAXTRIES));
		if(receivedResponse) {
			System.out.println("Received: " + new String(receivePacket.getData()));
		} else {
			System.out.println("No response -- giving up");
		}
		socket.close();
	}
}
