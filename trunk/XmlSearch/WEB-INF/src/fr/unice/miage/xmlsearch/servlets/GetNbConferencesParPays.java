package fr.unice.miage.xmlsearch.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;

import fr.unice.miage.xmlsearch.dao.ConferenceDAO;

@SuppressWarnings("serial")
public class GetNbConferencesParPays extends Servlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String annee = req.getParameter("annee");
		if(annee == null || annee.isEmpty()) {
			return;
		}
		
		ConferenceDAO dao = new ConferenceDAO(this.getServletContext().getInitParameter(NOM_PARAMETRE_CONTEXTE));
		Map<String, String> listes = dao.getNbConferencesParPays(annee);
		if(listes == null || listes.isEmpty()) {
			return;
		}
		
		try {
			resp.getWriter().print(new JSONArray(listes));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}