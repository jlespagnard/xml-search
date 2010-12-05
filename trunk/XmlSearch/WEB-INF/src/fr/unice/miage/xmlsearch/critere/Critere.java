package fr.unice.miage.xmlsearch.critere;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public abstract class Critere {
	/**
	 * R&eacute;cup&egrave;re un crit&egrave;re de recherche correspondant au nom pass&eacute; en param&egrave;tre.
	 * 
	 * @param p_nomCritere	le nom du critere de recherche &agrave; retourner
	 * @return	le crit&egrave; de recherche correspondant &agrave; <code>p_nomCritere</code>
	 */
	public abstract String[] get(String p_nomCritere);
}