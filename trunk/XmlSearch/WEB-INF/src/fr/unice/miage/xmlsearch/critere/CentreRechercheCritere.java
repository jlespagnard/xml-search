package fr.unice.miage.xmlsearch.critere;

import fr.unice.miage.xmlsearch.utils.Constantes;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class CentreRechercheCritere extends Critere {
	/** The IDs of research centers */
	private String[] m_ids;
	/** The names of research centers */
	private String[] m_libelles;
	/** The latitude of the location of research centers */
	private String[] m_latitudes;
	/** Longitude of the location of research centers */
	private String[] m_longitudes;
	
	/**
	 * @param p_ids 		IDs
	 * @param p_libelles 	Wordings
	 * @param p_latitudes 	Latitudes
	 * @param p_longitudes 	Longitudes
	 */
	public CentreRechercheCritere(String[] p_ids, String[] p_libelles, 
			String[] p_latitudes, String[] p_longitudes) {
		this.m_ids = p_ids;
		this.m_libelles = p_libelles;
		this.m_latitudes = p_latitudes;
		this.m_longitudes = p_longitudes;
	}
	
	@Override
	public String[] get(String p_nomCritere) {
		if(p_nomCritere == null || p_nomCritere.isEmpty())
			return null;
		
		if(p_nomCritere.equalsIgnoreCase(Constantes.CentreRecherche.ID.getLabel()))
			return this.m_ids;
		if(p_nomCritere.equalsIgnoreCase(Constantes.CentreRecherche.LIBELLE.getLabel()))
			return this.m_libelles;
		if(p_nomCritere.equalsIgnoreCase(Constantes.CentreRecherche.LATITUDE.getLabel()))
			return this.m_latitudes;
		if(p_nomCritere.equalsIgnoreCase(Constantes.CentreRecherche.LONGITUDE.getLabel()))
			return this.m_longitudes;
		
		return null;
	}

}
