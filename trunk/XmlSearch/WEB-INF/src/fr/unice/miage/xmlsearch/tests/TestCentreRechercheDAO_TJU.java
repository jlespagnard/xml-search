package fr.unice.miage.xmlsearch.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fr.unice.miage.xmlsearch.dao.CentreRechercheDAO;
import fr.unice.miage.xmlsearch.objets.CentreRecherche;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class TestCentreRechercheDAO_TJU {

	/**
	 * Test of GetCentresRecherche of CentreRechercheDAO
	 */
	@Test
	public void testGetCentresRecherche() {
		CentreRechercheDAO dao = new CentreRechercheDAO("http://localhost:8086/exist/rest/db/Raweb/query/");
		List<CentreRecherche> liste = dao.getCentresRecherche();
		assertNotNull(liste);
		assertFalse(liste.isEmpty());
	}
	
	/**
	 * Test of GetMembresCR of CentreRechercheDAO
	 */
	@Test
	public void testGetMembresCR(){
		CentreRechercheDAO dao = new CentreRechercheDAO("http://localhost:8086/exist/rest/db/Raweb/query/");
		List<String> liste = dao.getMembresCR("8");
		assertNotNull(liste);
		assertFalse(liste.isEmpty());
	}
}