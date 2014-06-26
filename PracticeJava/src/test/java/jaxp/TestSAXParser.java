package jaxp;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class TestSAXParser {

	/*
	 * <!-- SAX events fire, 1. open element tags are encountered in your
	 * document 2. close element tags are encountered in your document 3.
	 * #PCDATA and CDATA sections are encountered in your document 4. processing
	 * instructions, comments, entity declarations, are encountered in your
	 * document. -->
	 * 
	 * <!-- Three steps to using SAX 1. Creating a custom object model (like
	 * Person and AddressBook classes) 2. Creating a SAX parser 3. Creating a
	 * DocumentHandler (to turn your XML document into instances of your custom
	 * object model). -->
	 */
	@Test
	public void testSAXParser() throws SAXException, IOException {
		InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream("SAXLearn.xml");
		InputSource input = new InputSource(is);

		MyContentHandler handler = new MyContentHandler();// my handler
		String parserClassName = "com.sun.org.apache.xerces.internal.parsers.SAXParser";
		XMLReader xmlReader = XMLReaderFactory.createXMLReader(parserClassName);
		xmlReader.setContentHandler(handler);
		xmlReader.parse(input);
		AddressBook addBook = handler.getAb();

		InputStream is2 = this.getClass().getClassLoader()
				.getResourceAsStream("SAXLearn.xml");
		BufferedReader br = new BufferedReader(new InputStreamReader(is2));
		String line;
		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine()) != null) {
			sb.append(line);
			sb.append("\n");
		}
		
		String actual = addBook.toXML();
		String expected = sb.toString();
		assertThat(actual, equalTo(expected));
	}
}
