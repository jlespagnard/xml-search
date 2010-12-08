package fr.unice.miage.xmlsearch.critere;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class ConferenceCritere extends Critere {
	public static final String TITRE = "titre";
	public static final String LIEU = "lieu";
	public static final String PAYS = "pays";
	public static final String ANNEE = "annee";
	
	/** Les titres des conf&eacute;rences. */
	private String[] m_titres;
	/** Les lieux des conf&eacute;rences. */
	private String[] m_lieux;
	/** Les pays dans lesquels ont eu lieu les conf&eacute;rences. */
	private String[] m_pays;
	/** Les ann&eacute;s des conf&eacute;rences. */
	private String[] m_annees;
	
	/**
	 * Constructeur
	 * 
	 * @param p_titres	les titres des conf&eacute;rences
	 * @param p_lieux	les lieux des conf&eacute;rences
	 * @param p_pays	les pays dans lesquels ont eu lieu les conf&eacute;rences
	 * @param p_annees	les ann&eacute;s des conf&eacute;rences
	 */
	public ConferenceCritere(String[] p_titres, String[] p_lieux, 
			String[] p_pays, String[] p_annees) {
		this.m_titres = p_titres;
		this.m_lieux = p_lieux;
		this.m_pays = p_pays;
		this.m_annees = p_annees;
	}
	
	@Override
	public String[] get(String p_nomCritere) {
		if(p_nomCritere == null || p_nomCritere.isEmpty())
			return null;
		
		if(p_nomCritere.equalsIgnoreCase(ConferenceCritere.TITRE))
			return this.m_titres;
		if(p_nomCritere.equalsIgnoreCase(ConferenceCritere.LIEU))
			return this.m_lieux;
		if(p_nomCritere.equalsIgnoreCase(ConferenceCritere.PAYS))
			return this.m_pays;
		if(p_nomCritere.equalsIgnoreCase(ConferenceCritere.ANNEE))
			return this.m_annees;
		
		return null;
	}
}