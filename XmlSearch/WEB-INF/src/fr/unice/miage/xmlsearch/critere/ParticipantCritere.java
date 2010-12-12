package fr.unice.miage.xmlsearch.critere;

import fr.unice.miage.xmlsearch.utils.Constantes;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class ParticipantCritere extends Critere{
	/**
	 * Participant's first name
	 */
	private String[] m_firstname;
	
	/**
	 * participant's last name
	 */
	private String[] m_lastname;
	
	/**
	 * participant's affiliate
	 */
	private String[] m_affiliation;
	
	/**
	 * Participant's category
	 */
	private String[] m_categoryPro;
	
	/**
	 * research center of the participant
	 */
	private String[] m_researchcentre;
	
	/**
	 * additional comment about the participant
	 */
	private String[] m_moreinfo;
	
	/**
	 * hdr
	 */
	private String[] m_hdr;

	/**
	 * @param m_firstname firstname
	 * @param m_lastname lastname
	 * @param m_affiliation affiliate
	 * @param m_categoryPro category
	 * @param m_researchcentre research center
	 * @param m_moreinfo additional comment
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
			if(p_nomCritere.equals(Constantes.Participant.FISRTNAME.getLabel()))
				return m_firstname;
			if(p_nomCritere.equals(Constantes.Participant.LASTNAME.getLabel()))
				return m_lastname;
			if(p_nomCritere.equals(Constantes.Participant.AFFILIATION.getLabel()))
				return m_affiliation;
			if(p_nomCritere.equals(Constantes.Participant.CATEGORYPRO.getLabel()))
				return m_categoryPro;
			if(p_nomCritere.equals(Constantes.Participant.RESEARCHCENTRE.getLabel()))
				return m_researchcentre;
			if(p_nomCritere.equals(Constantes.Participant.MOREINFO.getLabel()))
				return m_moreinfo;
			if(p_nomCritere.equals(Constantes.Participant.HDR.getLabel()))
				return m_hdr;
			else
				return null;
		}
	}
	
	
}
