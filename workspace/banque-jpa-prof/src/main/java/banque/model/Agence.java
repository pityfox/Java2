package banque.model;

import java.util.*;

import javax.persistence.*;

@Entity
// @IdClass(AgenceId.class)
public class Agence {
	// private Integer numBanque;
	// private Integer numAgence;
	private AgenceId id;
	private String libelle;
	private String horaires;
	private Adresse adresse;
	private List<Client> clients = new ArrayList<Client>();
	private int version;
	
	public Agence() {
		super();
	}

	public Agence(Integer numBanque, Integer numAgence) {
		super();
		this.id = new AgenceId(numBanque, numAgence);
	}

	// @Id
	// public Integer getNumBanque() {
	// return numBanque;
	// }
	//
	// public void setNumBanque(Integer numBanque) {
	// this.numBanque = numBanque;
	// }
	//
	// @Id
	// public Integer getNumAgence() {
	// return numAgence;
	// }
	//
	// public void setNumAgence(Integer numAgence) {
	// this.numAgence = numAgence;
	// }

	@EmbeddedId
	public AgenceId getId() {
		return id;
	}

	public void setId(AgenceId id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
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

	@OneToMany(mappedBy="agence")
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	// Méthodes ajout suppression
	public void addClient(Client client) {
		this.clients.add(client);
	}
	
	public void removeClient(Client client) {
		this.clients.remove(client);
	}
	
}
