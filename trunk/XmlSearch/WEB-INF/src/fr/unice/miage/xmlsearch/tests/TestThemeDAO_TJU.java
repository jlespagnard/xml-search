package fr.unice.miage.xmlsearch.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fr.unice.miage.xmlsearch.dao.ThemeDAO;
import fr.unice.miage.xmlsearch.objets.Theme;

public class TestThemeDAO_TJU {

	@Test
	public void testGetThemeParAnnee() {
		ThemeDAO dao = new ThemeDAO("http://localhost:8086/exist/rest/db/Raweb/query/");
		List<Theme> liste = dao.getThemeParAnnee("2006");
		assertNotNull(liste);
		assertFalse(liste.isEmpty());
		assertTrue(liste.size() == 5);	
		assertTrue(liste.get(0).getLibelle().compareTo("SYM")==0);
	}

}
