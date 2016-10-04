package banque.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@IdClass(AgenceId.class)
public class Agence {
	private AgenceId id;
//	private Integer numBanque;
//	private Integer numAgence;
	private String libelle;
	private String horaires;

	public Agence(Integer numBanque, Integer numAgence){
		this.id = new AgenceId(numBanque, numAgence);
	}
	
	public Agence() {
		super();
	}

	//@Id //pour le IdClass
//	public Integer getNumBanque() {
//		return numBanque;
//	}
//
//	public void setNumBanque(Integer numBanque) {
//		this.numBanque = numBanque;
//	}

	//@Id // pour le IdClass
//	public Integer getNumAgence() {
//		return numAgence;
//	}
//
//	public void setNumAgence(Integer numAgence) {
//		this.numAgence = numAgence;
//	}


	public String getLibelle() {
		return libelle;
	}
	
	@EmbeddedId // Pour l embedded
	public AgenceId getId() {
		return id;
	}

	public void setId(AgenceId id) {
		this.id = id;
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

}
