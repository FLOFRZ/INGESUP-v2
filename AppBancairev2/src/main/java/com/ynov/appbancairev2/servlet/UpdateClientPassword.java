package com.ynov.appbancairev2.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ynov.appbancairev2.dao.ClientDAO;
import com.ynov.appbancairev2.model.Client;

/**
 * Servlet implementation class UpdateClientPassword
 */
@WebServlet("/UpdateClientPassword")
public class UpdateClientPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClientPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//Liaison avec le fichier JSP (view)
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ServletHelper.UPDATEPASSWORD);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPass = request.getParameter("currentPass");
		String newPass1    = request.getParameter("newPass1");
		String newPass2    = request.getParameter("newPass2");
		
		HttpSession session = request.getSession(false); 
		Client currentClient = (Client)session.getAttribute("client");
		
		// En fonction du resultat retourné par la fonction updatePassword(), on affiche un message différent
		int result = ClientDAO.updatePassword(currentClient, currentPass, newPass1, newPass2);
		
		request.setAttribute("result", result);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ServletHelper.UPDATEPASSWORD);
		dispatcher.forward(request, response);
	}

}
