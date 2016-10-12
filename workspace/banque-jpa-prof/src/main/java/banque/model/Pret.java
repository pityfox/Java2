package banque.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Pret")
public class Pret extends Compte {
	private float taux;
	private Integer nbEcheances;

	public Pret() {
		super();
	}

	public Pret(String numCompte) {
		super(numCompte);
	}

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}

	public Integer getNbEcheances() {
		return nbEcheances;
	}

	public void setNbEcheances(Integer nbEcheances) {
		this.nbEcheances = nbEcheances;
	}

}
