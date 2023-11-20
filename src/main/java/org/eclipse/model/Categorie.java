package org.eclipse.model;

import javax.persistence.*;

@Entity
public class Categorie {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int idCat;
	private String designation;
	
	public Categorie(String designation) {
		super();
		this.designation = designation;
	}
	
	public Categorie() {
		
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getIdCat() {
		return idCat;
	}
	
	
}
