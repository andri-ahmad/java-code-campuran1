package util;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


/**
 * @author JVANHOOF
 *  Created 11/26/14
 */
public class ConstraintsConsoleDump {
	
	// variables
	private Document document = null;
	private DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	private DocumentBuilder documentBuilder = null;
	private Element element = null;
	private NodeList nodeList = null; //parent nodes
	private NodeList subNodeList = null; //child nodes
	
	/**
	 * The ConstraintsConsoleDump.dumpConstraints method displays which elements in a Constraints Value Object are required
	 * @param requiredOnly - true = show only elements that are required, false = show all elements
	 * @param xml - Use the toXml() method of the Constraints Value Object
	 * Example: constraintsDump.dumpConstraints(true, customerConstraintsVO.toXml());
	 */
	public void dumpConstraints (Boolean requiredOnly, String xml) {
		try {
			// get an instance of document builder using factory
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			// parse using builder to get DOM representation of the XML
			document = documentBuilder.parse(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		// get the root element
		element = document.getDocumentElement();
		System.out.println(element.getNodeName());
		
		// get all the children of top parent
		nodeList = element.getChildNodes();
		
		// process all nodes
		for (int nl1 = 0; nl1 < nodeList.getLength(); nl1++) {
			if (nodeList.item(nl1).getNodeName() != String.valueOf("#text") ) {
				subNodeList = nodeList.item(nl1).getChildNodes();
				for (int nl2 = 0; nl2 < subNodeList.getLength(); nl2++) {
					if (subNodeList.item(nl2).getNodeName() == String.valueOf("required")) {
						if (requiredOnly == true) {
							if (subNodeList.item(nl2).getFirstChild().getNodeValue().equals("true")) {
								System.out.println(nodeList.item(nl1).getNodeName() + "." + 
										 		   subNodeList.item(nl2).getNodeName() + "=" + 
										 		   subNodeList.item(nl2).getFirstChild().getNodeValue());
							}
						}
						else {
							System.out.println(nodeList.item(nl1).getNodeName() + "." + 
									 		   subNodeList.item(nl2).getNodeName() + "=" + 
									 		   subNodeList.item(nl2).getFirstChild().getNodeValue());
						}
					}
				}
			}
		} 
	}

}
