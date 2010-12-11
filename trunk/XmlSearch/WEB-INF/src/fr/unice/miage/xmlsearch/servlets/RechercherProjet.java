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
import fr.unice.miage.xmlsearch.utils.Constantes;

@SuppressWarnings("serial")
public class RechercherProjet extends Servlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String annee = req.getParameter(Constantes.Projet.ANNEE.getLabel());
		String shortName = req.getParameter(Constantes.Projet.SHORT_NAME.getLabel());
		String titre = req.getParameter(Constantes.Projet.PROJECT_NAME.getLabel());
		String theme = req.getParameter(Constantes.Projet.THEME.getLabel());
		
		String[] annees = (annee == null) ? null : new String[]{annee};
		String[] shortNames = (shortName == null) ? null : new String[]{shortName};
		String[] titres = (titre == null) ? null : new String[]{titre};
		String[] themes = (theme == null) ? null : new String[]{theme};
		ProjetCritere critere = new ProjetCritere(shortNames, titres, themes, annees, true);

		ProjetDAO daoProjet = new ProjetDAO(this.getServletContext().getInitParameter(NOM_PARAMETRE_CONTEXTE));
		List<Projet> projets = daoProjet.rechercherProjet(critere);
		
		resp.getWriter().print(new JSONArray(projets));
	}
}