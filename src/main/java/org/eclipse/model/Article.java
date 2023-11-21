package org.eclipse.model;

import javax.persistence.*;

@Entity
public class Article {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idArticle;
	private String designation;
	private int pu;
	private int qty;
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private Categorie cat;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idImage")
    private Image image;

	public Article(String designation, int pu, int qty, Categorie cat, Image image) {
		super();
		this.designation = designation;
		this.pu = pu;
		this.qty = qty;
		this.cat = cat;
		this.image = image;
	}
	
	
	
	public Article() {
		
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public int getPu() {
		return pu;
	}



	public void setPu(int pu) {
		this.pu = pu;
	}



	public int getQty() {
		return qty;
	}



	public void setQty(int qty) {
		this.qty = qty;
	}



	public Categorie getCat() {
		return cat;
	}



	public void setCat(Categorie cat) {
		this.cat = cat;
	}



	public Image getImage() {
		return image;
	}



	public void setImage(Image image) {
		this.image = image;
	}



	public int getIdArticle() {
		return idArticle;
	}
	
	
}
