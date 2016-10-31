package forms;

import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

@ManagedBean
@RequestScoped
public class Form {
  
  public Form() {
  }
  
// champs du formulaire
  private String combo1="A";
  private String combo2="A1";
  private Integer saisie1=0;
  
  // champs de travail
  final private String[] combo1Labels={"A","B","C"};
  private String combo1Label="A";
  private static final Logger logger=Logger.getLogger("forms.Form");
  
  // méthodes
  public SelectItem[] getCombo1Items(){
    // init combo1
    SelectItem[] combo1Items=new SelectItem[combo1Labels.length];
    for(int i=0;i<combo1Labels.length;i++){
      combo1Items[i]=new SelectItem(combo1Labels[i],combo1Labels[i]);
    }
    return combo1Items;
  }
  
  public SelectItem[] getCombo2Items(){
    // init combo2 en fonction de combo1
    SelectItem[] combo2Items=new SelectItem[5];
    for(int i=1;i<=combo2Items.length;i++){
      combo2Items[i-1]=new SelectItem(combo1Label+i,combo1Label+i);
    }
    return combo2Items;
  }
  
  // listeners
  public void combo1ChangeListener(ValueChangeEvent event){
    // suivi
    logger.info("combo1ChangeListener");
    // on récupère la valeur postée de combo1
    combo1Label=(String)event.getNewValue();
    // on rend la réponse car on veut court-circuiter les validations
    FacesContext.getCurrentInstance().renderResponse();
  }
  
  public String raz(){
    // suivi
    logger.info("raz");
    // raz du formulaire
    combo1Label="A";
    combo1="A";
    combo2="A1";
    saisie1=0;
    return null;
  }
  
// getters - setters
  
  public String getCombo1() {
    return combo1;
  }
  
  public void setCombo1(String combo1) {
    this.combo1 = combo1;
  }
  
  public String getCombo2() {
    return combo2;
  }
  
  public void setCombo2(String combo2) {
    this.combo2 = combo2;
  }
  
  public Integer getSaisie1() {
    return saisie1;
  }
  
  public void setSaisie1(Integer saisie1) {
    this.saisie1 = saisie1;
  }
  
}