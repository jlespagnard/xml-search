package fr.unice.miage.xmlsearch.tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import fr.unice.miage.xmlsearch.dao.ConferenceDAO;
import fr.unice.miage.xmlsearch.objets.Conference;

public class TestConferenceDAO_TJU {

	@Test
	public void testGetNbConferencesParPays() {
		ConferenceDAO dao = new ConferenceDAO("http://localhost:8086/exist/rest/db/Raweb/query/");
		Map<String, String> liste = dao.getNbConferencesParPays("2009");
		assertNotNull(liste);
		assertFalse(liste.isEmpty());
	}

	@Test
	public void testGetConferences() {
		ConferenceDAO dao = new ConferenceDAO("http://localhost:8086/exist/rest/db/Raweb/query/");
		List<Conference> liste = dao.getConferences("DE", "2009");
		assertNotNull(liste);
		assertFalse(liste.isEmpty());
	}
}