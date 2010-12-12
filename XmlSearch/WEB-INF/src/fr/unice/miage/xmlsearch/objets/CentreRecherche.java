package fr.unice.miage.xmlsearch.objets;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class CentreRecherche {
	/** The ID of the research center */
	private String m_id = "";
	/** The name of research center */
	private String m_libelle = "";
	/** The latitude of the location of the research center */
	private String m_latitude = "";
	/** The longitude of the location of the research center */
	private String m_longitude = "";
	
	public CentreRecherche() {}
	
	/**
	 * @param p_id			The ID of the research center
	 * @param p_libelle		The name of research center
	 * @param p_latitude	The latitude of the location of the research center
	 * @param p_longitude	The longitude of the location of the research center
	 */
	public CentreRecherche(String p_id, String p_libelle, String p_latitude, 
			String p_longitude) {
		this.m_id = p_id;
		this.m_libelle = p_libelle;
		this.m_longitude = p_longitude;
		this.m_latitude = p_latitude;
	}
	
	/**
	 * @return	The ID of the research center
	 */
	public String getId() {
		return m_id;
	}
	
	/**
	 * @param p_id	The new ID of the research center
	 */
	public void setId(String p_id) {
		this.m_id = p_id;
	}
	
	/**
	 * @return	The name of research center
	 */
	public String getLibelle() {
		return m_libelle;
	}
	
	/**
	 * @param p_libelle	The new name of research center
	 */
	public void setLibelle(String p_libelle) {
		this.m_libelle = p_libelle;
	}
	
	/**
	 * @return The latitude of the location of the research center
	 */
	public String getLatitude() {
		return m_latitude;
	}
	
	/**
	 * @param p_latitude	The new latitude of the location of the research center
	 */
	public void setLatitude(String p_latitude) {
		this.m_latitude = p_latitude;
	}
	
	/**
	 * @return	The longitude of the location of the research center
	 */
	public String getLongitude() {
		return m_longitude;
	}
	
	/**
	 * @param p_longitude	The new longitude of the location of the research center
	 */
	public void setLongitude(String p_longitude) {
		this.m_longitude = p_longitude;
	}
}