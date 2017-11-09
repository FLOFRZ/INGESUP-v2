package com.ynov.appbancairev2.servlet;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ynov.appbancairev2.dao.ClientDAO;
import com.ynov.appbancairev2.model.Client;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static Logger logger = LogManager.getLogger(ClientDAO.class.getName());
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ServletHelper.LOGIN);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Client currentClient = ClientDAO.getClientByCredential(login, password);
		if (currentClient != null) 
		{
			logger.info("Le client "+currentClient.getLogin()+ " est connecté.");
			//Appeler getSession avec False permet de ne pas créer une nouvelle connexion si elle n'existe pas
			HttpSession session = request.getSession(false);
			session.setAttribute("client", currentClient);
			response.sendRedirect(request.getContextPath()+ServletHelper.SERVLET_ACCOUNT);
		}
		else 
		{
			request.setAttribute("message", "Erreur de connexion");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ServletHelper.LOGIN);
			dispatcher.forward(request, response);
			logger.info("Erreur de connexion !");
		}
		
			
	}

}
