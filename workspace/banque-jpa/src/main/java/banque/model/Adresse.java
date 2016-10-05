package banque.model;

import javax.persistence.*;

@Embeddable
public class Adresse {
	// ---------- Attributs ----------
	private String rue;
	private String codePostal;
	private String ville;
	
	// ---------- Constructeurs ----------
	public Adresse() {
		
	}
	
	
	public Adresse(String rue, String ville, String codePostal) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}


	// ---------- Getters & Setters ----------
	@Column(length = 100)
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	
	@Column(length = 50)
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	@Column(length = 100)
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	

	
}
