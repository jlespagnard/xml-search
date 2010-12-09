package fr.unice.miage.xmlsearch.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import fr.unice.miage.xmlsearch.critere.ConferenceCritere;

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
		List<Map<String, String>> results = super.getResultatsRequete("getNbConferencesParPays.xqy", critere, ConferenceCritere.ANNEE);
		
		if(results != null) {
			retour = new LinkedHashMap<String, String>();
			for (Map<String, String> result : results) {
				retour.putAll(result);
			}
		}
		
		return retour;
	}
}