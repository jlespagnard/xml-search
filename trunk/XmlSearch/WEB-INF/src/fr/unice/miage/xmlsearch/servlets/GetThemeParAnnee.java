package fr.unice.miage.xmlsearch.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;

import fr.unice.miage.xmlsearch.dao.ThemeDAO;
import fr.unice.miage.xmlsearch.utils.Constantes;

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
		
		String annee = req.getParameter(Constantes.Theme.ANNEE.getLabel());
		
		ThemeDAO daoTheme = new ThemeDAO(this.getServletContext().getInitParameter(NOM_PARAMETRE_CONTEXTE));
		Map<String, String> themes = daoTheme.getThemeParAnnee(annee);
		if(themes == null || themes.isEmpty()) {
			return;
		}
		
		try {
			resp.getWriter().print(new JSONArray(themes.entrySet().toArray()));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}