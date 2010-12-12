package fr.unice.miage.xmlsearch.critere;

import fr.unice.miage.xmlsearch.utils.Constantes;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class ProjetCritere extends Critere{
	/**
	 * Identifiers of projects
	 */
	private String[] m_shortName;
	
	/**
	 * name
	 */
	private String[] m_nom;
	
	/**
	 * theme
	 */
	private String[] m_theme;
	
	/**
	 * year
	 */
	private String[] m_annee;
	
	/**
	 * fullinfos
	 */
	private boolean m_fullInfos = false;
	
	/**
	 * @param p_shortName Identifiers of projects
	 * @param m_nom name
	 * @param m_theme theme
	 * @param m_annee year
	 * @param m_fullInfos fullinfos
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
			if(p_nomCritere.equals(Constantes.Projet.SHORT_NAME.getLabel()))
				return this.m_shortName;
			if(p_nomCritere.equals(Constantes.Projet.PROJECT_NAME.getLabel()))
				return m_nom;
			if(p_nomCritere.equals(Constantes.Projet.THEME.getLabel()))
				return m_theme;
			if(p_nomCritere.equals(Constantes.Projet.ANNEE.getLabel()))
				return m_annee;
			if(p_nomCritere.equals(Constantes.Projet.FULL_INFOS.getLabel())) {
				if(this.m_fullInfos)
					return new String[]{"yes"};
			}
			
			return null;
		}
	}
}
