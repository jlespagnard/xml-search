package fr.unice.miage.xmlsearch.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fr.unice.miage.xmlsearch.critere.ProjetCritere;
import fr.unice.miage.xmlsearch.dao.ProjetDAO;
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
			this.afficherProjet(projet, fullInfos);
		}
	}

	private void afficherProjet(Projet projet, boolean fullInfos) {
		System.out.println("Projet :");
		System.out.println("\tShort Name : " + projet.getShortName());
		System.out.println("\tProject Name : " + projet.getNom());
		System.out.println("\tTheme : " + projet.getTheme());
		if(fullInfos) {
			System.out.println("\tPresentation : " + projet.getPresentation());
			System.out.println("\tLogiciels : " + projet.getLogiciels());
			System.out.println("\tResultats : " + projet.getResultats());
			System.out.println("\tContrats : " + projet.getContrats());
		}
		System.out.println();
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
		this.afficherProjet(projet, true);
	}

	@Test
	public void testGetParticipantsProjet() {
		// TODO
	}

}
