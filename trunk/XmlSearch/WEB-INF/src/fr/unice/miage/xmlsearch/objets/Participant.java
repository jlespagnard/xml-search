package fr.unice.miage.xmlsearch.objets;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class Participant {

	/**
	 * Participant's first name
	 */
	private String m_firstname;
	
	/**
	 * Participant's last name
	 */
	private String m_lastname;
	
	/**
	 * Participant's affiliate
	 */
	private String m_affiliation;
	
	/**
	 * Participant's category
	 */
	private String m_categoryPro;
	
	/**
	 * Research center of the participant
	 */
	private String m_researchcentre;
	
	/**
	 * additional comment about the participant
	 */
	private String m_moreinfo;
	
	/**
	 * hdr
	 */
	private String m_hdr;

	/**
	 * @param m_firstname first name
	 * @param m_lastname lastname
	 * @param m_affiliation affiliate
	 * @param m_categoryPro category
	 * @param m_researchcentre research center
	 * @param m_moreinfo additional comment
	 * @param m_hdr hdr
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
	 * @return first name
	 */
	public String getFirstname() {
		return m_firstname;
	}

	/**
	 * @param m_firstname first name
	 */
	public void setFirstname(String m_firstname) {
		this.m_firstname = m_firstname;
	}

	/**
	 * @return last name
	 */
	public String getLastname() {
		return m_lastname;
	}

	/**
	 * @param m_lastname last name
	 */
	public void setLastname(String m_lastname) {
		this.m_lastname = m_lastname;
	}

	/**
	 * @return affiliate
	 */
	public String getAffiliation() {
		return m_affiliation;
	}

	/**
	 * @param m_affiliation affiliate
	 */
	public void setAffiliation(String m_affiliation) {
		this.m_affiliation = m_affiliation;
	}

	/**
	 * @return category
	 */
	public String getCategoryPro() {
		return m_categoryPro;
	}

	/**
	 * @param categoryPro category
	 */
	public void setCategoryPro(String categoryPro) {
		this.m_categoryPro = categoryPro;
	}

	/**
	 * @return research center
	 */
	public String getResearchcentre() {
		return m_researchcentre;
	}

	/**
	 * @param researchcentre research center
	 */
	public void setResearchcentre(String researchcentre) {
		this.m_researchcentre = researchcentre;
	}

	/**
	 * @return additional comment
	 */
	public String getMoreinfo() {
		return m_moreinfo;
	}

	/**
	 * @param moreinfo additional comment
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
