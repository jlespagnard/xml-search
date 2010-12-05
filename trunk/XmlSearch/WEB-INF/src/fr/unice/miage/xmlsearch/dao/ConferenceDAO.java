package fr.unice.miage.xmlsearch.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fr.unice.miage.xmlsearch.critere.ConferenceCritere;
import fr.unice.miage.xmlsearch.critere.Critere;
import fr.unice.miage.xmlsearch.objets.Conference;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class ConferenceDAO extends DAO {
	/**
	 * @param p_contexte	le contexte de l'application
	 */
	public ConferenceDAO(String p_contexte) {
		super(p_contexte);
	}
	
	@Override
	public List<Object> rechercher(Critere p_critere) {
		List<Object> conferences = null;
		
		List<Map<String, String>> results = super.getResultatsRequete("rechercheConference.xqy", p_critere, ConferenceCritere.TITRE, 
				ConferenceCritere.LIEU, ConferenceCritere.PAYS, ConferenceCritere.ANNEE);
		
		if(results != null) {
			conferences = new LinkedList<Object>();
			Conference conf;
			for (Map<String, String> infosConf : results) {
				conf = new Conference(infosConf.get(ConferenceCritere.TITRE), 
						infosConf.get(ConferenceCritere.LIEU), infosConf.get(ConferenceCritere.PAYS), 
						infosConf.get(ConferenceCritere.ANNEE));
				
				conferences.add(conf);
			}
		}
		
		return conferences;
	}

	@Override
	public int count(Critere p_critere) {
		// TODO Auto-generated method stub
		return 0;
	}
}
