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
	 * ann�e du projet
	 */
	private String m_annee;
	
	/**
	 * objectifs du projets (necessaire que si on demande une info detaill�e)
	 */
	private String m_objetifs;
	
	/**
	 * Construction (info d�taill�e)
	 * @param m_nom nom 
	 * @param m_theme theme
	 * @param m_annee ann�e
	 * @param m_objetifs objectifs
	 * @param m_participants participants
	 */
	public Projet(String p_shortName, String m_nom, String m_theme, String m_annee,
			String m_objetifs) {
		this.m_shortName = p_shortName;
		this.m_nom = m_nom;
		this.m_theme = m_theme;
		this.m_annee = m_annee;
		this.m_objetifs = m_objetifs;
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
	 * @return ann�e
	 */ 
	public String getAnnee() {
		return m_annee;
	}

	/**
	 * @param m_annee ann�e
	 */
	public void setAnnee(String m_annee) {
		this.m_annee = m_annee;
	}

	/**
	 * @return objectifs
	 */
	public String getObjetifs() {
		return m_objetifs;
	}

	/**
	 * @param m_objetifs objectifs
	 */
	public void setObjetifs(String m_objetifs) {
		this.m_objetifs = m_objetifs;
	}
}