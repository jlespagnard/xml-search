package fr.unice.miage.xmlsearch.critere;

import fr.unice.miage.xmlsearch.utils.Constantes;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class ConferenceCritere extends Critere {
	/** The titles of conferences. */
	private String[] m_titres;
	/** Conference site */
	private String[] m_lieux;
	/** The codes of countries where the conferences took place */
	private String[] m_codePays;
	/** The years of conferences */
	private String[] m_annees;
	
	/**
	 * @param p_titres		Titles
	 * @param p_lieux		Places
	 * @param p_codePays 	Country code
	 * @param p_annees		Years
	 */
	public ConferenceCritere(String[] p_titres, String[] p_lieux, 
			String[] p_codePays, String[] p_annees) {
		this.m_titres = p_titres;
		this.m_lieux = p_lieux;
		this.m_codePays = p_codePays;
		this.m_annees = p_annees;
	}
	
	@Override
	public String[] get(String p_nomCritere) {
		if(p_nomCritere == null || p_nomCritere.isEmpty())
			return null;
		
		if(p_nomCritere.equalsIgnoreCase(Constantes.Conference.TITRE.getLabel()))
			return this.m_titres;
		if(p_nomCritere.equalsIgnoreCase(Constantes.Conference.LIEU.getLabel()))
			return this.m_lieux;
		if(p_nomCritere.equalsIgnoreCase(Constantes.Conference.CODE_PAYS.getLabel()))
			return this.m_codePays;
		if(p_nomCritere.equalsIgnoreCase(Constantes.Conference.ANNEE.getLabel()))
			return this.m_annees;
		
		return null;
	}
}