package com.ynov.appbancairev2.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ynov.appbancairev2.model.Client;
import com.ynov.appbancairev2.model.Compte;
import com.ynov.appbancairev2.model.Transaction;

public class CompteDAO  {

	private static Logger logger = LogManager.getLogger(CompteDAO.class.getName());
	
	public static List<Compte> getComptesByClient(int idClient) 
	{
		List<Compte> comptes = new ArrayList<>();	
		EntityManager em = DAOManager.getInstance().createEntityManager();	
		try {			
			comptes = em.createNativeQuery("select * from compte where clientID = :id",
				    Compte.class).setParameter("id", idClient).getResultList();
			logger.info("Les comptes du client n°"+ idClient + " sont chargés...");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();	
		}
		return comptes;
	}

	public static List<Compte> getAllComptes()
	{
		List<Compte> comptes = new ArrayList<>();	
		EntityManager em = DAOManager.getInstance().createEntityManager();	
		try {			
			comptes = em.createQuery("from Compte").getResultList();
			logger.info("Tous les comptes sont chargés...");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();	
		}
		return comptes;
		
	}
	
	public static double getSolde(Compte compte) {
		double solde=0;
		List<Transaction> transacs= TransactionDAO.getTransactionsByCompte(compte.getNum());
		for (Transaction t : transacs) {
			solde += t.getMontant();
		}
		return solde;
	}
	
	public static Compte getCompteById(int id) {
		Compte c = null;
		EntityManager em = DAOManager.getInstance().createEntityManager();	
		try {			
			c = em.find(Compte.class, id);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();	
		}
		return c;
	}
	
}
