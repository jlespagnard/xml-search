package fr.unice.miage.xmlsearch.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import fr.unice.miage.xmlsearch.dao.CentreRechercheDAO;
import fr.unice.miage.xmlsearch.utils.Constantes;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GetMembresCR extends Servlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String idCR = req.getParameter(Constantes.CentreRecherche.ID.getLabel());
		
		CentreRechercheDAO daoCentreRechercheDAO = new CentreRechercheDAO(this.getServletContext().getInitParameter(NOM_PARAMETRE_CONTEXTE));
		List<String> membres = daoCentreRechercheDAO.getMembresCR(idCR);
		
		resp.getWriter().print(new JSONArray(membres));
		
	}

}