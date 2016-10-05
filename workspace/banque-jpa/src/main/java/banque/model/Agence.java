package banque.model;

import java.util.*;
import javax.persistence.*;

@Entity
//@IdClass(AgenceId.class)
public class Agence {
	// ---------- Attributs ------------
	private AgenceId id;
//	private Integer numBanque;
//	private Integer numAgence;
	private String libelle;
	private String horaires;
	private Adresse adresse;
	//OneToOne
	private Client client;
	//OneToMany
	private List<Client> clients = new ArrayList<Client>();
	
	// ------------ Constructeurs ------------
	public Agence(Integer numBanque, Integer numAgence){
		this.id = new AgenceId(numBanque, numAgence);
	}
	
	public Agence() {
		super();
	}

	// ------------ Getters & Setters ------------
	//@Id //pour le IdClass
//	public Integer getNumBanque() {
//		return numBanque;
//	}
//
//	public void setNumBanque(Integer numBanque) {
//		this.numBanque = numBanque;
//	}

	//@Id // pour le IdClass
//	public Integer getNumAgence() {
//		return numAgence;
//	}
//
//	public void setNumAgence(Integer numAgence) {
//		this.numAgence = numAgence;
//	}


	public String getLibelle() {
		return libelle;
	}
	
	@EmbeddedId // Pour l embedded
	public AgenceId getId() {
		return id;
	}

	public void setId(AgenceId id) {
		this.id = id;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getHoraires() {
		return horaires;
	}

	public void setHoraires(String horaires) {
		this.horaires = horaires;
	}

	@Embedded
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@OneToOne(mappedBy="agence")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	@OneToMany(mappedBy="agence")
//	@ManyToMany
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public void addClient(Client client){
		this.clients.add(client);
	}
	
	public void removeClient(Client client){
		this.clients.remove(client);
	}
}
