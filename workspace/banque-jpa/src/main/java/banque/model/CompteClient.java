package banque.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="customer_compte")
@IdClass(CompteClientId.class)
public class CompteClient {
	// ------------------ Attributs ------------------ 
//	private long id;
	private Compte2 compte;
	private Client client;
	
	
	// ------------------ Constructeurs ------------------ 
	public CompteClient() {
		super();
	}
	
	public CompteClient(Compte2 compte, Client client) {
		this.compte = compte;
		this.client = client;
	}
	
	
	// ------------------ Getters & Setters ------------------ 
//	@Id
//	@GeneratedValue
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}

	@Id
	@ManyToOne
	public Compte2 getCompte() {
		return compte;
	}

	public void setCompte(Compte2 compte) {
		this.compte = compte;
	}

	@Id
	@ManyToOne
	@JoinColumn(name="lol")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
