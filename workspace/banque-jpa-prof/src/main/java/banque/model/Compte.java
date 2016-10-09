package banque.model;

import java.util.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
public abstract class Compte {
	private String numCompte;
	private float solde;
	private boolean joint;
	private Date dtOuverture;
	// private List<Client> clients = new ArrayList<Client>();
	private List<ClientCompte> clients = new ArrayList<ClientCompte>();
	private int version; //Gestion de versions
	
	public Compte() {
		super();
	}

	public Compte(String numCompte) {
		super();
		this.numCompte = numCompte;
	}

	@Id
	public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public boolean isJoint() {
		return joint;
	}

	public void setJoint(boolean joint) {
		this.joint = joint;
	}

	@Temporal(TemporalType.DATE)
	public Date getDtOuverture() {
		return dtOuverture;
	}

	public void setDtOuverture(Date dtOuverture) {
		this.dtOuverture = dtOuverture;
	}

	@OneToMany(mappedBy="compte")
	public List<ClientCompte> getClients() {
		return clients;
	}

	public void setClients(List<ClientCompte> clients) {
		this.clients = clients;
	}

	
	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	// ToString
	@Override
	public String toString() {
		return "Compte [numCompte=" + numCompte + ", solde=" + solde + ", joint=" + joint + ", dtOuverture="
				+ dtOuverture + ", clients=" + clients + "]";
	}

	// @ManyToMany(mappedBy="comptes")
	// public List<Client> getClients() {
	// return clients;
	// }
	//
	// public void setClients(List<Client> clients) {
	// this.clients = clients;
	// }
	
	

}
