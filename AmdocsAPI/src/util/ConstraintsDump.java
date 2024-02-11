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

import util.PrintOutput;

/**
 * @author JVANHOOF
 *  Created 11/26/14
 */
public class ConstraintsDump {
	
	
	// variables
	private Document document = null;
	private DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	private DocumentBuilder documentBuilder = null;
	private Element element = null;
	private NodeList nodeList = null; //parent nodes
	private NodeList subNodeList = null; //child nodes
	
	/**
	 * The ConstraintsDump.dumpConstraints method displays which elements in a Constraints Value Object are required
	 * @param apiParams - Parameters instance
	 * @param printOutput - PrintOutput instance
	 * @param requiredOnly - true = show only elements that are required, false = show all elements
	 * @param xml - Use the toXml() method of the Constraints Value Object
	 * Example: constraintsDump.dumpConstraints(apiParams, printOutput, true, customerConstraintsVO.toXml());
	 */
	 public void dumpConstraints (Parameters apiParams, PrintOutput printOutput, Boolean requiredOnly, String xml) {
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
		printOutput.printToShell(apiParams, element.getNodeName() + ": Constraints Dump - requiredOnly flag = " + requiredOnly, null);
		
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
								printOutput.printToShell(apiParams, 
										 				 nodeList.item(nl1).getNodeName() + "." + 
										 				 subNodeList.item(nl2).getNodeName() + "=" + 
										 				 subNodeList.item(nl2).getFirstChild().getNodeValue(), 
										 				 null);
							}
						}
						else {
							printOutput.printToShell(apiParams, 
									 				 nodeList.item(nl1).getNodeName() + "." + 
									 				 subNodeList.item(nl2).getNodeName() + "=" + 
									 				 subNodeList.item(nl2).getFirstChild().getNodeValue(), 
									 				 null);
						}
					}
				}
			}
		} 
	} 
}
