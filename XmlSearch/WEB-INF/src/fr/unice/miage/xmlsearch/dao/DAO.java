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
	
	/**
	 * application context
	 */
	private String m_contexte;
	
	/**
	 * @param p_contexte application context
	 */
	protected DAO(String p_contexte) {
		this.m_contexte = p_contexte;
	}
	
	/**
	 * @return the execution context of XQuery
	 */
	protected String getContexte() {
		return this.m_contexte;
	}
	
	/**
	 * @param p_nomQuery	the name of the query to execute
	 * @param p_critere		search criteria
	 * @param p_nomParams	name of search parameters
	 * @return	the query to execute
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