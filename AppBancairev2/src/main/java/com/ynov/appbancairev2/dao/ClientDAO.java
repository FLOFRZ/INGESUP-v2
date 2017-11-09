package com.ynov.appbancairev2.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ynov.appbancairev2.TestJPA;
import com.ynov.appbancairev2.model.Client;
import com.ynov.appbancairev2.validation.PasswordValidation;

public class ClientDAO {
	
	private static Logger logger = LogManager.getLogger(ClientDAO.class.getName());
	
	public static Client getClientByID(int clientID) 
	{
		Client client= null;	
		EntityManager em = DAOManager.getInstance().createEntityManager();	
		try {			
			client = em.find(Client.class, clientID);
			logger.info("Le client n°"+clientID +" est chargé ...");
		}
		catch(Exception e) {
			logger.error("getClientByID("+clientID+") génère une erreur");
			System.out.println(e.getMessage());
			logger.error(e.getMessage());
			logger.error(e.getCause());
		}
		finally {
			em.close();	
		}
		return client;
	}
	
	public static Client getClientByCredential(String login, String pass) {
		EntityManager em = DAOManager.getInstance().createEntityManager();
		Client client = null;
		try {
			Query q = em.createQuery("SELECT clientID FROM Client c WHERE c.login LIKE :pLogin AND c.password=:pPassword")
					.setParameter("pLogin", login)
					.setParameter("pPassword", pass);
			int id = (int)q.getResultList().get(0);
			if ( id>0) {
				client = getClientByID(id);
			}	
		}
		catch(Exception e) {
			logger.error("getClientByCredential("+login+", "+pass+") génère une erreur");
			logger.error(e.getMessage());
			logger.error(e.getCause());
		}
		finally {
			em.close();
		}
		return client;
	}
	
	public static List<Client> getAllClients()
	{
		EntityManager em = DAOManager.getInstance().createEntityManager();
		List<Client> allClients = new ArrayList<>();
		try {
			Query q = em.createQuery("from Client");
			allClients = q.getResultList();
			logger.info("Tous les clients sont chargés ...");
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			logger.error(e.getCause());
		}
		finally {
			em.close();
		}
		return allClients;
	}
	
	public static void addClient(Client newClient) {
		EntityManager em = DAOManager.getInstance().createEntityManager();
		try {
			
			em.getTransaction().begin();
			em.persist(newClient);
			em.getTransaction().commit();
			
			logger.info("Le client "+newClient.getPrenom()+" a été ajouté en base !");
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			logger.error(e.getCause());
		}
		finally {
			em.close();
		}
	}
	
	public static boolean clientExist(String login, String pass) {
		EntityManager em = DAOManager.getInstance().createEntityManager();
		boolean result = false;
		try {
			Query q = em.createNativeQuery("Select clientID from client where login= :login and password= :password");
			em.setProperty("login", login);
			em.setProperty("password", pass);
			int idClient = Integer.parseInt(q.toString());
			if  (em.find(Client.class, idClient) != null) 
				result = true;
		}
		catch(Exception e) {
			logger.error("clientExist("+login+", "+pass+") génère une erreur");
			logger.error(e.getMessage());
			logger.error(e.getCause());
		}
		finally {
			em.close();
		}
		return result;
	}
	
	public static int updatePassword(Client currentClient, String currentPass, String newPass1, String newPass2) {
		// 0 ==> mdp a été changé correctement
		// 1 ==> le mdp actuel saisie correspond pas mdp du compte
		// 2 ==> Le nouveaux mdp ne respecte pas le regex  
		// 3 ==> Les deux nouveaux mdp ne sont pas égaux 

		int result = 0;
		EntityManager em = DAOManager.getInstance().createEntityManager();
		
		//Test si le "mdp actuel" saisie par l'utilisateur correspond à son mdp.
		String realCurrentPass = currentClient.getPassword();
		if (!realCurrentPass.equals(currentPass))
			return 1;
		
		//Test si le mdp respecte le regex
		if (!PasswordValidation.validPassword(newPass1))
			return 2;

		//Test si les deux nouveaux mdp sont égaux
		if (!newPass1.equals(newPass2))
			return 3;
		
		
		try {
			currentClient.setPassword(newPass1);
			em.getTransaction().begin();
			currentClient = em.merge(currentClient);
			em.persist(currentClient);
			em.getTransaction().commit();
			
			logger.info("Le mdp du client "+currentClient.getPrenom()+" a été mis à jour !");
		}
		catch(Exception e) {
			logger.error("updatePassword() génère une erreur");
			logger.error(e.getMessage());
			logger.error(e.getCause());
		}
		finally {
			em.close();
		}
		return result;
	}

	
}
