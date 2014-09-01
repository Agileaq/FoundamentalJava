package tcpip;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class InetAddressExample {
	public static void main(String[] args) {
		try {
			Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
			if(interfaceList == null) {
				System.out.println("No interfaces found!");
			}else {
				while(interfaceList.hasMoreElements()) {
					NetworkInterface iface = interfaceList.nextElement();
					System.out.println("Interface " + iface.getName() + ":");
					Enumeration<InetAddress> addrList = iface.getInetAddresses();
					if(!addrList.hasMoreElements()) {
						System.out.println("No address for the interfaces found!");
					}
					while(addrList.hasMoreElements()) {
						InetAddress address = addrList.nextElement();
						System.out.println("\tAddress " + 
						((address instanceof Inet4Address ? 
								"(v6)" : (address instanceof Inet6Address ? "(v6)" : "(?)"))));
						System.out.println(": " + address.getHostAddress());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(String host : args) {
			try {
				System.out.println(host + ":");
				InetAddress[] addressList = InetAddress.getAllByName(host);
				for(InetAddress address : addressList) {
					System.out.println("\t" + address.getHostName() + "/" + address.getHostAddress());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
