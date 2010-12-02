package fr.unice.miage.xmlsearch.dao;

import java.util.List;

import fr.unice.miage.xmlsearch.critere.Critere;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public abstract class DAO {
	/**
	 * Effectue une recherche selon le crit&egrave;re de recherche pass&eacute;s en param&egrave;tre.
	 * 
	 * @param p_critere	contient les crit&egrave;res de recherche
	 * @return	le resultat de la recherche
	 */
	public abstract List<Object> rechercher(Critere p_critere);
	/**
	 * Compte le nombre de resultats obtenus selon le crit&egrave;re de recherche pass&eacute;s en param&egrave;tre.
	 * 
	 * @param p_critere	contient les crit&egrave;res de recherche
	 * @return	le nombre de resultats obtenus
	 */
	public abstract int count(Critere p_critere);
}