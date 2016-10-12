package banque.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CompteCheque")
public class CompteCheque extends Compte {
	private float decouvert;

	public CompteCheque() {
		super();
	}

	public CompteCheque(String numCompte) {
		super(numCompte);
	}

	public float getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(float decouvert) {
		this.decouvert = decouvert;
	}

}
