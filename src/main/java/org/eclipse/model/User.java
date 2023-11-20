package org.eclipse.model;

import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;
	private String prenom;
	private String nom;
	private String numRue;
	private String nomRue;
	private String cp;
	private String ville;
	private String tel;
	
	
	
	
	public String getPrenom() {
		return prenom;
	}




	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getNumRue() {
		return numRue;
	}




	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}




	public String getNomRue() {
		return nomRue;
	}




	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}




	public String getCp() {
		return cp;
	}




	public void setCp(String cp) {
		this.cp = cp;
	}




	public String getVille() {
		return ville;
	}




	public void setVille(String ville) {
		this.ville = ville;
	}




	public String getTel() {
		return tel;
	}




	public void setTel(String tel) {
		this.tel = tel;
	}




	public int getIdUser() {
		return idUser;
	}




	public User(String prenom, String nom, String numRue, String nomRue, String cp, String ville, String tel) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.cp = cp;
		this.ville = ville;
		this.tel = tel;
	}




	public User() {
		
	}
}
