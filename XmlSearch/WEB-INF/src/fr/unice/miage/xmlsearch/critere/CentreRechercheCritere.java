package fr.unice.miage.xmlsearch.critere;

import fr.unice.miage.xmlsearch.utils.Constantes;

public class CentreRechercheCritere extends Critere {
	/** Les IDs des centres de recherche */
	private String[] m_ids;
	/** Les noms des centres de recherche */
	private String[] m_libelles;
	/** Les latitudes de la localisation des centres de recherche */
	private String[] m_latitudes;
	/** Les longitudes de la localisation des centres de recherche */
	private String[] m_longitudes;
	
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
