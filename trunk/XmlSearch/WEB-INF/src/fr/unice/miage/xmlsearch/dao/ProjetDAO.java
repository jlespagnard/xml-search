package fr.unice.miage.xmlsearch.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fr.unice.miage.xmlsearch.critere.Critere;
import fr.unice.miage.xmlsearch.critere.ParticipantCritere;
import fr.unice.miage.xmlsearch.critere.ProjetCritere;
import fr.unice.miage.xmlsearch.objets.Participant;
import fr.unice.miage.xmlsearch.objets.Projet;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class ProjetDAO extends DAO{
	
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
				ProjetCritere.SHORT_NAME, ProjetCritere.NOM, ProjetCritere.ANNEE, ProjetCritere.THEME, 
				ProjetCritere.FULL_INFOS);
		
		if(results != null) {
			projets = new LinkedList<Projet>();
			Projet projet;
			for(Map<String, String> infosProjet : results) {
				projet = new Projet(infosProjet.get(ProjetCritere.SHORT_NAME), 
						infosProjet.get(ProjetCritere.NOM), infosProjet.get(ProjetCritere.THEME), 
						infosProjet.get(ProjetCritere.ANNEE), infosProjet.get(ProjetCritere.OBJECTIF));
				
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
				critere, ProjetCritere.SHORT_NAME, ProjetCritere.ANNEE);
		
		if(results != null) {
			participants = new LinkedList<Participant>();
			Participant participant;
			for(Map<String, String> infosParticipant : results) {
				participant = new Participant(infosParticipant.get(ParticipantCritere.FISRTNAME), 
						infosParticipant.get(ParticipantCritere.LASTNAME), infosParticipant.get(ParticipantCritere.AFFILIATION), 
						infosParticipant.get(ParticipantCritere.CATEGORYPRO), infosParticipant.get(ParticipantCritere.RESEARCHCENTRE), 
						infosParticipant.get(ParticipantCritere.MOREINFO), infosParticipant.get(ParticipantCritere.HDR));
				
				participants.add(participant);
			}
		}
		
		return participants;
	}
}