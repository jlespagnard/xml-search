package fr.unice.miage.xmlsearch.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import fr.unice.miage.xmlsearch.critere.ProjetCritere;
import fr.unice.miage.xmlsearch.dao.ProjetDAO;
import fr.unice.miage.xmlsearch.objets.Projet;

@SuppressWarnings("serial")
public class RechercherProjet extends Servlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] annees = (req.getParameter("annee") == null) ? null : new String[]{req.getParameter("annee")};
		String[] shortNames = (req.getParameter("shortName") == null) ? null : new String[]{req.getParameter("shortName")};
		String[] titres = (req.getParameter("titre") == null) ? null : new String[]{req.getParameter("titre")};
		String[] themes = (req.getParameter("theme") == null) ? null : new String[]{req.getParameter("theme")};
		
		ProjetCritere critere = new ProjetCritere(shortNames, titres, themes, annees, true);
		ProjetDAO daoProjet = new ProjetDAO(this.getServletContext().getInitParameter(NOM_PARAMETRE_CONTEXTE));
		List<Projet> projets = daoProjet.rechercherProjet(critere);
		
		resp.getWriter().print(new JSONArray(projets));
	}
}