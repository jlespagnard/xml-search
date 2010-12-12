package fr.unice.miage.xmlsearch.objets;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class Conference {
	/** The title of the conference */
	private String m_titre = "";
	/** The conference location in the format 'City, Country' */
	private String m_lieu = "";
	/** The code of the country where the conference took place */
	private String m_codePays = "";
	/** The year of the conference */
	private String m_annee = "";
	
	public Conference() {}
	
	/**
	 * @param p_titre	The title of the conference
	 * @param p_lieu	The conference location
	 * @param p_codePays	The code of the country where the conference took place
	 * @param p_annee	The year of the conference
	 */
	public Conference(String p_titre, String p_lieu, String p_codePays, String p_annee) {
		this.m_titre = p_titre;
		this.m_lieu = p_lieu;
		this.m_codePays = p_codePays;
		this.m_annee = p_annee;
	}

	/**
	 * @return	The title of the conference
	 */
	public String getTitre() {
		return m_titre;
	}

	/**
	 * @param p_titre	The new title of the conference
	 */
	public void setTitre(String p_titre) {
		this.m_titre = p_titre;
	}

	/**
	 * @return	The conference location
	 */
	public String getLieu() {
		return m_lieu;
	}

	/**
	 * @param p_lieu	The new conference location
	 */
	public void setLieu(String p_lieu) {
		this.m_lieu = p_lieu;
	}

	/**
	 * @return	The code of the country where the conference took place
	 */
	public String getCodePays() {
		return m_codePays;
	}

	/**
	 * @param p_codePays	The new code of the country where the conference took place
	 */
	public void setCodePays(String p_codePays) {
		this.m_codePays = p_codePays;
	}

	/**
	 * @return	The year of the conference
	 */
	public String getAnnee() {
		return m_annee;
	}

	/**
	 * @param p_annee	The new year of the conference
	 */
	public void setAnnee(String p_annee) {
		this.m_annee = p_annee;
	}
}
