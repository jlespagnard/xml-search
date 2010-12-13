package fr.unice.miage.xmlsearch.objets;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class Participant {

	/** Participant's first name */
	private String m_firstname;	
	/** Participant's last name */
	private String m_lastname;	
	/** Participant's affiliate */
	private String m_affiliation;	
	/** Participant's category */
	private String m_categoryPro;	
	/** Research center of the participant */
	private String m_researchcentre;
	/** Additional comment about the participant */
	private String m_moreinfo;	
	/** Hdr of the participant */
	private String m_hdr;

	/**
	 * @param m_firstname 		Firstname
	 * @param m_lastname 		Lastname
	 * @param m_affiliation 	Affiliate
	 * @param m_categoryPro 	Category
	 * @param m_researchcentre 	Research center
	 * @param m_moreinfo 		Additional comment
	 * @param m_hdr 			Hdr
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
	 * @return Firstname
	 */
	public String getFirstname() {
		return m_firstname;
	}

	/**
	 * @param m_firstname Firstname
	 */
	public void setFirstname(String m_firstname) {
		this.m_firstname = m_firstname;
	}

	/**
	 * @return Lastname
	 */
	public String getLastname() {
		return m_lastname;
	}

	/**
	 * @param m_lastname Lastname
	 */
	public void setLastname(String m_lastname) {
		this.m_lastname = m_lastname;
	}

	/**
	 * @return Affiliate
	 */
	public String getAffiliation() {
		return m_affiliation;
	}

	/**
	 * @param m_affiliation Affiliate
	 */
	public void setAffiliation(String m_affiliation) {
		this.m_affiliation = m_affiliation;
	}

	/**
	 * @return Category
	 */
	public String getCategoryPro() {
		return m_categoryPro;
	}

	/**
	 * @param categoryPro Category
	 */
	public void setCategoryPro(String categoryPro) {
		this.m_categoryPro = categoryPro;
	}

	/**
	 * @return Research center
	 */
	public String getResearchcentre() {
		return m_researchcentre;
	}

	/**
	 * @param researchcentre Research center
	 */
	public void setResearchcentre(String researchcentre) {
		this.m_researchcentre = researchcentre;
	}

	/**
	 * @return Additional comment
	 */
	public String getMoreinfo() {
		return m_moreinfo;
	}

	/**
	 * @param moreinfo Additional comment
	 */
	public void setMoreinfo(String moreinfo) {
		this.m_moreinfo = moreinfo;
	}

	/**
	 * @return Hdr
	 */
	public String getHdr() {
		return m_hdr;
	}

	/**
	 * @param Hdr
	 */
	public void setHdr(String hdr) {
		this.m_hdr = hdr;
	}		
}
