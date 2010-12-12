package fr.unice.miage.xmlsearch.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import fr.unice.miage.xmlsearch.critere.ThemeCritere;
import fr.unice.miage.xmlsearch.utils.Constantes;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class ThemeDAO extends DAO{

	/**
	 * @param p_contexte application context
	 */
	public ThemeDAO(String p_contexte) {
		super(p_contexte);
	}

	/**
	 * number of projects by theme for a year
	 * @param p_annee year
	 * @return list of number of projects by theme
	 */
	public Map<String, String> getThemeParAnnee(String p_annee) {
		
		Map<String, String> retour = null;
		
		ThemeCritere critere = new ThemeCritere(null, null, null, new String[]{p_annee});
		List<Map<String, String>> results = super.getResultatsRequete("getThemesParAnnee.xqy", critere, Constantes.Theme.ANNEE.getLabel());
		
		if(results != null && !results.isEmpty()) {
			retour = new LinkedHashMap<String, String>();
			String theme = null, nbTheme = null;
			for (Map<String, String> result : results) {
				for(String key : result.keySet()) {
					if(theme == null) {
						theme = result.get(key);
					}
					else if(nbTheme == null) {
						nbTheme = result.get(key);
					}
					if(theme != null && nbTheme != null) {
						retour.put(theme, nbTheme);
						theme = null;
						nbTheme = null;
					}
				}
			}
		}		
		return retour;
	}
}