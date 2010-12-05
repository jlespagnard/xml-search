package fr.unice.miage.xmlsearch.critere;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class ThemeCritere extends Critere{

	public static final String ID = "id"; 
	public static final String LIBELLE = "libelle"; 
	public static final String LIEU = "lieu"; 
	public static final String ANNEE = "annee"; 
	
	/**
	 * id
	 */
	private String[] m_id;
	
	/**
	 * libelle
	 */
	private String[] m_libelle;
	
	/**
	 * lieu
	 */
	private String[] m_lieu;
	
	/**
	 * année
	 */
	private String[] m_annee;
	
	/**
	 * Constructeur
	 * @param m_id id
	 * @param m_libelle libelle
	 * @param m_lieu lieu
	 * @param m_annee annee
	 */
	public ThemeCritere(String[] m_id, String[] m_libelle,
			String[] m_lieu, String[] m_annee) {
		super();
		this.m_id = m_id;
		this.m_libelle = m_libelle;
		this.m_lieu = m_lieu;
		this.m_annee = m_annee;
	}

	@Override
	public String[] get(String p_nomCritere) {
		if(p_nomCritere == null || p_nomCritere.isEmpty())
			return null;
		else
		{
			if(p_nomCritere.equals(ThemeCritere.ID))
				return m_id;
			if(p_nomCritere.equals(ThemeCritere.LIBELLE))
				return m_libelle;
			if(p_nomCritere.equals(ThemeCritere.LIEU))
				return m_lieu;
			if(p_nomCritere.equals(ThemeCritere.ANNEE))
				return m_annee;
			else
				return null;
		}
	}

}
