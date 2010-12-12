package fr.unice.miage.xmlsearch.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fr.unice.miage.xmlsearch.critere.CentreRechercheCritere;
import fr.unice.miage.xmlsearch.objets.CentreRecherche;
import fr.unice.miage.xmlsearch.utils.Constantes;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class CentreRechercheDAO extends DAO {
	
	/**
	 * @param p_contexte the application context
	 */
	public CentreRechercheDAO(String p_contexte) {
		super(p_contexte);
	}
	
	/**
	 * @return	the list of existing research centers
	 */
	public List<CentreRecherche> getCentresRecherche() {
		List<CentreRecherche> centres = null;
		
		List<Map<String, String>> resultats = super.getResultatsRequete("getCentresRecherche.xqy", null);
		
		if(resultats != null && !resultats.isEmpty()) {
			centres = new LinkedList<CentreRecherche>();
			CentreRecherche centre;
			for (Map<String, String> infosCentre : resultats) {
				centre = new CentreRecherche(infosCentre.get(Constantes.CentreRecherche.ID.getLabel()), infosCentre.get(Constantes.CentreRecherche.LIBELLE.getLabel()), 
						infosCentre.get(Constantes.CentreRecherche.LATITUDE.getLabel()), infosCentre.get(Constantes.CentreRecherche.LONGITUDE.getLabel()));
				
				centres.add(centre);
			}
		}
		
		return centres;
	}

	/**
	 * List of members of a research center
	 * @param idCR id Research Center
	 * @return members list with full name and date of birth
	 */
	public List<String> getMembresCR(String idCR) {
		
		List<String> retour = null;
		
		CentreRechercheCritere critere = new CentreRechercheCritere(new String[]{idCR}, null, null, null);
		
		List<Map<String, String>> results = super.getResultatsRequete("getMembresCR.xqy", 
				critere, Constantes.CentreRecherche.ID.getLabel());
		
		if(results != null && !results.isEmpty()) {
			retour = new LinkedList<String>();
			String membre = "";
			for (Map<String, String> map : results) {
				membre = map.get(Constantes.Membre.NOM.getLabel()) + " " + map.get(Constantes.Membre.PRENOM.getLabel());
				if(map.get(Constantes.Membre.DATENAISSANCE.getLabel()) != null)
					membre += " n&eacute; le " + map.get(Constantes.Membre.DATENAISSANCE.getLabel());
				retour.add(membre);
				membre = "";
			}
		}		
		return retour;
	}
}