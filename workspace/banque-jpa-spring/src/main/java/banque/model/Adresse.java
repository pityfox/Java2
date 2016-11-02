package banque.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Embeddable
public class Adresse {
	private String rue;
	private String codePostal;
	private String ville;

	public Adresse() {
		super();
	}

	public Adresse(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	@Column(length=50)
	@Size(min=1, message="Rue obligatoire")
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	@Column(length=10)
	@Pattern(regexp="^\\d{5}$", message="Le code postal doit comporter 5 chiffres")
	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Column(length=50)
	@Size(min=1, message="Ville obligatoire")
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
