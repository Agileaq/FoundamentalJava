package testjaxp;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class TestDOMParser {

	@Test
	public void testDOMParser() throws Exception{
		
		InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream("SAXLearn.xml");
		InputSource input = new InputSource(is);
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(input);
		System.out.println(doc);
		
	}
	
}
