package fr.unice.miage.xmlsearch.tests;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import fr.unice.miage.xmlsearch.dao.ConferenceDAO;

public class TestConferenceDAO_TJU {

	@Test
	public void testGetNbConferencesParPays() {
		ConferenceDAO dao = new ConferenceDAO("http://localhost:8086/exist/rest/db/Raweb/query/");
		Map<String, String> liste = dao.getNbConferencesParPays("2009");
		assertNotNull(liste);
		assertFalse(liste.isEmpty());
		assertTrue(liste.size() == 63);
	}

	@Test
	public void testGetConferences() {
		// TODO
	}

}
