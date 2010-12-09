package fr.unice.miage.xmlsearch.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fr.unice.miage.xmlsearch.critere.CentreRechercheCritere;
import fr.unice.miage.xmlsearch.objets.CentreRecherche;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class CentreRechercheDAO extends DAO {
	/**
	 * Constructeur
	 * 
	 * @param p_contexte		le contexte de l'application
	 */
	public CentreRechercheDAO(String p_contexte) {
		super(p_contexte);
	}
	
	/**
	 * @return	la liste des centres de recherche existants
	 */
	public List<CentreRecherche> getCentresRecherche() {
		List<CentreRecherche> centres = null;
		
		List<Map<String, String>> resultats = super.getResultatsRequete("getCentresRecherche.xqy", null);
		
		if(resultats != null && resultats.isEmpty()) {
			centres = new LinkedList<CentreRecherche>();
			CentreRecherche centre;
			for (Map<String, String> infosCentre : resultats) {
				centre = new CentreRecherche(infosCentre.get(CentreRechercheCritere.ID), infosCentre.get(CentreRechercheCritere.LIBELLE), 
						infosCentre.get(CentreRechercheCritere.LATITUDE), infosCentre.get(CentreRechercheCritere.LONGITUDE));
				
				centres.add(centre);
			}
		}
		
		return centres;
	}
}