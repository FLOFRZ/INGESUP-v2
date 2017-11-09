package com.ynov.appbancairev2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	private String libelle;
	
	@OneToMany(mappedBy="leCompte", cascade = CascadeType.ALL)
	List<Transaction> transactions;
	
	@ManyToOne
	@JoinColumn(name="clientID")
	private Client client;

	public Compte(){
		
	}
	
	public Compte(String unLibelle, Client unClient) {
		libelle=unLibelle;
		client=unClient;		
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	
}
