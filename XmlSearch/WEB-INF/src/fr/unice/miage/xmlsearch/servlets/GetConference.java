package fr.unice.miage.xmlsearch.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import fr.unice.miage.xmlsearch.dao.ConferenceDAO;
import fr.unice.miage.xmlsearch.objets.Conference;

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
		
		String pays = req.getParameter("pays");
		
		ConferenceDAO daoConference = new ConferenceDAO(this.getServletContext().getInitParameter(NOM_PARAMETRE_CONTEXTE));
		List<Conference> conferences = daoConference.getConferences(pays);
		
		resp.getWriter().print(new JSONArray(conferences));
		
	}

}
