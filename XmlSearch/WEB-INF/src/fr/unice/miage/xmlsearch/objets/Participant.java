package fr.unice.miage.xmlsearch.objets;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class Participant {

	/**
	 * prenom du participant
	 */
	private String m_firstname;
	
	/**
	 * nom du participant
	 */
	private String m_lastname;
	
	/**
	 * affiliation du participant
	 */
	private String m_affiliation;
	
	/**
	 * categorie du participant
	 */
	private String m_categoryPro;
	
	/**
	 * centre de recherche du participant
	 */
	private String m_researchcentre;
	
	/**
	 * commentaire supplementaire a propos du participant
	 */
	private String m_moreinfo;
	
	/**
	 * ?
	 */
	private String m_hdr;

	/**
	 * Constructeur
	 * @param m_firstname prenom
	 * @param m_lastname nom
	 * @param m_affiliation affiliation
	 * @param m_categoryPro categorie
	 * @param m_researchcentre centre de recherche
	 * @param m_moreinfo commentaire supplementaire
	 * @param m_hdr ?
	 */
	public Participant(String m_firstname, String m_lastname,
			String m_affiliation, String categoryPro, String researchcentre,
			String moreinfo, String hdr) {
		super();
		this.m_firstname = m_firstname;
		this.m_lastname = m_lastname;
		this.m_affiliation = m_affiliation;
		this.m_categoryPro = categoryPro;
		this.m_researchcentre = researchcentre;
		this.m_moreinfo = moreinfo;
		this.m_hdr = hdr;
	}

	/**
	 * @return prenom
	 */
	public String getFirstname() {
		return m_firstname;
	}

	/**
	 * @param m_firstname prenom
	 */
	public void setFirstname(String m_firstname) {
		this.m_firstname = m_firstname;
	}

	/**
	 * @return nom
	 */
	public String getLastname() {
		return m_lastname;
	}

	/**
	 * @param m_lastname nom
	 */
	public void setLastname(String m_lastname) {
		this.m_lastname = m_lastname;
	}

	/**
	 * @return affiliation
	 */
	public String getAffiliation() {
		return m_affiliation;
	}

	/**
	 * @param m_affiliation affiliation
	 */
	public void setAffiliation(String m_affiliation) {
		this.m_affiliation = m_affiliation;
	}

	/**
	 * @return categorie
	 */
	public String getCategoryPro() {
		return m_categoryPro;
	}

	/**
	 * @param categoryPro categorie
	 */
	public void setCategoryPro(String categoryPro) {
		this.m_categoryPro = categoryPro;
	}

	/**
	 * @return centre de recherche
	 */
	public String getResearchcentre() {
		return m_researchcentre;
	}

	/**
	 * @param researchcentre centre de recherche
	 */
	public void setResearchcentre(String researchcentre) {
		this.m_researchcentre = researchcentre;
	}

	/**
	 * @return commentaire supplementaire
	 */
	public String getMoreinfo() {
		return m_moreinfo;
	}

	/**
	 * @param moreinfo commentaire supplementaire
	 */
	public void setMoreinfo(String moreinfo) {
		this.m_moreinfo = moreinfo;
	}

	/**
	 * @return hdr
	 */
	public String getHdr() {
		return m_hdr;
	}

	/**
	 * @param hdr
	 */
	public void setHdr(String hdr) {
		this.m_hdr = hdr;
	}		
}
