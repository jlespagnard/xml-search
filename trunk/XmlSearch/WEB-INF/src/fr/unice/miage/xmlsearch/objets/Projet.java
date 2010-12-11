package fr.unice.miage.xmlsearch.objets;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class Projet {
	
	/**
	 * L'identifiant du projet.
	 */
	private String m_shortName;

	/**
	 * nom du projet
	 */
	private String m_nom;
	
	/**
	 * id du theme du projet
	 */
	private String m_theme;
	
	/**
	 * année du projet
	 */
	private String m_annee;
	
	/**
	 * Pr&eacute;sentation du projets (necessaire que si on demande une info detaillée)
	 */
	private String m_presentation;
	
	/** Les logiciels utilis&eacute; dans le projet */
	private String m_logiciels;
	/** Les r&eacute;sultats du projet */
	private String m_resultats;
	/** Les contrats du projet */
	private String m_contrats;
	
	/**
	 * Construction (info détaillée)
	 * @param m_nom nom 
	 * @param m_theme theme
	 * @param m_annee année
	 * @param p_presentation objectifs
	 * @param m_participants participants
	 */
	public Projet(String p_shortName, String m_nom, String m_theme, String m_annee,
			String p_presentation, String p_logiciels, String p_resultats, String p_contrats) {
		this.m_shortName = p_shortName;
		this.m_nom = m_nom;
		this.m_theme = m_theme;
		this.m_annee = m_annee;
		this.m_presentation = p_presentation;
		this.m_logiciels = p_logiciels;
		this.m_resultats = p_resultats;
		this.m_contrats = p_contrats;
	}

	/**
	 * @return	l'identifiant du projet
	 */
	public String getShortName() {
		return this.m_shortName;
	}
	
	/**
	 * @param p_shortName	le nouvel identifiant du projet
	 */
	public void setShortName(String p_shortName) {
		this.m_shortName = p_shortName;
	}
	
	/**
	 * @return nom
	 */
	public String getNom() {
		return m_nom;
	}

	/**
	 * @param m_nom nom
	 */
	public void setNom(String m_nom) {
		this.m_nom = m_nom;
	}

	/**
	 * @return theme
	 */
	public String getTheme() {
		return m_theme;
	}

	/**
	 * @param m_theme theme
	 */
	public void setTheme(String m_theme) {
		this.m_theme = m_theme;
	}

	/**
	 * @return année
	 */ 
	public String getAnnee() {
		return m_annee;
	}

	/**
	 * @param m_annee année
	 */
	public void setAnnee(String m_annee) {
		this.m_annee = m_annee;
	}

	/**
	 * @return presentation
	 */
	public String getPresentation() {
		return this.m_presentation;
	}

	/**
	 * @param p_presentation
	 */
	public void setPresentation(String p_presentation) {
		this.m_presentation = p_presentation;
	}
	
	/**
	 * @return	les logiciels utilis&eacute;s dans le projet
	 */
	public String getLogiciels() {
		return m_logiciels;
	}
	
	/**
	 * @param p_logiciels	les logiciels &agrave; utiliser dans le projet
	 */
	public void setLogiciels(String p_logiciels) {
		this.m_logiciels = p_logiciels;
	}
	
	/**
	 * @return	les r&eacute;sultats du projet
	 */
	public String getResultats() {
		return m_resultats;
	}
	
	/**
	 * @param p_resultats	les nouveaux r&eacute;sultats du projet
	 */
	public void setResultats(String p_resultats) {
		this.m_resultats = p_resultats;
	}
	
	/**
	 * @return	les contrats du projet
	 */
	public String getContrats() {
		return m_contrats;
	}
	
	/**
	 * @param p_contrats	les nouveaux contrats du projet
	 */
	public void setContrats(String p_contrats) {
		this.m_contrats = p_contrats;
	}
}