package banque.model;

import javax.persistence.*;

@Entity
@Table(name = "customer_compte")
@IdClass(ClientCompteId.class)
public class ClientCompte {

	private Client client;
	private Compte compte;
	private int version;
	
	public ClientCompte() {
		super();
	}

	public ClientCompte(Client client, Compte compte) {
		super();
		this.client = client;
		this.compte = compte;
	}

	@Id
	@ManyToOne
	@JoinColumn(name = "customer_id")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Id
	@ManyToOne
	@JoinColumn(name = "compte_numcompte")
	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
}
