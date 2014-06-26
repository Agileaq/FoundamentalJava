package jaxp;

public class Person {
	
	private String fname;
	private String lname;
	private String company;
	private String email;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toXML() {
		String personxml = "\t<person>\n" + "\t\t<lastname>" + lname + "</lastname>\n"
				+ "\t\t<firstname>" + fname + "</firstname>\n"
				+ "\t\t<company>" + company + "</company>\n"
				+ "\t\t<email>" + email + "</email>\n"
				+ "\t</person>";
		return personxml;
	}
}
