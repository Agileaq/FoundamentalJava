package arc;

public class CreditAndLoan {
	
	public static void main(String args[]) {
		double money = 100;
		double total = 100;
		
		for(int i=0;i<1000000;i++) {
			money = money*0.9;
			total = total + money; 
		}
		System.out.println(total);
	}
}
