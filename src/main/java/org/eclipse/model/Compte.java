package org.eclipse.model;

import javax.persistence.*;

@Entity
public class Compte {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCompte;
	private String login;
	private String pwd;
	private String type;
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;
	
	
	public Compte(String login, String pwd, User user) {
		super();
		this.login = login;
		this.pwd = pwd;
		this.type = "a";
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Compte() {
		
	}

	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
