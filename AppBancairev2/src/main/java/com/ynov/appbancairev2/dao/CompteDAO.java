package com.ynov.appbancairev2.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ynov.appbancairev2.model.Compte;

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
}
