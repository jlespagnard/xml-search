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

	@Override
	public List<Object> rechercher(Critere p_critere) {
		List<Object> liste = null;
		
		List<Map<String, String>> results = super.getResultatsRequete("rechercheProjet.xqy", 
				p_critere, ProjetCritere.NOM, ProjetCritere.THEME, ProjetCritere.ANNEE, 
				ProjetCritere.OBJECTIFS, ProjetCritere.PARTICIPANTS);

		if(results != null)
		{
			liste = new LinkedList<Object>();
			Projet projet;
			for (Map<String, String> infoProjet : results) {
				//projet = new Projet(infoProjet.get("nom"), infoProjet.get("theme"), infoProjet.get("annee"), infoProjet.get("objectifs"), infoProjet.get("participants"));
				projet = new Projet(infoProjet.get("shortName"), infoProjet.get("nom"), infoProjet.get("theme"), infoProjet.get("annee"), infoProjet.get("objectifs"), null);
				liste.add(projet);
			}
		}
		
		return liste;
	}
	
	/**
	 * @param p_shortName	l'identifiant du projet
	 * @return	la liste des participants au projet ayant pour identifiant <code>p_shortName</code>
	 */
	public List<Participant> getParticipantsProjet(String p_shortName) {
		List<Participant> participants = null;
		
		
		ProjetCritere critere = new ProjetCritere(new String[]{p_shortName}, null, null, null, null, null);
		List<Map<String, String>> results = super.getResultatsRequete("getParticipantsProjet.xqy", critere, ProjetCritere.SHORT_NAME);
		
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

	@Override
	public int count(Critere p_critere) {
		// TODO Auto-generated method stub
		return 0;
	}
}
