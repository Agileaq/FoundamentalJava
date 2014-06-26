package jaxp;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

	private List<Person> persons = new ArrayList<Person>();

	public List<Person> getPersons() {
		return persons;
	}
	
	public void addPerson(Person p) {
		persons.add(p);
	}
	
	public int getSize() {
		return persons.size();
	}
	public Person getPerson(int i) {
		return persons.get(i);
	}

	public String toXML() {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<addressbook>\n");
		for(int i = 0; i < persons.size(); i++) {
			sb.append(persons.get(i).toXML());
			sb.append("\n");
		}
		sb.append("</addressbook>\n");
		return sb.toString();
	}
	
	public static void main(String args[]) {
		Person p = new Person();
		p.setCompany("AAAComapny");
		p.setEmail("AAAEmail");
		p.setFname("AAAFname");
		p.setLname("AAALname");
		System.out.println(p.toXML());
		Person p2 = new Person();
		p2.setCompany("BBBComapny");
		p2.setEmail("BBBEmail");
		p2.setFname("BBBFname");
		p2.setLname("BBBLname");
		AddressBook addBook = new AddressBook();
		addBook.addPerson(p);
		addBook.addPerson(p2);
		System.out.println(addBook.toXML());
	}
}
