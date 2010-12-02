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

	private String getParametres(Critere p_critere) {
		StringBuilder params = new StringBuilder();
		
		List<String> criteres = p_critere.get(ConferenceCritere.TITRES);
		boolean estPremier = true;
		if(criteres != null && !criteres.isEmpty()) {
			for(String critere : criteres) {
				if(!estPremier) {
					params.append("&");
					estPremier = false;
				}
				params.append("titre=" + critere);
			}
		}
		
		criteres = p_critere.get(ConferenceCritere.LIEUX);
		estPremier = true;
		if(criteres != null && !criteres.isEmpty()) {
			for(String critere : criteres) {
				if(!estPremier) {
					params.append("&");
					estPremier = false;
				}
				params.append("lieu=" + critere);
			}
		}
		
		criteres = p_critere.get(ConferenceCritere.PAYS);
		estPremier = true;
		if(criteres != null && !criteres.isEmpty()) {
			for(String critere : criteres) {
				if(!estPremier) {
					params.append("&");
					estPremier = false;
				}
				params.append("pays=" + critere);
			}
		}
		
		criteres = p_critere.get(ConferenceCritere.ANNEES);
		estPremier = true;
		if(criteres != null && !criteres.isEmpty()) {
			for(String critere : criteres) {
				if(!estPremier) {
					params.append("&");
					estPremier = false;
				}
				params.append("annee=" + critere);
			}
		}
		
		return params.toString();
	}
	
	@Override
	public List<Object> rechercher(Critere p_critere) {
		List<Object> conferences = null;
		String params = this.getParametres(p_critere);
		
		String query = this.m_contexte + "rechercheConference.xqy";
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
