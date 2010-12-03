package fr.unice.miage.xmlsearch.critere;

import java.util.List;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class ProjetCritere extends Critere{

	public static final String NOM = "nom"; 
	public static final String THEME = "theme"; 
	public static final String ANNEE = "annee"; 
	public static final String OBJECTIFS = "objectifs"; 
	public static final String PARTICIPANTS = "participants";
	
	/**
	 * nom
	 */
	private List<String> m_nom;
	
	/**
	 * theme
	 */
	private List<String> m_theme;
	
	/**
	 * ann�e
	 */
	private List<String> m_annee;
	
	/**
	 * objectifs
	 */
	private List<String> m_objectifs;
	
	/**
	 * id des participants
	 */
	private List<String> m_participants;
	
	/**
	 * Constructeur
	 * @param m_nom nom
	 * @param m_theme theme
	 * @param m_annee annee
	 * @param m_objectifs objectifs
	 * @param m_participants participants
	 */
	public ProjetCritere(List<String> m_nom, List<String> m_theme,
			List<String> m_annee, List<String> m_objectifs,
			List<String> m_participants) {
		super();
		this.m_nom = m_nom;
		this.m_theme = m_theme;
		this.m_annee = m_annee;
		this.m_objectifs = m_objectifs;
		this.m_participants = m_participants;
	}



	@Override
	public List<String> get(String p_nomCritere) {
		if(p_nomCritere == null || p_nomCritere.isEmpty())
			return null;
		else
		{
			if(p_nomCritere.equals(ProjetCritere.NOM))
				return m_nom;
			if(p_nomCritere.equals(ProjetCritere.THEME))
				return m_theme;
			if(p_nomCritere.equals(ProjetCritere.ANNEE))
				return m_annee;
			if(p_nomCritere.equals(ProjetCritere.OBJECTIFS))
				return m_objectifs;
			if(p_nomCritere.equals(ProjetCritere.PARTICIPANTS))
				return m_participants;
			else
				return null;
		}
	}

}
