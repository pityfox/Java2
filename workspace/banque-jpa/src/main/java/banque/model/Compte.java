package banque.model;

import java.util.*;

import javax.persistence.*;

@Entity
public class Compte {
	// ------------------ Attributs  ------------------ 
	private String numCompte;
	private boolean joint;
	private float solde;
	private Date dtOuverture;
//	private List<Client> clients = new ArrayList<Client>();
	private List<CompteClient> compteClient = new ArrayList<CompteClient>();
	// ------------------ Constructeurs ------------------ 
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
//		this.clients = clients;
	}
	
// ------------------ Getters & Setters ------------------ 
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

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

//	@OneToMany(mappedBy="client")
//	public List<Client> getClients() {
//		return clients;
//	}
//
//	public void setClients(List<Client> clients) {
//		this.clients = clients;
//	}

	@Temporal(TemporalType.DATE)
	public Date getDtOuverture() {
		return dtOuverture;
	}

	public void setDtOuverture(Date dtOuverture) {
		this.dtOuverture = dtOuverture;
	}
	
	@OneToMany(mappedBy="compte")
	public List<CompteClient> getCompteClient() {
		return compteClient;
	}

	public void setCompteClient(List<CompteClient> compteClient) {
		this.compteClient = compteClient;
	}
	
	
	
}
