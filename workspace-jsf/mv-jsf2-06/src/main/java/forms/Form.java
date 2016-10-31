package forms;

import com.corejsf.util.Messages;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
@RequestScoped
public class Form {

  public Form() {
  }
  // saisies
  private Integer saisie1 = 0;
  private Integer saisie2 = 0;
  private Integer saisie3 = 0;
  private Integer saisie4 = 0;
  private Double saisie5 = 0.0;
  private Double saisie6 = 0.0;
  private Boolean saisie7 = true;
  private Date saisie8 = new Date();
  private String saisie9 = "";
  private String saisie9B;
  private Integer saisie10 = 0;
  private Integer saisie11 = 0;
  private Integer saisie12 = 0;
  private String errorSaisie11 = "";
  private String errorSaisie12 = "";

  // actions
  public String submit() {
    // derni�res validations
    validateForm();
    // on renvoie le m�me formulaire
    return null;
  }

  public String cancel() {
    saisie1 = 0;
    saisie2 = 0;
    saisie3 = 0;
    saisie4 = 0;
    saisie5 = 0.0;
    saisie6 = 0.0;
    saisie7 = true;
    saisie8 = new Date();
    saisie9 = "";
    saisie10 = 0;
    return null;
  }

  // validateurs
  public void validateSaisie10(FacesContext context, UIComponent component, Object value) {
    int saisie = (Integer) value;
    if (!(saisie < 1 || saisie > 7)) {
      FacesMessage message = Messages.getMessage(null, "saisie10.incorrecte", null);
      message.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ValidatorException(message);
    }
  }

  // validations globales
  private void validateForm() {
    if ((saisie11 + saisie12) != 10) {
      // msg global
      FacesMessage message = Messages.getMessage(null, "saisies11et12.incorrectes", null);
      message.setSeverity(FacesMessage.SEVERITY_ERROR);
      FacesContext context = FacesContext.getCurrentInstance();
      context.addMessage(null, message);
      // msg li�s aux champs
      message = Messages.getMessage(null, "error.sign", null);
      setErrorSaisie11(message.getSummary());
      setErrorSaisie12(message.getSummary());
    } else {
      setErrorSaisie11("");
      setErrorSaisie12("");
    }
  }

  // getters et setters
  public int getSaisie1() {
    return saisie1;
  }

  public void setSaisie1(int saisie1) {
    this.saisie1 = saisie1;
  }

  public int getSaisie2() {
    return saisie2;
  }

  public void setSaisie2(int saisie2) {
    this.saisie2 = saisie2;
  }

  public int getSaisie3() {
    return saisie3;
  }

  public void setSaisie3(int saisie3) {
    this.saisie3 = saisie3;
  }

  public int getSaisie4() {
    return saisie4;
  }

  public void setSaisie4(int saisie4) {
    this.saisie4 = saisie4;
  }

  public double getSaisie5() {
    return saisie5;
  }

  public void setSaisie5(double saisie5) {
    this.saisie5 = saisie5;
  }

  public double getSaisie6() {
    return saisie6;
  }

  public void setSaisie6(double saisie6) {
    this.saisie6 = saisie6;
  }

  public boolean isSaisie7() {
    return saisie7;
  }

  public void setSaisie7(boolean saisie7) {
    this.saisie7 = saisie7;
  }

  public Date getSaisie8() {
    return saisie8;
  }

  public void setSaisie8(Date saisie8) {
    this.saisie8 = saisie8;
  }

  public String getSaisie9() {
    return saisie9;
  }

  public void setSaisie9(String saisie9) {
    this.saisie9 = saisie9;
  }

  public Integer getSaisie10() {
    return saisie10;
  }

  public void setSaisie10(Integer saisie10) {
    this.saisie10 = saisie10;
  }

  public Integer getSaisie11() {
    return saisie11;
  }

  public void setSaisie11(Integer saisie11) {
    this.saisie11 = saisie11;
  }

  public Integer getSaisie12() {
    return saisie12;
  }

  public void setSaisie12(Integer saisie12) {
    this.saisie12 = saisie12;
  }

  public String getErrorSaisie11() {
    return errorSaisie11;
  }

  public void setErrorSaisie11(String errorSaisie11) {
    this.errorSaisie11 = errorSaisie11;
  }

  public String getErrorSaisie12() {
    return errorSaisie12;
  }

  public void setErrorSaisie12(String errorSaisie12) {
    this.errorSaisie12 = errorSaisie12;
  }

  public String getSaisie9B() {
    return saisie9B;
  }

  public void setSaisie9B(String saisie9B) {
    this.saisie9B = saisie9B;
  }
}