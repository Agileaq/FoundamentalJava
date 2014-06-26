package jaxp;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * You can think of this process as a document -> event -> method -> object
 * model mapping. You have to provide the document and the object model and the
 * method handler. SAX only takes care of the event generation and method
 * invocation (on your handler implementations).
 */
public class MyContentHandler extends DefaultHandler {

	private AddressBook ab = new AddressBook();
	private Person p;
	private String currentElement;
	public AddressBook getAb() {
		return ab;
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		if (qName.equalsIgnoreCase("lastname")) {
			currentElement = "lastname";
		} else if (qName.equalsIgnoreCase("firstname")) {
			currentElement = "firstname";
		} else if (qName.equalsIgnoreCase("company")) {
			currentElement = "company";
		} else if (qName.equalsIgnoreCase("email")) {
			currentElement = "email";
		} else if (qName.equalsIgnoreCase("person")) {
			p = new Person();
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if( qName.equalsIgnoreCase("person")) {
			ab.addPerson(p);
			p = null;
		}
	}
	
	@Override
    public void characters (char ch[], int start, int length)
            throws SAXException {
		String value = new String(ch, start, length);
		if(!value.trim().equals("")) {
			if (currentElement.equalsIgnoreCase("lastname")) {
				p.setLname(value);
			} else if (currentElement.equalsIgnoreCase("firstname")) {
				p.setFname(value);
			} else if (currentElement.equalsIgnoreCase("company")) {
				p.setCompany(value);
			} else if (currentElement.equalsIgnoreCase("email")) {
				p.setEmail(value);
			}
		}
	}
}
