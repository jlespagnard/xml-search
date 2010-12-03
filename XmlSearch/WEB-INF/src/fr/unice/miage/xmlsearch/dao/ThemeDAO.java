package fr.unice.miage.xmlsearch.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import fr.unice.miage.xmlsearch.critere.Critere;
import fr.unice.miage.xmlsearch.critere.ThemeCritere;
import fr.unice.miage.xmlsearch.objets.Theme;
import fr.unice.miage.xmlsearch.utils.Utils;

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
	protected ThemeDAO(String p_contexte) {
		super(p_contexte);
	}

	@Override
	public List<Object> rechercher(Critere p_critere) {
		List<Object> liste = null;
		String params = Utils.getParams(p_critere, ThemeCritere.ID, ThemeCritere.LIBELLE, ThemeCritere.LIEU, ThemeCritere.ANNEE);
		String query = m_contexte+"rechercheTheme.xqy";
		if(!params.isEmpty())
			query += "?" + params;
		Document doc = Utils.getResultatRequete(query);
		if(doc != null)
		{
			List<Map<String, String>> result = new LinkedList<Map<String,String>>();
			Utils.lireXml(doc.getDocumentElement(), result);
			liste = new LinkedList<Object>();
			Theme theme;
			for (Map<String, String> infoTheme : result) {
				theme = new Theme(infoTheme.get("id"), infoTheme.get("libelle"), infoTheme.get("lieu"), infoTheme.get("annee"));
				liste.add(theme);
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
