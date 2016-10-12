package banque.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("epargne")
public class Epargne extends Compte2{
	private float interet;
	
	public Epargne(){
		super();
	}

	public Epargne(String numCompte, boolean joint, long solde, float interet) {
		super(numCompte, joint, solde);
		this.interet = interet;
	}

	public float getInteret() {
		return interet;
	}

	public void setInteret(float interet) {
		this.interet = interet;
	}
	
	
	
}
