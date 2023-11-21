package org.eclipse.model;

import javax.persistence.*;

@Entity
public class Image {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int idImage;
	@Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private byte[] image;
	
	public Image() {
	}
	
	public Image(byte[] image) {
		this.image = image;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getIdImage() {
		return idImage;
	}

}
