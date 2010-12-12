package fr.unice.miage.xmlsearch.tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import fr.unice.miage.xmlsearch.critere.ProjetCritere;
import fr.unice.miage.xmlsearch.dao.ProjetDAO;
import fr.unice.miage.xmlsearch.objets.Participant;
import fr.unice.miage.xmlsearch.objets.Projet;

public class TestProjetDAO_TJU {

	@Test
	public void testRechercherProjet() {
		ProjetDAO dao = new ProjetDAO("http://localhost:8086/exist/rest/db/Raweb/query/");
		boolean fullInfos = false;
		ProjetCritere critere = new ProjetCritere(null, null, null, new String[]{"2009"}, fullInfos);
		List<Projet> projets = dao.rechercherProjet(critere, fullInfos);
		assertNotNull(projets);
		assertFalse(projets.isEmpty());
		
		for(Projet projet : projets) {
			assertNotNull(projet.getShortName());
			assertFalse(projet.getShortName().isEmpty());
			assertNotNull(projet.getNom());
			assertFalse(projet.getNom().isEmpty());
			assertNotNull(projet.getTheme());
			assertFalse(projet.getTheme().isEmpty());
			System.out.println(this.afficherProjet(projet, fullInfos));
		}
	}

	private String afficherProjet(Projet projet, boolean fullInfos) {
		StringBuilder retour = new StringBuilder();
		retour.append("Projet :\n");
		retour.append("\tShort Name : " + projet.getShortName() + "\n");
		retour.append("\tProject Name : " + projet.getNom() + "\n");
		retour.append("\tTheme : " + projet.getTheme() + "\n");
		if(fullInfos) {
			retour.append("\tPresentation : " + projet.getPresentation() + "\n");
			retour.append("\tLogiciels : " + projet.getLogiciels() + "\n");
			retour.append("\tResultats : " + projet.getResultats() + "\n");
			retour.append("\tContrats : " + projet.getContrats() + "\n");
		}
		retour.append("\n");
		return retour.toString();
	}

	@Test
	public void testGetProjet() {
		ProjetDAO dao = new ProjetDAO("http://localhost:8086/exist/rest/db/Raweb/query/");
		Projet projet = dao.getProjet("aces", "2009");
		assertNotNull(projet);
		
		assertNotNull(projet.getShortName());
		assertFalse(projet.getShortName().isEmpty());
		assertNotNull(projet.getNom());
		assertFalse(projet.getNom().isEmpty());
		assertNotNull(projet.getTheme());
		assertFalse(projet.getTheme().isEmpty());
		assertNotNull(projet.getPresentation());
		assertFalse(projet.getPresentation().isEmpty());
		assertNotNull(projet.getLogiciels());
		assertFalse(projet.getLogiciels().isEmpty());
		assertNotNull(projet.getResultats());
		assertFalse(projet.getResultats().isEmpty());
		assertNotNull(projet.getContrats());
		assertFalse(projet.getContrats().isEmpty());
		System.out.println(this.afficherProjet(projet, true));
	}

	@Test
	public void testGetParticipantsProjet() {
		ProjetDAO dao = new ProjetDAO("http://localhost:8086/exist/rest/db/Raweb/query/");
		List<Participant> liste = dao.getParticipantsProjet("abs", "2009");
		assertNotNull(liste);
		assertFalse(liste.isEmpty());	
	}
	
	@Test
	public void testGetRepartitionCategories() {
		ProjetDAO dao = new ProjetDAO("http://localhost:8086/exist/rest/db/Raweb/query/");
		Map<String, String> liste = dao.getRepartitionCategories("aces", "2009");
		assertNotNull(liste);
		assertFalse(liste.isEmpty());
	}
}
