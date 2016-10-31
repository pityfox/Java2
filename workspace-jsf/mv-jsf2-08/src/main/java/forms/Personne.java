/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

/**
 *
 * @author Serge Tahé
 */
public class Personne {
  // data
  private int id;
  private String nom;
  private String prénom;
  
  // constructeurs
  public Personne(){
    
  }
  
  public Personne(int id, String nom, String prénom){
    this.id=id;
    this.nom=nom;
    this.prénom=prénom;
  }
  
  // toString
  public String toString(){
    return String.format("Personne[%d,%s,%s]", id,nom,prénom);
  }
  
  // getter et setters

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrénom() {
    return prénom;
  }

  public void setPrénom(String prénom) {
    this.prénom = prénom;
  }
  
}
