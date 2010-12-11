package fr.unice.miage.xmlsearch.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fr.unice.miage.xmlsearch.critere.ConferenceCritere;
import fr.unice.miage.xmlsearch.critere.ThemeCritere;
import fr.unice.miage.xmlsearch.objets.Conference;
import fr.unice.miage.xmlsearch.objets.Theme;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class ThemeDAO extends DAO{

	/**
	 * Constructeur
	 * @param p_contexte contexte
	 */
	public ThemeDAO(String p_contexte) {
		super(p_contexte);
	}

	public List<Theme> getThemeParAnnee(String p_annee) {
		
		ThemeCritere critere = new ThemeCritere(null, null, null, new String[]{p_annee});
		List<Map<String, String>> results = super.getResultatsRequete("getThemesParAnnee.xqy", critere, ThemeCritere.ANNEE);
		List<Theme> themes = null;
		
		if(results != null && !results.isEmpty()) {
			themes = new LinkedList<Theme>();
			Theme theme;
			for (Map<String, String> infosTheme : results) {
				theme = new Theme(infosTheme.get(ThemeCritere.ID), infosTheme.get(ThemeCritere.LIBELLE), 
						infosTheme.get(ThemeCritere.LIEU), infosTheme.get(ThemeCritere.ANNEE));
				
				themes.add(theme);
			}
		}
		
		return themes;
	}
}