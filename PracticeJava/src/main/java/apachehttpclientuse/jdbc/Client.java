package apachehttpclientuse.jdbc;

import java.util.ArrayList;
import java.util.List;

public class Client {

	HttpClientReadAllLuckyPhone httpClient = new HttpClientReadAllLuckyPhone();
	PhoneLuckyDAO pd = new PhoneLuckyDAO();

	public void extractDataFromlifehttpcn(String phoneNumber) throws Exception {
		// String phoneNumber = "17091950974";
		PhoneBean pb = httpClient.readLuckyInfoByPhoneNumber(phoneNumber);
		pd.insertPhoneAndLuckyInfo(pb);
	}
	
	public List<String> getAllPhoneNumbers() {
		String phoneStartNumber = "1709195";
		List<String> list = new ArrayList<String>();
		Integer digit = 0;
		while(digit < 10000) {
			System.out.println(digit);
			int length = digit.toString().length();
			String phoneNumber = null;
			if(length == 1) {
				phoneNumber = phoneStartNumber + "000" + digit;
			} else if (length == 2){
				phoneNumber = phoneStartNumber + "00" + digit;
			} else if (length == 3){
				phoneNumber = phoneStartNumber + "0" + digit;
			} else if (length == 4){
				phoneNumber = phoneStartNumber + digit;
			}
			list.add(phoneNumber);
			digit++;
		}
		return list;
	}
	
	public static void main(String args[]) throws Exception {
		Client client = new Client();
		List<String> phoneNumbers = client.getAllPhoneNumbers();
		for(String phoneNumber : phoneNumbers) {
			client.extractDataFromlifehttpcn(phoneNumber);
		}
		
//		Client client = new Client();
//		client.extractDataFromlifehttpcn("17091950020");
		
		
	}
}
