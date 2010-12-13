package fr.unice.miage.xmlsearch.tests;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import fr.unice.miage.xmlsearch.dao.ThemeDAO;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class TestThemeDAO_TJU {

	/**
	 * Test of GetThemeParAnnee of ThemeDAO
	 */
	@Test
	public void testGetThemeParAnnee() {
		ThemeDAO dao = new ThemeDAO("http://localhost:8086/exist/rest/db/Raweb/query/");
		Map<String,String> liste = dao.getThemeParAnnee("2009");
		assertNotNull(liste);
		assertFalse(liste.isEmpty());
	}
}