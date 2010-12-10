package fr.unice.miage.xmlsearch.critere;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class ProjetCritere extends Critere{
	public static final String SHORT_NAME = "shortname";
	public static final String NOM = "projectName"; 
	public static final String THEME = "theme-de-recherche"; 
	public static final String ANNEE = "annee";
	public static final String OBJECTIF = "objectif";
	public static final String FULL_INFOS = "fullinfos";
	
	/**
	 * Identifiants du projets
	 */
	private String[] m_shortName;
	
	/**
	 * nom
	 */
	private String[] m_nom;
	
	/**
	 * theme
	 */
	private String[] m_theme;
	
	/**
	 * année
	 */
	private String[] m_annee;
	
	private boolean m_fullInfos = false;
	
	/**
	 * Constructeur
	 * @param p_shortName	les identifiants des projets
	 * @param m_nom nom
	 * @param m_theme theme
	 * @param m_annee annee
	 * @param m_objectifs objectifs
	 * @param m_participants participants
	 */
	public ProjetCritere(String[] p_shortName, String[] m_nom, String[] m_theme,
			String[] m_annee, boolean p_fullInfos) {
		this.m_shortName = p_shortName;
		this.m_nom = m_nom;
		this.m_theme = m_theme;
		this.m_annee = m_annee;
		this.m_fullInfos = p_fullInfos;
	}

	@Override
	public String[] get(String p_nomCritere) {
		if(p_nomCritere == null || p_nomCritere.isEmpty())
			return null;
		else
		{
			if(p_nomCritere.equals(ProjetCritere.SHORT_NAME))
				return this.m_shortName;
			if(p_nomCritere.equals(ProjetCritere.NOM))
				return m_nom;
			if(p_nomCritere.equals(ProjetCritere.THEME))
				return m_theme;
			if(p_nomCritere.equals(ProjetCritere.ANNEE))
				return m_annee;
			if(p_nomCritere.equals(ProjetCritere.FULL_INFOS)) {
				if(this.m_fullInfos)
					return new String[]{"yes"};
			}
			
			return null;
		}
	}
}
