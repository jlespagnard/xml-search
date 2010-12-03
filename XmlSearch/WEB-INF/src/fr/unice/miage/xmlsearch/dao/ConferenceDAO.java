package fr.unice.miage.xmlsearch.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import fr.unice.miage.xmlsearch.critere.ConferenceCritere;
import fr.unice.miage.xmlsearch.critere.Critere;
import fr.unice.miage.xmlsearch.objets.Conference;
import fr.unice.miage.xmlsearch.utils.Utils;

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
	
	@Override
	public List<Object> rechercher(Critere p_critere) {
		List<Object> conferences = null;
		
		String query = this.m_contexte + "rechercheConference.xqy";
		
		String params = Utils.getParams(p_critere, ConferenceCritere.TITRE, ConferenceCritere.LIEU, ConferenceCritere.PAYS, ConferenceCritere.ANNEE);
		if(!params.isEmpty()) {
			query += "?" + params;
		}
		
		Document docQueryResult = Utils.getResultatRequete(query);
		if(docQueryResult != null) {
			List<Map<String, String>> results = new LinkedList<Map<String,String>>(); 
			Utils.lireXml(docQueryResult.getDocumentElement(), results);
			
			conferences = new LinkedList<Object>();
			Conference conf;
			for (Map<String, String> infosConf : results) {
				conf = new Conference(infosConf.get("Titre"), infosConf.get("Lieu"), infosConf.get("Pays"), infosConf.get("Annee"));
				conferences.add(conf);
			}
		}
		
		return conferences;
	}

	@Override
	public int count(Critere p_critere) {
		// TODO Auto-generated method stub
		return 0;
	}
}
