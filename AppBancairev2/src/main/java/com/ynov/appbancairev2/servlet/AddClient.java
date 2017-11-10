package com.ynov.appbancairev2.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ynov.appbancairev2.dao.ClientDAO;
import com.ynov.appbancairev2.model.Client;

/**
 * Servlet implementation class AddClient
 */
@WebServlet("/AddClient")
public class AddClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Liaison avec le fichier JSP (view)
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ServletHelper.ADDCLIENT);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login  = request.getParameter("loginC");
		String nom    = request.getParameter("nomC");
		String prenom = request.getParameter("prenomC");
		String pass   = request.getParameter("passC");
		
		Client c = new Client(nom, prenom, login, pass);
		int result = ClientDAO.addClient(c);
		
		request.setAttribute("result", result);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ServletHelper.ADDCLIENT);
		dispatcher.forward(request, response);
	}

}
