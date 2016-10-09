package banque.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Epargne")
public class Epargne extends Compte {
	private float interet;

	public Epargne() {
		super();
	}

	public Epargne(String numCompte) {
		super(numCompte);
	}

	public float getInteret() {
		return interet;
	}

	public void setInteret(float interet) {
		this.interet = interet;
	}

}
