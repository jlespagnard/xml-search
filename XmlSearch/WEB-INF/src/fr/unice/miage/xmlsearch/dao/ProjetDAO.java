package fr.unice.miage.xmlsearch.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fr.unice.miage.xmlsearch.critere.Critere;
import fr.unice.miage.xmlsearch.critere.ProjetCritere;
import fr.unice.miage.xmlsearch.objets.Participant;
import fr.unice.miage.xmlsearch.objets.Projet;
import fr.unice.miage.xmlsearch.utils.Constantes;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class ProjetDAO extends DAO {
	
	/**
	 * Constructeur
	 * @param p_contexte contexte
	 */
	public ProjetDAO(String p_contexte) {
		super(p_contexte);
	}
	
	/**
	 * @param p_critere	les crit&egrave;res de recherche
	 * @param fullInfos	<code>true</code> si la totalit&eacute; des informations d'un projet
	 * 					doit &ecirc;tre r&eacute;cup&eacute;e, <code>false</code> sinon
	 * @return	la liste des projets trouv&eacute;s
	 */
	public List<Projet> rechercherProjet(Critere p_critere) {
		List<Projet> projets = null;
		
		List<Map<String, String>> results = super.getResultatsRequete("getProjet.xqy", p_critere, 
				Constantes.Projet.SHORT_NAME.getLabel(), Constantes.Projet.PROJECT_NAME.getLabel(), 
				Constantes.Projet.ANNEE.getLabel(), Constantes.Projet.THEME.getLabel(), 
				Constantes.Projet.FULL_INFOS.getLabel());
		
		if(results != null) {
			projets = new LinkedList<Projet>();
			Projet projet;
			String annee;
			for(Map<String, String> infosProjet : results) {
				annee = infosProjet.get(Constantes.Projet.ANNEE.getLabel());
				if(annee == null) {
					annee = p_critere.get(Constantes.Projet.ANNEE.getLabel())[0];
				}
				String theme = infosProjet.get(Constantes.Projet.THEME.getLabel());
				if(theme == null) {
					theme = infosProjet.get(Constantes.Projet.THEME_2009.getLabel());
				}
				projet = new Projet(infosProjet.get(Constantes.Projet.SHORT_NAME.getLabel()), 
						infosProjet.get(Constantes.Projet.PROJECT_NAME.getLabel()), theme, annee, 
						infosProjet.get(Constantes.Projet.PRESENTATION.getLabel()), infosProjet.get(Constantes.Projet.LOGICIELS.getLabel()), 
						infosProjet.get(Constantes.Projet.RESULTATS.getLabel()), infosProjet.get(Constantes.Projet.CONTRATS.getLabel()));
				
				projets.add(projet);
			}
		}
		
		return projets;
	}
	
	/**
	 * @param p_shortName	le short name du projet &agrave; r&eacute;cup&eacute;rer
	 * @param p_annee	l'ann&eacute;e du projet &agrave; r&eacute;cup&eacute;rer
	 * @return	le projet dont le short name correspond &agrave; <code>p_shortName</code>
	 */
	public Projet getProjet(String p_shortName, String p_annee) {
		ProjetCritere critere = new ProjetCritere(new String[]{p_shortName}, null, null, new String[]{p_annee}, false);
		List<Projet> projets = rechercherProjet(critere);
		
		return (projets == null || projets.isEmpty()) ? null : projets.get(0);
	}

	/**
	 * @param p_shortName	l'identifiant du projet
	 * @param p_annee		l'ann&eacute;e du projet
	 * @return	la liste des participants au projet ayant pour identifiant <code>p_shortName</code>
	 */
	public List<Participant> getParticipantsProjet(String p_shortName, String p_annee) {
		List<Participant> participants = null;
		
		ProjetCritere critere = new ProjetCritere(new String[]{p_shortName}, null, null, new String[]{p_annee}, false);
		List<Map<String, String>> results = super.getResultatsRequete("getParticipantsProjet.xqy", 
				critere, Constantes.Projet.SHORT_NAME.getLabel(), Constantes.Projet.ANNEE.getLabel());
		
		if(results != null) {
			participants = new LinkedList<Participant>();
			Participant participant;
			for(Map<String, String> infosParticipant : results) {
				participant = new Participant(infosParticipant.get(Constantes.Participant.FISRTNAME.getLabel()), 
						infosParticipant.get(Constantes.Participant.LASTNAME.getLabel()), infosParticipant.get(Constantes.Participant.AFFILIATION.getLabel()), 
						infosParticipant.get(Constantes.Participant.CATEGORYPRO.getLabel()), infosParticipant.get(Constantes.Participant.RESEARCHCENTRE.getLabel()), 
						infosParticipant.get(Constantes.Participant.MOREINFO.getLabel()), infosParticipant.get(Constantes.Participant.HDR.getLabel()));
				
				participants.add(participant);
			}
		}
		
		return participants;
	}
}