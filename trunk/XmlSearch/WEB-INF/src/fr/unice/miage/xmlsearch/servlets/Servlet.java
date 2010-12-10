package fr.unice.miage.xmlsearch.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public abstract class Servlet extends HttpServlet {
	protected static final String NOM_PARAMETRE_CONTEXTE = "uriDbQuery";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	public abstract void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;
}