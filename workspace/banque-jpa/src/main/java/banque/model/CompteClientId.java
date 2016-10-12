package banque.model;

import java.io.Serializable;

public class CompteClientId implements Serializable {
	private Client client;
	private Compte2 compte;
	
	public CompteClientId() {
		super();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Compte2 getCompte() {
		return compte;
	}

	public void setCompte(Compte2 compte) {
		this.compte = compte;
	}
	
	
	
}
