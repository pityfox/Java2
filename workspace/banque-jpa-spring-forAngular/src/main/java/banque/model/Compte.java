package banque.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Compte {
	private String numCompte;
	private int version;
	private float solde;
	private boolean joint;
	private Date dtOuverture;
	// private List<Client> clients = new ArrayList<Client>();
	private List<ClientCompte> clients = new ArrayList<ClientCompte>();

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

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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

	@OneToMany(mappedBy = "compte")
	public List<ClientCompte> getClients() {
		return clients;
	}

	public void setClients(List<ClientCompte> clients) {
		this.clients = clients;
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
