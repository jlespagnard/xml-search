package fr.unice.miage.xmlsearch.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class GetProjet extends Servlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		String shortName = req.getParameter("shortName");
//		if(shortName == null || shortName.isEmpty()) {
//			return;
//		}
//		
//		ProjetCritere critere = new ProjetCritere(new String[]{shortName}, null, null, null, null, null);
//		String contexte = this.getServletContext().getInitParameter(NOM_PARAMETRE_CONTEXTE);
//		ProjetDAO dao = new ProjetDAO(contexte);
//		
//		List<Object> projets = dao.rechercher(critere);
//		if(projets == null || projets.isEmpty()) {
//			return;
//		}
//		
//		Projet projet = (Projet)projets.get(0);
//		resp.getWriter().print(new JSONObject(projet));
	}
}