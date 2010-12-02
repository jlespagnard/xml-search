package fr.unice.miage.xmlsearch.objets;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class Conference {
	/** Le titre de la conf&eacute;rence. */
	private String m_titre = "";
	/** Le lieu de la conf&eacute;rence. */
	private String m_lieu = "";
	/** Le pays dans lequel a eu lieu la conf&eacute;rence. */
	private String m_pays = "";
	/** L'ann&eacute; de la conf&eacute;rence. */
	private String m_annee = "";
	
	/**
	 * Constructeur.
	 */
	public Conference() {}
	
	/**
	 * Constructeur.
	 * 
	 * @param p_titre	le titre de la conf&eacute;rence
	 * @param p_lieu	le lieu de la conf&eacute;rence
	 * @param p_pays	le pays dans lequel a eu lieu la conf&eacute;rence
	 * @param p_annee	l'ann&eacute; de la conf&eacute;rence
	 */
	public Conference(String p_titre, String p_lieu, String p_pays, String p_annee) {
		this.m_titre = p_titre;
		this.m_lieu = p_lieu;
		this.m_pays = p_pays;
		this.m_annee = p_annee;
	}

	/**
	 * @return	le titre de la conf&eacute;rence
	 */
	public String getTitre() {
		return m_titre;
	}

	/**
	 * @param p_titre	le nouveau titre de la conf&eacute;rence
	 */
	public void setTitre(String p_titre) {
		this.m_titre = p_titre;
	}

	/**
	 * @return	le lieu de la de la conf&eacute;rence
	 */
	public String getLieu() {
		return m_lieu;
	}

	/**
	 * @param p_lieu	le nouveau lieu de la conf&eacute;rence
	 */
	public void setLieu(String p_lieu) {
		this.m_lieu = p_lieu;
	}

	/**
	 * @return	le pays dans lequel a eu lieu la conf&eacute;rence
	 */
	public String getPays() {
		return m_pays;
	}

	/**
	 * @param p_pays	le nouveau pays dans lequel a eu lieu la conf&eacute;rence
	 */
	public void setPays(String p_pays) {
		this.m_pays = p_pays;
	}

	/**
	 * @return	l'ann&eacute;e de la conf&eacute;rence
	 */
	public String getAnnee() {
		return m_annee;
	}

	/**
	 * @param p_annee	la nouvelle ann&eacute;e de la conf&eacute;rence
	 */
	public void setAnnee(String p_annee) {
		this.m_annee = p_annee;
	}
}
