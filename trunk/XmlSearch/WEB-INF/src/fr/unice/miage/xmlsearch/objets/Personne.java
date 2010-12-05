package fr.unice.miage.xmlsearch.objets;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class Personne {

	/**
	 * l'id de la personne
	 */
	private String m_id;

	/**
	 * Le nom de la personne
	 */
	private String m_nom;
	
	/**
	 * Le pr&eacute;nom de la personne
	 */
	private String m_prenom;
	
	/**
	 * L'email de la personne
	 */
	private String m_email;
	
	/**
	 * L'id du centre o&ugrave; est affili&eacute la personne
	 */
	private String m_idCentreAffilie;	
	
	/**
	 * Constructeur
	 * @param id id
	 * @param m_nom nom
	 * @param m_prenom prenom
	 * @param m_email email
	 * @param centre idCentreAffilie
	 */
	public Personne(String id, String m_nom, String m_prenom, String m_email,
			String centre) {
		super();
		this.m_id = id;
		this.m_nom = m_nom;
		this.m_prenom = m_prenom;
		this.m_email = m_email;
		this.m_idCentreAffilie = centre;
	}

	/**
	 * Recup&eacuterer le nom de la personne
	 * @return nom 
	 */
	public String getNom() {
		return m_nom;
	}
	
	/**
	 * Modifier le nom de la personne
	 * @param m_nom nom
	 */
	public void setNom(String m_nom) {
		this.m_nom = m_nom;
	}
	
	/**
	 * Recup&eacuterer le prénom de la personne
	 * @return prenom 
	 */
	public String getPrenom() {
		return m_prenom;
	}
	
	/**
	 * Modifier prenom
	 * @param m_prenom prenom
	 */
	public void setPrenom(String m_prenom) {
		this.m_prenom = m_prenom;
	}
	
	/**
	 * Recup&eacuterer l'id du centre affilié
	 * @return idCentreAffilie
	 */
	public String getIdCentreAffilie() {
		return m_idCentreAffilie;
	}
	
	/**
	 * Modifier idCentreAffilie
	 * @param m_idCentreAffilie idCentreAffilie
	 */
	public void setIdCentreAffilie(String m_idCentreAffilie) {
		this.m_idCentreAffilie = m_idCentreAffilie;
	}
	
	/**
	 * Recuperer id
	 * @return id
	 */
	public String getId() {
		return m_id;
	}

	/**
	 * Modifier id
	 * @param m_id id
	 */
	public void setId(String m_id) {
		this.m_id = m_id;
	}

	/**
	 * Recuperer email
	 * @return email
	 */
	public String getEmail() {
		return m_email;
	}

	/**
	 * Modifier email
	 * @param m_email
	 */
	public void setEmail(String m_email) {
		this.m_email = m_email;
	}
	
}
