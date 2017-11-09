package com.ynov.appbancairev2.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transacID;
	private String libelle;
	private Date dateTransac;
	private double montant;
	
	@ManyToOne 
	@JoinColumn(name="num")
	private Compte leCompte;
	
	public Transaction() {
		
	}
	
	public Transaction(String unLibelle, Date uneDate, Double unMontant, Compte unCompte) {
		libelle = unLibelle;
		dateTransac = uneDate;
		montant= unMontant;
		leCompte = unCompte;
	}
	
	public int getTransacID() {
		return transacID;
	}
	public void setTransacID(int transacID) {
		this.transacID = transacID;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Date getDateTransac() {
		return dateTransac;
	}
	public void setDateTransac(Date dateTransac) {
		this.dateTransac = dateTransac;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	

	
}
