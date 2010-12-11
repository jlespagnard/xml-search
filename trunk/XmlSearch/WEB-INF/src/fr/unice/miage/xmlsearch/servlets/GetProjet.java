package fr.unice.miage.xmlsearch.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import fr.unice.miage.xmlsearch.dao.ProjetDAO;
import fr.unice.miage.xmlsearch.objets.Projet;

@SuppressWarnings("serial")
public class GetProjet extends Servlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String annee = req.getParameter("annee");
		String shortName = req.getParameter("shortName");
		
		ProjetDAO daoProjet = new ProjetDAO(this.getServletContext().getInitParameter(NOM_PARAMETRE_CONTEXTE));
		Projet projet = daoProjet.getProjet(shortName, annee);
		
		resp.getWriter().print(new JSONObject(projet));
	}
}