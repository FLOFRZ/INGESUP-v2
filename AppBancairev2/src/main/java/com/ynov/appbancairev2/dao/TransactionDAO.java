package com.ynov.appbancairev2.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ynov.appbancairev2.model.Transaction;
import com.ynov.appbancairev2.validation.PasswordValidation;

public class TransactionDAO {
	private static Logger logger = LogManager.getLogger(TransactionDAO.class.getName());

	public static List<Transaction> getTransactionsByCompte(int numCompte) 
	{
		List<Transaction> transacs = new ArrayList<>();	
		EntityManager em = DAOManager.getInstance().createEntityManager();	
		try {			
			transacs = em.createNativeQuery("select * from transaction where num = :pNum",
				    Transaction.class).setParameter("pNum", numCompte).getResultList();
			logger.info("Les transactions du comptes n°"+ numCompte+ " sont chargées ..." );
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();	
		}
		return transacs;
	}
	
	public static List<Transaction> getAllTransactions() 
	{
		List<Transaction> transacs = new ArrayList<>();	
		EntityManager em = DAOManager.getInstance().createEntityManager();	
		try {			
			transacs = em.createQuery("from  Transaction").getResultList();
			logger.info("Toutes les transactions sont chargées ...");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			em.close();	
		}
		return transacs;
	}

	public static boolean addTransaction(Transaction t) {
		EntityManager em = DAOManager.getInstance().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			logger.info("La transaction "+t.getLibelle()+" a été ajouté en base !");
			return true;
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			logger.error(e.getCause());
			return false;
		}
		finally {
			em.close();
		}
	}
}
