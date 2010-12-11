package fr.unice.miage.xmlsearch.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import fr.unice.miage.xmlsearch.dao.ThemeDAO;
import fr.unice.miage.xmlsearch.objets.Theme;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GetThemeParAnnee extends Servlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String annee = req.getParameter("annee");
		if(annee == null || annee.isEmpty()) {
			return;
		}
		
		ThemeDAO daoTheme = new ThemeDAO(this.getServletContext().getInitParameter(NOM_PARAMETRE_CONTEXTE));
		List<Theme> themes = daoTheme.getThemeParAnnee(annee);
		
		resp.getWriter().print(new JSONObject(themes));
		
	}

}
