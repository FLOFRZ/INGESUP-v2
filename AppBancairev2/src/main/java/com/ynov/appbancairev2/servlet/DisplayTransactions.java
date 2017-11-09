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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ynov.appbancairev2.dao.ClientDAO;
import com.ynov.appbancairev2.dao.TransactionDAO;
import com.ynov.appbancairev2.model.Client;
import com.ynov.appbancairev2.model.Transaction;

/**
 * Servlet implementation class DisplayTransactions
 */
@WebServlet("/Transactions/*")
public class DisplayTransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(ClientDAO.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayTransactions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupération du numéro de compte passé dans l'url
		String url = request.getRequestURI();
		String[] urlSplited = url.split("/");
		int numCompte = Integer.parseInt(urlSplited[3]);
		logger.info("Numéro de compte sélectionné : "+ numCompte);
		
		//Récupération du client de la session 
		HttpSession session = request.getSession(false);
		Client currentClient = (Client)session.getAttribute("client");
		
		//Récupération des transaction du compte sélectionné
		List<Transaction> transactions = TransactionDAO.getTransactionsByCompte(numCompte);
		logger.info("Transactions : " + transactions.get(0).getLibelle() + " , "+ transactions.get(1).getLibelle());
		
		request.setAttribute("NumCompte", numCompte);
		request.setAttribute("Client", currentClient);
		request.setAttribute("Transactions", transactions);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ServletHelper.TRANSACTIONS);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
