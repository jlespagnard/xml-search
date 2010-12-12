package fr.unice.miage.xmlsearch.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fr.unice.miage.xmlsearch.dao.CentreRechercheDAO;
import fr.unice.miage.xmlsearch.objets.CentreRecherche;

public class TestCentreRechercheDAO_TJU {

	@Test
	public void testGetCentresRecherche() {
		CentreRechercheDAO dao = new CentreRechercheDAO("http://localhost:8086/exist/rest/db/Raweb/query/");
		List<CentreRecherche> liste = dao.getCentresRecherche();
		assertNotNull(liste);
		assertFalse(liste.isEmpty());
		assertTrue(liste.size() == 74);		
		assertTrue(liste.get(1).getId().compareTo("1") == 0);
		assertTrue(liste.get(1).getLibelle().compareTo("CRI Bordeaux") == 0);
		assertTrue(liste.get(1).getLatitude().compareTo("44.807946") == 0);
		assertTrue(liste.get(1).getLongitude().compareTo("-0.596811") == 0);
	}

}
