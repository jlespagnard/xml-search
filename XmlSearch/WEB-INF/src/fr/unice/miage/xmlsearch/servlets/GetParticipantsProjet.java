package fr.unice.miage.xmlsearch.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import fr.unice.miage.xmlsearch.dao.ProjetDAO;
import fr.unice.miage.xmlsearch.objets.Participant;

@SuppressWarnings("serial")
public class GetParticipantsProjet extends Servlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String shortName = req.getParameter("shortname");
		if(shortName == null || shortName.isEmpty()) {
			return;
		}
		
		String contexte = this.getInitParameter(NOM_PARAMETRE_CONTEXTE);
		ProjetDAO dao = new ProjetDAO(contexte);
		
		List<Participant> participants = dao.getParticipantsProjet(shortName);
		if(participants == null || participants.isEmpty()) {
			return;
		}
		
		resp.getWriter().print(new JSONObject(participants));
	}
}