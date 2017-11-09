package com.ynov.appbancairev2.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOManager {
	
	private static final String PERSISTENCE_UNIT_NAME = "AppBancairePersi";
	private static EntityManagerFactory factory;

	// Constructeur priv�
	private DAOManager() {
		try {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// M�thode qui va nous retourner notre instance et la cr�er si elle n'existe pas
	public static EntityManagerFactory getInstance() {
		if (factory == null) {
			new DAOManager();
		}
		return factory;
	}

	

}
