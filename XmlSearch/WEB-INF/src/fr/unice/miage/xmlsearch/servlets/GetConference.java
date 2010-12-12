package fr.unice.miage.xmlsearch.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import fr.unice.miage.xmlsearch.dao.ConferenceDAO;
import fr.unice.miage.xmlsearch.objets.Conference;
import fr.unice.miage.xmlsearch.utils.Constantes;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GetConference extends Servlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String codePays = req.getParameter(Constantes.Conference.CODE_PAYS.getLabel());
		if(codePays == null || codePays.isEmpty()) {
			return;
		}
		String annee = req.getParameter(Constantes.Conference.ANNEE.getLabel());
		if(annee == null || annee.isEmpty()) {
			return;
		}
		
		ConferenceDAO daoConference = new ConferenceDAO(this.getServletContext().getInitParameter(NOM_PARAMETRE_CONTEXTE));
		List<Conference> conferences = daoConference.getConferences(codePays, annee);
		
		resp.getWriter().print(new JSONArray(conferences));
	}
}