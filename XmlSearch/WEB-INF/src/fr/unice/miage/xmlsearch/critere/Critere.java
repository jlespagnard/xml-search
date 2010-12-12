package fr.unice.miage.xmlsearch.critere;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public abstract class Critere {
	/**
	 * retrieves a search criterion that matches the name passed as parameter
	 * 
	 * @param p_nomCritere	name
	 * @return	the criterion of research <code>p_nomCritere</code>
	 */
	public abstract String[] get(String p_nomCritere);
}