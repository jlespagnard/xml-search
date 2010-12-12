package fr.unice.miage.xmlsearch.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;

import fr.unice.miage.xmlsearch.dao.ProjetDAO;
import fr.unice.miage.xmlsearch.objets.Projet;
import fr.unice.miage.xmlsearch.utils.Constantes;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GetProjet extends Servlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String annee = req.getParameter(Constantes.Projet.ANNEE.getLabel());
		String shortName = req.getParameter(Constantes.Projet.SHORT_NAME.getLabel());
		
		ProjetDAO daoProjet = new ProjetDAO(this.getServletContext().getInitParameter(NOM_PARAMETRE_CONTEXTE));
		Projet projet = daoProjet.getProjet(shortName, annee);
		
		try {
			resp.getWriter().print(new JSONArray(projet));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}