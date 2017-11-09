package com.ynov.appbancairev2.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ynov.appbancairev2.dao.ClientDAO;
import com.ynov.appbancairev2.dao.CompteDAO;
import com.ynov.appbancairev2.model.Client;
import com.ynov.appbancairev2.model.Compte;

/**
 * Servlet implementation class Essai 
 * Le tag au dessus permet de faire la liaison avec l'url. 
 */

@WebServlet("/ClientAccount")
public class DisplayClients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayClients() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false); 
		Client currentClient = (Client)session.getAttribute("client");
		List<Compte> currentClientComptes = CompteDAO.getComptesByClient(currentClient.getClientID()); // récupère les comptes du client de la session 
		
		request.setAttribute("Client", currentClient);
		request.setAttribute("Comptes", currentClientComptes);
		
		//Liaison avec le fichier JSP (view)
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ServletHelper.ACCOUNT);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("loginC");
		String nom = request.getParameter("nomC");
		String prenom = request.getParameter("prenomC");
		String pass = request.getParameter("passC");
		Client c = new Client(nom, prenom, login, pass);
		ClientDAO.addClient(c);
		
	}

}
