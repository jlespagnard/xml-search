package fr.unice.miage.xmlsearch.utils;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public abstract class Constantes {

	public static enum CentreRecherche {
		ID("idCR"),
		LIBELLE("libelle"),
		LATITUDE("latitude"),
		LONGITUDE("longitude");
		
		private String m_label;
		
		private CentreRecherche(String p_label) {
			this.m_label = p_label;
		}
		
		public String getLabel() {
			return this.m_label;
		}
	}
	
	public static enum Conference {
		TITRE("TitreConference"),
		LIEU("lieu"),
		CODE_PAYS("pays"),
		ANNEE("annee");
		
		private String m_label;
		
		private Conference(String p_label) {
			this.m_label = p_label;
		}
		
		public String getLabel() {
			return this.m_label;
		}
	}
	
	public static enum Participant {
		FISRTNAME("firstname"),
		LASTNAME("lastname"),
		AFFILIATION("affiliation"),
		CATEGORYPRO("categorypro"),
		RESEARCHCENTRE("research-centre"),
		MOREINFO("moreinfo"),
		HDR("hdr");
		
		private String m_label;
		
		private Participant(String p_label) {
			this.m_label = p_label;
		}
		
		public String getLabel() {
			return this.m_label;
		}
	}
	
	public static enum Projet {
		SHORT_NAME("shortname"),
		PROJECT_NAME("projectName"),
		THEME("theme"),
		THEME_DE_RECHERCHE("theme-de-recherche"),
		PRESENTATION("presentation"),
		PARTICIPANTS("participants"),
		LOGICIELS("logiciels"),
		RESULTATS("resultats"),
		CONTRATS("contrats"),
		ANNEE("annee"),
		FULL_INFOS("fullinfos");
		
		private String m_label;
		
		private Projet(String p_label) {
			this.m_label = p_label;
		}
		
		public String getLabel() {
			return this.m_label;
		}
	}
	
	public static enum Theme {
		ID("id"),
		LIBELLE("theme"),
		LIEU("lieu"),
		ANNEE("annee");
		
		private String m_label;
		
		private Theme(String p_label) {
			this.m_label = p_label;
		}
		
		public String getLabel() {
			return this.m_label;
		}
	}
	
	public static enum Membre {
		DATENAISSANCE("datenaissance"),
		NOM("nom"),
		PRENOM("prenom");
		
		private String m_label;
		
		private Membre(String p_label) {
			this.m_label = p_label;
		}
		
		public String getLabel() {
			return this.m_label;
		}
	}
}