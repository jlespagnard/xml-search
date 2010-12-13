package fr.unice.miage.xmlsearch.dao;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fr.unice.miage.xmlsearch.critere.ConferenceCritere;
import fr.unice.miage.xmlsearch.utils.Constantes;
import fr.unice.miage.xmlsearch.objets.Conference;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class ConferenceDAO extends DAO {
	
	/**
	 * @param p_contexte The application context
	 */
	public ConferenceDAO(String p_contexte) {
		super(p_contexte);
	}
	
	/**
	 * Structure of the list back: country -> number of conferences
	 * @param p_annee	Year
	 * @return	List of number of conferences by country for the year <code>p_annee</code>
	 */
	public Map<String, String> getNbConferencesParPays(String p_annee) {
		Map<String, String> retour = null;
		
		ConferenceCritere critere = new ConferenceCritere(null, null, null, new String[]{p_annee});
		List<Map<String, String>> results = super.getResultatsRequete("getNbConferencesParPays.xqy", 
				critere, Constantes.Conference.ANNEE.getLabel());
		
		if(results != null && !results.isEmpty()) {
			retour = new LinkedHashMap<String, String>();
			String codePays = null, nbConf = null;
			for (Map<String, String> result : results) {
				for(String key : result.keySet()) {
					if(codePays == null) {
						codePays = result.get(key);
					}
					else if(nbConf == null) {
						nbConf = result.get(key);
					}
					if(codePays != null && nbConf != null) {
						retour.put(codePays, nbConf);
						codePays = null;
						nbConf = null;
					}
				}
			}
		}
		
		return retour;
	}

	/**
	 * Conferences for a list of countries and one year
	 * @param p_codePays 	Country code
	 * @param p_annee 		Year
	 * @return The list of conferences
	 */
	public List<Conference> getConferences(String p_codePays, String p_annee) {
		ConferenceCritere critere = new ConferenceCritere(null, null,new String[]{p_codePays}, new String[]{p_annee});
		List<Conference> conferences = null;
		
		List<Map<String, String>> resultats = super.getResultatsRequete("getConference.xqy", 
				critere, Constantes.Conference.CODE_PAYS.getLabel(), Constantes.Conference.ANNEE.getLabel());
		if(resultats != null && !resultats.isEmpty()) {
			conferences = new LinkedList<Conference>();
			Conference conference;
			for (Map<String, String> infosConference : resultats) {
				conference = new Conference(infosConference.get(Constantes.Conference.TITRE.getLabel().toLowerCase()), 
						infosConference.get(Constantes.Conference.LIEU.getLabel()), p_codePays, p_annee);
				
				conferences.add(conference);
			}
		}
		
		return conferences;
	}
}