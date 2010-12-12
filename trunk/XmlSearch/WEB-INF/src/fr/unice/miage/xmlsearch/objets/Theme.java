package fr.unice.miage.xmlsearch.objets;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class Theme {

	/**
	 * id
	 */
	private String m_id;
	
	/**
	 * libel
	 */
	private String m_libelle;
	
	/**
	 * place
	 */
	private String m_lieu;
	
	/**
	 * year
	 */
	private String m_annee;

	/**
	 * @param m_id id
	 * @param m_libelle wording
	 * @param m_lieu place
	 * @param m_annee year
	 */
	public Theme(String m_id, String m_libelle, String m_lieu, String m_annee) {
		super();
		this.m_id = m_id;
		this.m_libelle = m_libelle;
		this.m_lieu = m_lieu;
		this.m_annee = m_annee;
	}

	/**
	 * @return id
	 */
	public String getId() {
		return m_id;
	}

	/**
	 * @param m_id id
	 */
	public void setId(String m_id) {
		this.m_id = m_id;
	}

	/**
	 * @return wording
	 */
	public String getLibelle() {
		return m_libelle;
	}

	/**
	 * @param m_libelle wording
	 */
	public void setLibelle(String m_libelle) {
		this.m_libelle = m_libelle;
	}

	/**
	 * @return place
	 */
	public String getLieu() {
		return m_lieu;
	}

	/**
	 * @param m_lieu place
	 */
	public void setLieu(String m_lieu) {
		this.m_lieu = m_lieu;
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
	
}
