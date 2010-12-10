package fr.unice.miage.xmlsearch.critere;

public class CentreRechercheCritere extends Critere {
	public static final String ID = "idcr";
	public static final String LIBELLE = "libelle";
	public static final String LATITUDE = "latitude";
	public static final String LONGITUDE = "longitude";
	
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
		
		if(p_nomCritere.equalsIgnoreCase(CentreRechercheCritere.ID))
			return this.m_ids;
		if(p_nomCritere.equalsIgnoreCase(CentreRechercheCritere.LIBELLE))
			return this.m_libelles;
		if(p_nomCritere.equalsIgnoreCase(CentreRechercheCritere.LATITUDE))
			return this.m_latitudes;
		if(p_nomCritere.equalsIgnoreCase(CentreRechercheCritere.LONGITUDE))
			return this.m_longitudes;
		
		return null;
	}

}
