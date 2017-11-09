package com.ynov.appbancairev2.rest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ynov.appbancairev2.dao.ClientDAO;
import com.ynov.appbancairev2.model.Client;

/**
 * Servlet implementation class Client
 */
@WebServlet("/Client")
public class ClientRest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientRest() {
        super();
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// le getParameter permet de récupérer la valeur du paramètre passé dans l'url. 
		// la chaine de caractère doit être identique au nom du paramètre dans l'url
		String idClient = request.getParameter("idClient");
		Client c = ClientDAO.getClientByID(Integer.parseInt(idClient));
		
		response.setContentType("text/xml");
		response.getWriter().append(c.toXML());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
