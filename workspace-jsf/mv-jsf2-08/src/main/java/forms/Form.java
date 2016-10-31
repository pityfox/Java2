package forms;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Form {

  // modèle
  private List<Personne> personnes;
  private int personneId;

  // constructeur
  public Form() {
    // initialisation de la liste des personnes
    personnes = new ArrayList<Personne>();
    personnes.add(new Personne(1, "dupont", "jacques"));
    personnes.add(new Personne(2, "durand", "élise"));
    personnes.add(new Personne(3, "martin", "jacqueline"));
  }

  public String retirerPersonne() {
    // on recherche la personne sélectionnée
    int i = 0;
    for (Personne personne : personnes) {
      // personne courante = personne sélectionnée ?
      if (personne.getId() == personneId) {
        // on supprime la personne courante de la liste
        personnes.remove(i);
        // on a fini
        break;
      } else {
        // personne suivante
        i++;
      }
    }
    // on teste sur la même page
    return null;
  }
  
  // getters et setters

  public int getPersonneId() {
    return personneId;
  }

  public void setPersonneId(int personneId) {
    this.personneId = personneId;
  }

  public List<Personne> getPersonnes() {
    return personnes;
  }

  public void setPersonnes(List<Personne> personnes) {
    this.personnes = personnes;
  }
  
}