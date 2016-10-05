package banque.model;

import java.util.*;

import javax.persistence.*;

@Entity
public class Compte {
	private String numCompte;
	private boolean joint;
	private long solde;
	private List<Client> clients = new ArrayList<Client>();
	
	public Compte() {
		super();
	}

	public Compte(String numCompte, boolean joint, long solde) {
		this.numCompte = numCompte;
		this.joint = joint;
		this.solde = solde;
	}
	
	public Compte(String numCompte, boolean joint, long solde, List<Client> clients) {
		this(numCompte, joint, solde);
		this.clients = clients;
	}
	
	@Id
	public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}

	public boolean isJoint() {
		return joint;
	}

	public void setJoint(boolean joint) {
		this.joint = joint;
	}

	public long getSolde() {
		return solde;
	}

	public void setSolde(long solde) {
		this.solde = solde;
	}

	@ManyToMany(mappedBy="comptes")
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	
	
}
