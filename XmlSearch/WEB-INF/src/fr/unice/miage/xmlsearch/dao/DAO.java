package fr.unice.miage.xmlsearch.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;

import fr.unice.miage.xmlsearch.critere.Critere;
import fr.unice.miage.xmlsearch.utils.Utils;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public abstract class DAO {
	/** Le contexte de l'application. */
	private String m_contexte;
	
	/**
	 * Constructeur
	 * 
	 * @param p_contexte	le contexte de l'application
	 */
	protected DAO(String p_contexte) {
		this.m_contexte = p_contexte;
	}
	
	/**
	 * @return	le contexte d'ex&eacute;cution des Xquery
	 */
	protected String getContexte() {
		return this.m_contexte;
	}
	
	/**
	 * 
	 * @param p_nomQuery	le nom de la requ&ecirc; &agrave; ex&eacute;cuter
	 * @param p_critere		les crit&egrave;res de recherche
	 * @param p_nomParams	le nom des param&egrave;tres de recherche
	 * @return	la requ&ecirc;te &agrave; ex&eacute;cuter
	 */
	protected List<Map<String, String>> getResultatsRequete(String p_nomQuery, Critere p_critere, String... p_nomParams) {
		List<Map<String, String>> results = null;
		
		String query = this.m_contexte + p_nomQuery;
		
		String params = Utils.getParams(p_critere, p_nomParams);
		if(!params.isEmpty()) {
			query += "?" + params;
		}
		Document docQueryResult = Utils.getResultatRequete(query);
		if(docQueryResult != null) {
			results = new LinkedList<Map<String,String>>(); 
			Utils.lireXml(docQueryResult.getDocumentElement(), results);
		}
		return results;
	}
}