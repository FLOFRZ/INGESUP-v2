package com.ynov.appbancairev2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clientID;
	private String nom;
	private String prenom;
	private String password;
	private String login;
	
	@OneToMany(mappedBy="client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Compte> comptes;
	
	
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	public Client() {
		
	}
	public Client(String Nom, String Prenom, String Login, String Password) {
		nom = Nom;
		prenom = Prenom;
		login = Login;
		password = Password;
		
	}
	public String toString() {
		return clientID + " " + nom + " " + prenom + " " + login;
	}
	
	public String toXML() {
		return "<Client> <clientID>"+clientID+"</clientID> <nom>"+nom+"</nom> <prenom>"+prenom+"</prenom> <password>"+password+"</password> <login>"+login+"</login> </Client>";
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
}
