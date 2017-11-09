package com.ynov.appbancairev2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ynov.appbancairev2.model.Client;
import com.ynov.appbancairev2.model.Compte;
import com.ynov.appbancairev2.model.Transaction;



public class TestJPA {
	private static final String PERSISTENCE_UNIT_NAME = "AppBancairePersi";
	private static EntityManagerFactory factory;
	
	private static Logger logger = LogManager.getLogger(TestJPA.class);
			
	public static void main(String[] args) {

		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		//create new client 

		Client clientTest = new Client("Ferrandez", "Florent", "test", "test");
		
		Compte compteTest = new Compte("compteDeTest", clientTest);
		Date date = new Date();
		Transaction transacTest = new Transaction("achat1", date, 12.2, compteTest);
		
		List<Compte> comptes = new ArrayList<>();
		List<Transaction> transactions = new ArrayList<>();
		comptes.add(compteTest);
		transactions.add(transacTest);
		clientTest.setComptes(comptes);
		compteTest.setTransactions(transactions);
		
		logger.info(clientTest.toString());
		em.getTransaction().begin();
		em.persist(clientTest);
		em.getTransaction().commit();
		
		
		TypedQuery<Client> tQuery = em.createQuery("from Client", Client.class);
		List<Client> clientList = tQuery.getResultList();
		
		PersistenceUtil util = Persistence.getPersistenceUtil();

		for (Client c : clientList) {
			logger.info(c.toString());
			logger.debug("is client loaded ? " + util.isLoaded(c));
			logger.debug("is compte loaded ? " + util.isLoaded(c.getComptes()));
			Compte co = c.getComptes().get(0);
			logger.debug("are transaction loaded ? " + util.isLoaded(co, "transations"));
			co.getTransactions();
			logger.debug("are transactions loaded now ?" + util.isLoaded(co, "transactions"));
			for(Transaction tran : co.getTransactions()) {
				logger.info(tran.toString());
			}
		}
		logger.info("Size: " + clientList.size());
		
		em.close();
		factory.close();
		
		
		
	}

}
