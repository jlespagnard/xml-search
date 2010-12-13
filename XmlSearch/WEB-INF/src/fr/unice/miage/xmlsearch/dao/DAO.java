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
	
	/** The application context */
	private String m_contexte;
	
	/**
	 * @param p_contexte The application context
	 */
	protected DAO(String p_contexte) {
		this.m_contexte = p_contexte;
	}
	
	/**
	 * @return The execution context of XQuery
	 */
	protected String getContexte() {
		return this.m_contexte;
	}
	
	/**
	 * @param p_nomQuery	The name of the query to execute
	 * @param p_critere		Search criteria
	 * @param p_nomParams	Name of search parameters
	 * @return	List containing the names of elements found in the XML response and the content of these elements
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