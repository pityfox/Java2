package banque.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.Valid;

@Entity
// @IdClass(AgenceId.class)
public class Agence {
	// private Integer numBanque;
	// private Integer numAgence;
	private AgenceId id;
	private int version;
	private String libelle;
	private String horaires;
	private Adresse adresse;
	private List<Client> clients = new ArrayList<Client>();

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
	@Valid
	public AgenceId getId() {
		return id;
	}

	public void setId(AgenceId id) {
		this.id = id;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
	@Valid
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@OneToMany(mappedBy = "agence")
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public void addClient(Client client) {
		this.clients.add(client);
	}

	public void removeClient(Client client) {
		this.clients.remove(client);
	}

}
