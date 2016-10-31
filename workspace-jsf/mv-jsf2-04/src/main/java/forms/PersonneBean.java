package forms;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import model.TITRES;

@ManagedBean
@RequestScoped
public class PersonneBean {
	private Long id=12L;
	private TITRES titre;
	private String nom;
	private String prenom;
	private Integer age;
	private boolean marie;
	private String statut;
	
	public PersonneBean(){
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TITRES getTitre() {
		return titre;
	}
	public void setTitre(TITRES titre) {
		this.titre = titre;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public boolean isMarie() {
		return marie;
	}
	public void setMarie(boolean marie) {
		this.marie = marie;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	// Getters pour passer les listes de checkbox truc machin
	public TITRES[] getTitres(){
		return TITRES.values();
	}
	
	
}
