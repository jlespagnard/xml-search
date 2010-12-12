package fr.unice.miage.xmlsearch.tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import fr.unice.miage.xmlsearch.dao.ThemeDAO;
import fr.unice.miage.xmlsearch.objets.Theme;

public class TestThemeDAO_TJU {

	@Test
	public void testGetThemeParAnnee() {
		ThemeDAO dao = new ThemeDAO("http://localhost:8086/exist/rest/db/Raweb/query/");
		Map<String,String> liste = dao.getThemeParAnnee("2009");
		assertNotNull(liste);
		assertFalse(liste.isEmpty());
		assertTrue(liste.size() == 20);	
		assertTrue(liste.get("Computational Biology and Bioinformatics").compareTo("6")==0);
		assertTrue(liste.get("Networks and Telecommunications").compareTo("13")==0);
	}

}
