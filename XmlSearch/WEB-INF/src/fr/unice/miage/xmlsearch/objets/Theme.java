package fr.unice.miage.xmlsearch.objets;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class Theme {

	/** Theme id */
	private String m_id;	
	/** Title of the theme */
	private String m_libelle;	
	/** Place of the theme */
	private String m_lieu;	
	/** Year of the theme */
	private String m_annee;

	/**
	 * @param m_id 		Id
	 * @param m_libelle Title
	 * @param m_lieu 	Place
	 * @param m_annee 	Year
	 */
	public Theme(String m_id, String m_libelle, String m_lieu, String m_annee) {
		super();
		this.m_id = m_id;
		this.m_libelle = m_libelle;
		this.m_lieu = m_lieu;
		this.m_annee = m_annee;
	}

	/**
	 * @return Id
	 */
	public String getId() {
		return m_id;
	}

	/**
	 * @param m_id Id
	 */
	public void setId(String m_id) {
		this.m_id = m_id;
	}

	/**
	 * @return Title
	 */
	public String getLibelle() {
		return m_libelle;
	}

	/**
	 * @param m_libelle Title
	 */
	public void setLibelle(String m_libelle) {
		this.m_libelle = m_libelle;
	}

	/**
	 * @return Place
	 */
	public String getLieu() {
		return m_lieu;
	}

	/**
	 * @param m_lieu Place
	 */
	public void setLieu(String m_lieu) {
		this.m_lieu = m_lieu;
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
	
}
