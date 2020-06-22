package net.dynu.dovecot.comidasemana.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comida {
	@Id
	private Integer id;
	private String name;
	private String image;
	private String url;
	private String note;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
