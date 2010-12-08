package fr.unice.miage.xmlsearch.critere;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class ParticipantCritere extends Critere{

	public static final String FISRTNAME = "firstname";
	public static final String LASTNAME = "lastname";
	public static final String AFFILIATION = "affiliation";
	public static final String CATEGORYPRO = "categoryPro";
	public static final String RESEARCHCENTRE = "researchCentre";
	public static final String MOREINFO = "moreInfo";
	public static final String HDR = "hdr";
	
	/**
	 * prenom du participant
	 */
	private String[] m_firstname;
	
	/**
	 * nom du participant
	 */
	private String[] m_lastname;
	
	/**
	 * affiliation du participant
	 */
	private String[] m_affiliation;
	
	/**
	 * categorie du participant
	 */
	private String[] m_categoryPro;
	
	/**
	 * centre de recherche du participant
	 */
	private String[] m_researchcentre;
	
	/**
	 * commentaire supplementaire a propos du participant
	 */
	private String[] m_moreinfo;
	
	/**
	 * ?
	 */
	private String[] m_hdr;

	/**
	 * Constructeur
	 * @param m_firstname prenom
	 * @param m_lastname nom
	 * @param m_affiliation affiliation
	 * @param m_categoryPro categorie
	 * @param m_researchcentre centre de recherche
	 * @param m_moreinfo commentaire supplementaire
	 * @param m_hdr hdr
	 */
	public ParticipantCritere(String[] m_firstname, String[] m_lastname,
			String[] m_affiliation, String[] m_categoryPro,
			String[] m_researchcentre, String[] m_moreinfo, String[] m_hdr) {
		super();
		this.m_firstname = m_firstname;
		this.m_lastname = m_lastname;
		this.m_affiliation = m_affiliation;
		this.m_categoryPro = m_categoryPro;
		this.m_researchcentre = m_researchcentre;
		this.m_moreinfo = m_moreinfo;
		this.m_hdr = m_hdr;
	}

	@Override
	public String[] get(String p_nomCritere) {
		if(p_nomCritere == null || p_nomCritere.isEmpty())
			return null;
		else
		{
			if(p_nomCritere.equals(ParticipantCritere.FISRTNAME))
				return m_firstname;
			if(p_nomCritere.equals(ParticipantCritere.LASTNAME))
				return m_lastname;
			if(p_nomCritere.equals(ParticipantCritere.AFFILIATION))
				return m_affiliation;
			if(p_nomCritere.equals(ParticipantCritere.CATEGORYPRO))
				return m_categoryPro;
			if(p_nomCritere.equals(ParticipantCritere.RESEARCHCENTRE))
				return m_researchcentre;
			if(p_nomCritere.equals(ParticipantCritere.MOREINFO))
				return m_moreinfo;
			if(p_nomCritere.equals(ParticipantCritere.HDR))
				return m_hdr;
			else
				return null;
		}
	}
	
	
}
