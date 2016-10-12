package banque.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("pret")
public class Pret extends Compte2 {
	private float taux;
	private int nbEcheances;
	
	public Pret(){
		super();
	}
	
	
	
	public Pret(String numCompte, boolean joint, long solde,float taux, int nbEcheances) {
		super(numCompte, joint, solde);
		this.taux = taux;
		this.nbEcheances = nbEcheances;
	}



	public Pret(float taux, int nbEcheances) {
		super();
		this.taux = taux;
		this.nbEcheances = nbEcheances;
	}



	public float getTaux() {
		return taux;
	}



	public void setTaux(float taux) {
		this.taux = taux;
	}



	public int getNbEcheances() {
		return nbEcheances;
	}



	public void setNbEcheances(int nbEcheances) {
		this.nbEcheances = nbEcheances;
	}
	
	
	
}
