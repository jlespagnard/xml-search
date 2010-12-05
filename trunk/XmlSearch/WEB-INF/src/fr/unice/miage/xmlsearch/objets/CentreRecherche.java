package fr.unice.miage.xmlsearch.objets;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class CentreRecherche {
	/** L'ID du centre de recherche */
	private String m_id = "";
	/** Le nom du centre de recherche */
	private String m_libelle = "";
	/** La latitude de la localisation du centre de recherche */
	private String m_latitude = "";
	/** La longitude de la localisation du centre de recherche */
	private String m_longitude = "";
	
	/**
	 * Constructeur
	 */
	public CentreRecherche() {}
	
	/**
	 * Constructeur
	 * 
	 * @param p_id			l'ID du centre de recherche
	 * @param p_libelle		le nom du centre de recherche
	 * @param p_latitude	la latitude de la localisation du centre de recherche
	 * @param p_longitude	la longitude de la localisation du centre de recherche
	 */
	public CentreRecherche(String p_id, String p_libelle, String p_latitude, 
			String p_longitude) {
		this.m_id = p_id;
		this.m_libelle = p_libelle;
		this.m_longitude = p_longitude;
		this.m_latitude = p_latitude;
	}
	
	/**
	 * @return	l'ID du centre de recherche
	 */
	public String getId() {
		return m_id;
	}
	
	/**
	 * @param p_id	le nouvel ID du centre de recherche
	 */
	public void setId(String p_id) {
		this.m_id = p_id;
	}
	
	/**
	 * @return	le nom du centre de recherche
	 */
	public String getLibelle() {
		return m_libelle;
	}
	
	/**
	 * @param p_libelle	le nouveau nom du centre de recherche
	 */
	public void setLibelle(String p_libelle) {
		this.m_libelle = p_libelle;
	}
	
	/**
	 * @return	la latitude de la localisation du centre de recherche
	 */
	public String getLatitude() {
		return m_latitude;
	}
	
	/**
	 * @param p_latitude	la nouvelle latitude de la localisation du centre de recherche
	 */
	public void setLatitude(String p_latitude) {
		this.m_latitude = p_latitude;
	}
	
	/**
	 * @return	la longitude de la localisation du centre de recherche
	 */
	public String getLongitude() {
		return m_longitude;
	}
	
	/**
	 * @param p_longitude	la nouvelle longitude de la localisation du centre de recherche
	 */
	public void setLongitude(String p_longitude) {
		this.m_longitude = p_longitude;
	}
}