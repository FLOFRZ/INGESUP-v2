package com.ynov.appbancairev2.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ynov.appbancairev2.dao.ClientDAO;
import com.ynov.appbancairev2.dao.CompteDAO;
import com.ynov.appbancairev2.dao.TransactionDAO;
import com.ynov.appbancairev2.model.Client;
import com.ynov.appbancairev2.model.Compte;
import com.ynov.appbancairev2.model.Transaction;

/**
 * Servlet implementation class Transfer
 */
@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
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
		Map<Compte, Integer> comptesAndSoldes = new HashMap<Compte, Integer>();
		
		for (Compte c : currentClientComptes) {
			comptesAndSoldes.put(c, (int)CompteDAO.getSolde(c));
		}
		
		request.setAttribute("Client", currentClient);
		request.setAttribute("Comptes", comptesAndSoldes);
		
		//Liaison avec le fichier JSP (view)
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ServletHelper.TRANSFER);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int CompteTransmiter = Integer.parseInt(request.getParameter("transmitter"));
		int CompteReceiver   = Integer.parseInt(request.getParameter("receiver"));
		int amountR           = Integer.parseInt(request.getParameter("amount"));
		int amountT = amountR-(2*amountR);
		String libelle       = request.getParameter("libelle");
		
		Date currentDate = new Date();
		Transaction transactionReceiver   = new Transaction(libelle,currentDate,(double)amountR, CompteDAO.getCompteById(CompteReceiver) );
		Transaction transactionTransmiter = new Transaction(libelle,currentDate,(double)amountT, CompteDAO.getCompteById(CompteTransmiter) );
		boolean result;
		
		if (TransactionDAO.addTransaction(transactionReceiver) && TransactionDAO.addTransaction(transactionTransmiter))
			result = true;
		else
			result = false;
		
		request.setAttribute("result", result);
	
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ServletHelper.TRANSFER);
		dispatcher.forward(request, response);
	}

}
