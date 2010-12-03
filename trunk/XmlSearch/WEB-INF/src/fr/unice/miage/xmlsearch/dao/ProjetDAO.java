package fr.unice.miage.xmlsearch.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import fr.unice.miage.xmlsearch.critere.Critere;
import fr.unice.miage.xmlsearch.critere.PersonneCritere;
import fr.unice.miage.xmlsearch.critere.ProjetCritere;
import fr.unice.miage.xmlsearch.objets.Personne;
import fr.unice.miage.xmlsearch.objets.Projet;
import fr.unice.miage.xmlsearch.utils.Utils;

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
		String params = Utils.getParams(p_critere, ProjetCritere.NOM, ProjetCritere.THEME, ProjetCritere.ANNEE, ProjetCritere.OBJECTIFS, ProjetCritere.PARTICIPANTS);
		String query = m_contexte+"rechercheProjet.xqy";
		if(!params.isEmpty())
			query += "?" + params;
		Document doc = Utils.getResultatRequete(query);
		if(doc != null)
		{
			List<Map<String, String>> result = new LinkedList<Map<String,String>>();
			Utils.lireXml(doc.getDocumentElement(), result);
			liste = new LinkedList<Object>();
			Projet projet;
			for (Map<String, String> infoProjet : result) {
				projet = new Projet(infoProjet.get("nom"), infoProjet.get("theme"), infoProjet.get("annee"), infoProjet.get("objectifs"), infoProjet.get("participants"));
				liste.add(projet);
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
