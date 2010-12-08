package fr.unice.miage.xmlsearch.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fr.unice.miage.xmlsearch.critere.Critere;
import fr.unice.miage.xmlsearch.critere.ParticipantCritere;
import fr.unice.miage.xmlsearch.objets.Participant;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class ParticipantDAO extends DAO{

	/**
	 * Constructeur
	 * @param p_contexte contexte
	 */
	protected ParticipantDAO(String p_contexte) {
		super(p_contexte);
	}

	@Override
	public List<Object> rechercher(Critere p_critere) {
		
		List<Object> liste = null;
		
		List<Map<String, String>> results = super.getResultatsRequete("rechercheParticipant.xqy", 
				p_critere, ParticipantCritere.AFFILIATION, ParticipantCritere.CATEGORYPRO, ParticipantCritere.FISRTNAME, 
				ParticipantCritere.HDR, ParticipantCritere.LASTNAME, ParticipantCritere.MOREINFO, ParticipantCritere.RESEARCHCENTRE);

		if(results != null)
		{
			liste = new LinkedList<Object>();
			Participant participant;
			for (Map<String, String> infoPart : results) {
				participant = new Participant(infoPart.get("firstname"), infoPart.get("lastname"), infoPart.get("affiliation"), infoPart.get("categoryPro"), infoPart.get("researchcentre"), infoPart.get("moreinfo"), infoPart.get("hdr"));
				liste.add(participant);
			}
		}
		
		return liste;
	}

	@Override
	public int count(Critere p_critere) {
		// TODO Auto-generated method stub
		return 0;
	}

}
