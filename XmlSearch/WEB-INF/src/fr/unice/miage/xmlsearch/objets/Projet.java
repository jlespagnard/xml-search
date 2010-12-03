package fr.unice.miage.xmlsearch.objets;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class Projet {

	/**
	 * nom du projet
	 */
	private String m_nom;
	
	/**
	 * id du theme du projet
	 */
	private String m_theme;
	
	/**
	 * année du projet
	 */
	private String m_annee;
	
	/**
	 * objectifs du projets (necessaire que si on demande une info detaillée)
	 */
	private String m_objetifs;
	
	/**
	 * liste de l'id des participants (necessaire que si on demande une info detaillée)
	 */
	private String[] m_participants;

	
	/**
	 * Construction (info détaillée)
	 * @param m_nom nom 
	 * @param m_theme theme
	 * @param m_annee année
	 * @param m_objetifs objectifs
	 * @param m_participants participants
	 */
	public Projet(String m_nom, String m_theme, String m_annee,
			String m_objetifs, String[] m_participants) {
		super();
		this.m_nom = m_nom;
		this.m_theme = m_theme;
		this.m_annee = m_annee;
		this.m_objetifs = m_objetifs;
		this.m_participants = m_participants;
	}

	/**
	 * Constructeur (info non détaillée)	
	 * @param m_nom nom
	 * @param m_theme theme
	 * @param m_annee année
	 */
	public Projet(String m_nom, String m_theme, String m_annee) {
		super();
		this.m_nom = m_nom;
		this.m_theme = m_theme;
		this.m_annee = m_annee;
	}

	/**
	 * @return nom
	 */
	public String getM_nom() {
		return m_nom;
	}

	/**
	 * @param m_nom nom
	 */
	public void setM_nom(String m_nom) {
		this.m_nom = m_nom;
	}

	/**
	 * @return theme
	 */
	public String getM_theme() {
		return m_theme;
	}

	/**
	 * @param m_theme theme
	 */
	public void setM_theme(String m_theme) {
		this.m_theme = m_theme;
	}

	/**
	 * @return année
	 */ 
	public String getM_annee() {
		return m_annee;
	}

	/**
	 * @param m_annee année
	 */
	public void setM_annee(String m_annee) {
		this.m_annee = m_annee;
	}

	/**
	 * @return objectifs
	 */
	public String getM_objetifs() {
		return m_objetifs;
	}

	/**
	 * @param m_objetifs objectifs
	 */
	public void setM_objetifs(String m_objetifs) {
		this.m_objetifs = m_objetifs;
	}

	/**
	 * @return participants
	 */
	public String[] getM_participants() {
		return m_participants;
	}

	/**
	 * @param m_participants participants
	 */
	public void setM_participants(String[] m_participants) {
		this.m_participants = m_participants;
	}	
}
