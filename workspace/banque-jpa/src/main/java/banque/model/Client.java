package banque.model;

import java.util.*;

import javax.persistence.*;

// Entité obligatoire pour BDD
@Entity
//Changer le nom de la table != du nom de la classe
@Table(name="customer")
// Création de tables secondaires pour stocker certains attributs
@SecondaryTable(name="customer_comment")
public class Client {
	// -------------- Attributs --------------
	private long id;
	private String nom;
	private String prenom;
	private Date ddn;
	private String commentaire;
	private Titre titre;
	private Adresse adresse;
	private Agence agence;
	//ManytoMany
//	private List<Agence> agences = new ArrayList<Agence>();
//	private List<Compte> comptes = new ArrayList<Compte>();
	private List<CompteClient> compteClient = new ArrayList<CompteClient>();
	
	// -------------- Constructeurs --------------
	public Client(){
		super();
	}

	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	// -------------- Getters & Setters --------------
	// Généré auto
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	// Changer le nom de la column != du nom de variable
	@Column(name="LastName", length=100)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name="FirstName", length=100)
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name="Birthdate")
	public Date getDdn() {
		return ddn;
	}

	public void setDdn(Date ddn) {
		this.ddn = ddn;
	}

	//Commentaire = Gros volume de string
	@Lob
	// Du coup LAZY pour charger que quand on l'appel, éviter
	// surcharge mem..
	@Basic(fetch = FetchType.LAZY)
	// Renommer la colonne + externaliser dans une autre table
	@Column(name="comments", table="customer_comment")
	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="Title", length=5)
	public Titre getTitre() {
		return titre;
	}

	public void setTitre(Titre titre) {
		this.titre = titre;
	}

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="rue", column=@Column(name = "street", length=100)),
		@AttributeOverride(name="codePostal", column=@Column(name="zipCode", length=10)),
		@AttributeOverride(name="ville", column=@Column(name="city", length = 100))
	})
	public Adresse getAdresse(){
		return adresse;
	}

	public void setAdresse(Adresse adresse){
		this.adresse = adresse;
	}

//	@OneToOne
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="agence_numBanque", referencedColumnName="numBanque"),
		@JoinColumn(name="agence_numAgence", referencedColumnName="numAgence")
	})
	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}


	
//	//ManyToMany
//	@ManyToMany(mappedBy="clients")
//	public List<Agence> getAgences() {
//		return agences;
//	}
//
//	public void setAgences(List<Agence> agences) {
//		this.agences = agences;
//	}
//
//	public void addAgence(Agence agence){
//		this.agences.add(agence);
//	}
//
//	public void removeAgence(Agence agence){
//		this.agences.remove(agence);
//	}
	
//	@ManyToMany
//	@JoinTable({
//		
//	})
//	public List<Compte> getComptes() {
//		return comptes;
//	}
//
//	public void setComptes(List<Compte> comptes) {
//		this.comptes = comptes;
//	}
//	
//	
//	public void addCompte(Compte compte){
//		this.comptes.add(compte);
//	}
//	
//	public void removeCompte(Compte compte){
//		this.comptes.remove(compte);
//	}

	@OneToMany(mappedBy="client")
	public List<CompteClient> getCompteClient() {
		return compteClient;
	}

	public void setCompteClient(List<CompteClient> compteClient) {
		this.compteClient = compteClient;
	}
	
	
}
