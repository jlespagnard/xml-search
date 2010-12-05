package fr.unice.miage.xmlsearch.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fr.unice.miage.xmlsearch.critere.CentreRechercheCritere;
import fr.unice.miage.xmlsearch.critere.Critere;
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

	@Override
	public List<Object> rechercher(Critere p_critere) {
		List<Object> centresRecherche = null;
		
		List<Map<String, String>> results = super.getResultatsRequete("rechercheCentreRechercher.xqy", 
				p_critere, CentreRechercheCritere.ID, CentreRechercheCritere.LIBELLE, 
				CentreRechercheCritere.LATITUDE, CentreRechercheCritere.LONGITUDE);
		
		if(results != null) {
			centresRecherche = new LinkedList<Object>();
			CentreRecherche centre;
			for(Map<String, String> infosCentre : results) {
				centre = new CentreRecherche(infosCentre.get(CentreRechercheCritere.ID), 
						infosCentre.get(CentreRechercheCritere.LIBELLE), infosCentre.get(CentreRechercheCritere.LATITUDE), 
						infosCentre.get(CentreRechercheCritere.LONGITUDE));
				
				centresRecherche.add(centre);
			}
		}
		
		return centresRecherche;
	}

	@Override
	public int count(Critere p_critere) {
		// TODO Auto-generated method stub
		return 0;
	}
}
