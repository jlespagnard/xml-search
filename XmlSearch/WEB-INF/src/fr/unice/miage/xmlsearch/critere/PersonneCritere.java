package fr.unice.miage.xmlsearch.critere;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class PersonneCritere extends Critere{

	
	public static final String ID = "id";
	public static final String NOM = "nom"; 
	public static final String PRENON = "prenom"; 
	public static final String EMAIL = "email"; 
	public static final String CENTREAFFILIE = "centreaffilie"; 
	
	/**
	 * l'id de la personne
	 */
	private String[] m_id;

	/**
	 * Le nom de la personne
	 */
	private String[] m_nom;
	
	/**
	 * Le pr&eacute;nom de la personne
	 */
	private String[] m_prenom;
	
	/**
	 * L'email de la personne
	 */
	private String[] m_email;
	
	/**
	 * L'id du centre o&ugrave; est affili&eacute la personne
	 */
	private String[] m_idCentreAffilie;		
	
	/**
	 * Constructeur
	 * @param m_id id
	 * @param m_nom nom
	 * @param m_prenom prenom
	 * @param m_email email
	 * @param m_idCentreAffilie idCentreAffilie
	 */
	public PersonneCritere(String[] m_id, String[] m_nom,
			String[] m_prenom, String[] m_email,
			String[] m_idCentreAffilie) {
		super();
		this.m_id = m_id;
		this.m_nom = m_nom;
		this.m_prenom = m_prenom;
		this.m_email = m_email;
		this.m_idCentreAffilie = m_idCentreAffilie;
	}

	
	@Override
	public String[] get(String p_nomCritere) {
		
		if(p_nomCritere == null || p_nomCritere.isEmpty())
			return null;
		else
		{
			if(p_nomCritere.equals(PersonneCritere.ID))
				return m_id;
			if(p_nomCritere.equals(PersonneCritere.NOM))
				return m_nom;
			if(p_nomCritere.equals(PersonneCritere.PRENON))
				return m_prenom;
			if(p_nomCritere.equals(PersonneCritere.EMAIL))
				return m_email;
			if(p_nomCritere.equals(PersonneCritere.CENTREAFFILIE))
				return m_idCentreAffilie;
			else
				return null;
		}
	}

}
