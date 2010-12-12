package fr.unice.miage.xmlsearch.objets;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class Projet {
	
	/**
	 * project id
	 */
	private String m_shortName;

	/**
	 * project name
	 */
	private String m_nom;
	
	/**
	 * id of the project name
	 */
	private String m_theme;
	
	/**
	 * project year
	 */
	private String m_annee;
	
	/**
	 * Presentation of projects (necessary only if you request a detailed info)
	 */
	private String m_presentation;
	
	/** The software used in the project */
	private String m_logiciels;
	/** Project results */
	private String m_resultats;
	/** The project contracts */
	private String m_contrats;
	
	/**
	 * @param p_shortName shortname
	 * @param m_nom name
	 * @param m_theme theme
	 * @param m_annee year
	 * @param p_presentation presentation
	 * @param p_logiciels software
	 * @param p_resultats results
	 * @param p_contrats contracts
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
	 * @return	project id
	 */
	public String getShortName() {
		return this.m_shortName;
	}
	
	/**
	 * @param p_shortName	project id
	 */
	public void setShortName(String p_shortName) {
		this.m_shortName = p_shortName;
	}
	
	/**
	 * @return name
	 */
	public String getNom() {
		return m_nom;
	}

	/**
	 * @param m_nom name
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
	 * @return year
	 */ 
	public String getAnnee() {
		return m_annee;
	}

	/**
	 * @param m_annee year
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
	 * @return softwares
	 */
	public String getLogiciels() {
		return m_logiciels;
	}
	
	/**
	 * @param p_logiciels softwares
	 */
	public void setLogiciels(String p_logiciels) {
		this.m_logiciels = p_logiciels;
	}
	
	/**
	 * @return	results
	 */
	public String getResultats() {
		return m_resultats;
	}
	
	/**
	 * @param p_resultats	results
	 */
	public void setResultats(String p_resultats) {
		this.m_resultats = p_resultats;
	}
	
	/**
	 * @return	contracts
	 */
	public String getContrats() {
		return m_contrats;
	}
	
	/**
	 * @param p_contrats	contracts
	 */
	public void setContrats(String p_contrats) {
		this.m_contrats = p_contrats;
	}
}