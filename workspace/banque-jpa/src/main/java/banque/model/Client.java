package banque.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// Entité obligatoire pour BDD
@Entity
//Changer le nom de la table != du nom de la classe
@Table(name="customer")
public class Client {
	// Attributs
	private long id;
	
	// Changer le nom de la column != du nom de variable
	@Column(name="name")
	private String nom;
	private String prenom;
	private Date ddn;
	
	//Getters & Setters
	
	public Date getDdn() {
		return ddn;
	}

	public void setDdn(Date ddn) {
		this.ddn = ddn;
	}

	public String getNom() {
		return nom;
	}

	// Genéré auto... sur getter ??
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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


	// Constructeurs
	public Client(){
		super();
	}

	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
}
