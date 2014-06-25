package morgantestquestions;

public class StringObjectInMemory {
	 static void print(String s1, String s2) {
		 if(s1 == s2) {
			 System.out.println("s1 == s2 true");
		 } else {
			 System.out.println("s1 == s2 false");
		 }
		 
		 if(s1.equals(s2)) {
			 System.out.println("s1.euquals(s2) true");
		 } else {
			 System.out.println("s1.euquals(s2) false");
		 }
	 }
	 
	 public static void main(String args[]) {
		 String s1 = new String("ABC");
		 String s2 = new String("ABC");
		 print(s1 , s2);
		 
		 s1 = "ABC";
		 s2 = "ABC";
		 print(s1 , s2);
		 
		 s1 += "!";
		 s2 += "!";
		 print(s1 , s2);
		 
		 s1 = "hello" + "world";
		 s2 = "hello" + "world";
		 print(s1, s2);
	 }
}
