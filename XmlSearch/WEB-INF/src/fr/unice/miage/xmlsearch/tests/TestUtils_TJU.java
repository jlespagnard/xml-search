package fr.unice.miage.xmlsearch.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import fr.unice.miage.xmlsearch.utils.Utils;

public class TestUtils_TJU {

	@Test
	public void testGetResultatRequete() {
		// TODO
	}

	@Test
	public void testLireXml() {
		File xmlTestFile = new File("WEB-INF/src/fr/unice/miage/xmlsearch/tests/XmlTestFile.xml");
		List<Map<String, String>> test = new LinkedList<Map<String,String>>();
		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document xmlDoc = builder.parse(xmlTestFile);
			
			Utils.lireXml(xmlDoc.getDocumentElement(), test);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<Map<String, String>> resultat = new LinkedList<Map<String,String>>();
		Map<String, String> infos = new LinkedHashMap<String, String>();
		infos.put("nom", "Test 1");
		infos.put("valeur", "1");
		resultat.add(infos);
		infos = new LinkedHashMap<String, String>();
		infos.put("nom", "Test 2");
		infos.put("valeur", "2");
		resultat.add(infos);
		infos = new LinkedHashMap<String, String>();
		infos.put("nom", "Test 3");
		infos.put("valeur", "3");
		resultat.add(infos);
		
		assertTrue(resultat.size() == test.size());
		for(Map<String, String> infosTest : test) {
			infos = resultat.get(test.indexOf(infosTest));
			
			assertTrue(infos.size() == infosTest.size());
			
			for(Map.Entry<String, String> contenuInfosTest : infosTest.entrySet()) {
				assertTrue(infos.containsKey(contenuInfosTest.getKey()));
				assertTrue(infos.get(contenuInfosTest.getKey()).equalsIgnoreCase(contenuInfosTest.getValue()));
			}
		}
	}

	@Test
	public void testGetParams() {
		// TODO
	}
}