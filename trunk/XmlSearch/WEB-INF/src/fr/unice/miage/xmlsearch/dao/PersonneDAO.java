package fr.unice.miage.xmlsearch.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import fr.unice.miage.xmlsearch.critere.Critere;
import fr.unice.miage.xmlsearch.critere.PersonneCritere;
import fr.unice.miage.xmlsearch.objets.Personne;
import fr.unice.miage.xmlsearch.utils.Utils;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class PersonneDAO extends DAO{
	
	/**
	 * Constructeur
	 * @param p_contexte contexte
	 */
	protected PersonneDAO(String p_contexte) {
		super(p_contexte);
	}

	@Override
	public List<Object> rechercher(Critere p_critere) {
		List<Object> liste = null;
		String params = Utils.getParams(p_critere, PersonneCritere.ID, PersonneCritere.NOM, PersonneCritere.PRENON, PersonneCritere.EMAIL, PersonneCritere.CENTREAFFILIE);
		String query = m_contexte+"recherchePersonne.xqy";
		if(!params.isEmpty())
			query += "?" + params;
		Document doc = Utils.getResultatRequete(query);
		if(doc != null)
		{
			List<Map<String, String>> result = new LinkedList<Map<String,String>>();
			Utils.lireXml(doc.getDocumentElement(), result);
			liste = new LinkedList<Object>();
			Personne pers;
			for (Map<String, String> infoPers : result) {
				pers = new Personne(infoPers.get("id"), infoPers.get("nom"), infoPers.get("prenom"), infoPers.get("email"), infoPers.get("idCentreAffilie"));
				liste.add(pers);
			}
		}
		return liste;
	}

	@Override
	public int count(Critere p_critere) {
		// TODO
		return 0;
	}
}
