package banque.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "customer")
@SecondaryTable(name = "customer_comment")
public class Client {

	private long id;
	private int version;
	private String nom;
	private String prenom;
	private Date dtNaissance;
	private String commentaire;
	private Titre titre;
	private Adresse adr;
	private Agence agence;
//	private List<Compte> comptes = new ArrayList<Compte>();
	private List<ClientCompte> comptes = new ArrayList<ClientCompte>();

	public Client() {
		super();
	}

	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "lastname", length = 100)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "firstname", length = 100)
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate")
	public Date getDtNaissance() {
		return dtNaissance;
	}

	public void setDtNaissance(Date dtNaissance) {
		this.dtNaissance = dtNaissance;
	}

	@Column(name = "comments", table = "customer_comment")
	@Basic(fetch = FetchType.LAZY)
	@Lob
	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "title", length = 10)
	public Titre getTitre() {
		return titre;
	}

	public void setTitre(Titre titre) {
		this.titre = titre;
	}

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "rue", column = @Column(name = "street", length = 50) ),
			@AttributeOverride(name = "codePostal", column = @Column(name = "zipcode", length = 10) ),
			@AttributeOverride(name = "ville", column = @Column(name = "city", length = 50) ) })
	public Adresse getAdr() {
		return adr;
	}

	public void setAdr(Adresse adr) {
		this.adr = adr;
	}

	@ManyToOne
	@JoinColumns({ @JoinColumn(referencedColumnName = "numBanque", name = "agence_numBanque"),
			@JoinColumn(referencedColumnName = "numAgence", name = "agence_numAgence") })
	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

//	@ManyToMany
//	@JoinTable(name="customer_compte", joinColumns=@JoinColumn(name="customer_id"), inverseJoinColumns=@JoinColumn(name="compte_numcompte"))
//	public List<Compte> getComptes() {
//		return comptes;
//	}
//
//	public void setComptes(List<Compte> comptes) {
//		this.comptes = comptes;
//	}
//	
//	public void addCompte(Compte compte) {
//		this.comptes.add(compte);
//	}
//	
//	public void remvoeCompte(Compte compte) {
//		this.comptes.remove(compte);
//	}
	
	

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dtNaissance=" + dtNaissance
				+ ", commentaire=" + commentaire + ", titre=" + titre + "]";
	}

	@OneToMany(mappedBy="client")
	public List<ClientCompte> getComptes() {
		return comptes;
	}

	public void setComptes(List<ClientCompte> comptes) {
		this.comptes = comptes;
	}

}
