package fr.unice.miage.xmlsearch.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;

import fr.unice.miage.xmlsearch.dao.ProjetDAO;
import fr.unice.miage.xmlsearch.utils.Constantes;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GetNbParticipantsParProjet extends Servlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		
		String shortname = req.getParameter(Constantes.Projet.SHORT_NAME.getLabel());
		
		ProjetDAO dao = new ProjetDAO(this.getServletContext().getInitParameter(NOM_PARAMETRE_CONTEXTE));
		Map<String, String> listes = dao.getNbParticipantsParProjet(shortname);
		if(listes == null || listes.isEmpty()) {
			return;
		}
		
		try {
			resp.getWriter().print(new JSONArray(listes.entrySet().toArray()));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

}
