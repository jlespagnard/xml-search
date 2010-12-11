package fr.unice.miage.xmlsearch.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import fr.unice.miage.xmlsearch.dao.CentreRechercheDAO;
import fr.unice.miage.xmlsearch.objets.CentreRecherche;

@SuppressWarnings("serial")
public class GetCentresRecherche extends Servlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CentreRechercheDAO daoCentre = new CentreRechercheDAO(this.getServletContext().getInitParameter(NOM_PARAMETRE_CONTEXTE));
		List<CentreRecherche> centres = daoCentre.getCentresRecherche();
		
		resp.getWriter().print(new JSONArray(centres));
	}
}