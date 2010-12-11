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
	 * @param p_contexte	le contexte de l'application
	 */
	public ConferenceDAO(String p_contexte) {
		super(p_contexte);
	}
	
	/**
	 * Structure de la liste de retour : pays -> nombre de conf&eacute;rences
	 * 
	 * @param p_annee	l'ann&eacute;e des conf&eacute;rences
	 * @return	la liste du nombre de conf&eacute;rences par pays pour l'ann&eacute;e <code>p_annee</code>
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

	public List<Conference> getConferences(String pays) {
		
		ConferenceCritere critere = new ConferenceCritere(null, null,new String[]{pays}, null);
		List<Conference> conferences = null;
		
		List<Map<String, String>> resultats = super.getResultatsRequete("getConference.xqy", critere, Constantes.Conference.CODE_PAYS.getLabel());
		
		if(resultats != null && !resultats.isEmpty()) {
			conferences = new LinkedList<Conference>();
			Conference conference;
			for (Map<String, String> infosConference : resultats) {
				conference = new Conference(infosConference.get(Constantes.Conference.TITRE.getLabel()), infosConference.get(Constantes.Conference.LIEU.getLabel()), 
						infosConference.get(Constantes.Conference.CODE_PAYS.getLabel()), infosConference.get(Constantes.Conference.ANNEE.getLabel()));
				
				conferences.add(conference);
			}
		}
		
		return conferences;
	}
}