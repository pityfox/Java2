package vol.metier.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;



@Entity
@DiscriminatorValue("Physique")
//@Validated
public class ClientPhysique extends Client {

	private TitrePhysique titre;
	private String prenom;
	
	public ClientPhysique() {
		super();
	}

	@Column(name="Titre")
	@Enumerated(EnumType.STRING)
	//@NotNull(message="{client.titre.notNull}")
	public TitrePhysique getTitre() {
		return titre;
	}

	public void setTitre(TitrePhysique titre) {
		this.titre = titre;
	}

	@Column(name="Prenom", length=50)
	//@NotEmpty(message="{client.prenom.notNull}")
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}
