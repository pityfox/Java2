package banque.model;

import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("compteCheque")
public class CompteCheque extends Compte2{
	private float decouvert;
	
	

	public CompteCheque() {
		super();
	}

	public CompteCheque(String numCompte, boolean joint, long solde, float decouvert) {
		super(numCompte, joint, solde);
		this.decouvert = decouvert;
	}

	public float getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(float decouvert) {
		this.decouvert = decouvert;
	}
	
	
}
