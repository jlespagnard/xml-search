package fr.unice.miage.xmlsearch.objets;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class Projet {
	
	/** Project id */
	private String m_shortName;
	/** Project name */
	private String m_nom;
	/** Id of the theme */
	private String m_theme;
	/** Project year */
	private String m_annee;
	/** Presentation of projects (necessary only if you request a detailed info) */
	private String m_presentation;
	/** The software used in the project */
	private String m_logiciels;
	/** Project results */
	private String m_resultats;
	/** The project contracts */
	private String m_contrats;
	
	/**
	 * @param p_shortName 		Shortname
	 * @param m_nom 			Name
	 * @param m_theme 			Theme
	 * @param m_annee 			Year
	 * @param p_presentation 	Presentation
	 * @param p_logiciels 		Software
	 * @param p_resultats 		Results
	 * @param p_contrats 		Contracts
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
	 * @return	Project id
	 */
	public String getShortName() {
		return this.m_shortName;
	}
	
	/**
	 * @param p_shortName	Project id
	 */
	public void setShortName(String p_shortName) {
		this.m_shortName = p_shortName;
	}
	
	/**
	 * @return Name
	 */
	public String getNom() {
		return m_nom;
	}

	/**
	 * @param m_nom Name
	 */
	public void setNom(String m_nom) {
		this.m_nom = m_nom;
	}

	/**
	 * @return Theme
	 */
	public String getTheme() {
		return m_theme;
	}

	/**
	 * @param m_theme Theme
	 */
	public void setTheme(String m_theme) {
		this.m_theme = m_theme;
	}

	/**
	 * @return Year
	 */ 
	public String getAnnee() {
		return m_annee;
	}

	/**
	 * @param m_annee Year
	 */
	public void setAnnee(String m_annee) {
		this.m_annee = m_annee;
	}

	/**
	 * @return Presentation
	 */
	public String getPresentation() {
		return this.m_presentation;
	}

	/**
	 * @param p_presentation Presentation
	 */
	public void setPresentation(String p_presentation) {
		this.m_presentation = p_presentation;
	}
	
	/**
	 * @return Softwares
	 */
	public String getLogiciels() {
		return m_logiciels;
	}
	
	/**
	 * @param p_logiciels Softwares
	 */
	public void setLogiciels(String p_logiciels) {
		this.m_logiciels = p_logiciels;
	}
	
	/**
	 * @return	Results
	 */
	public String getResultats() {
		return m_resultats;
	}
	
	/**
	 * @param p_resultats	Results
	 */
	public void setResultats(String p_resultats) {
		this.m_resultats = p_resultats;
	}
	
	/**
	 * @return	Contracts
	 */
	public String getContrats() {
		return m_contrats;
	}
	
	/**
	 * @param p_contrats	Contracts
	 */
	public void setContrats(String p_contrats) {
		this.m_contrats = p_contrats;
	}
}