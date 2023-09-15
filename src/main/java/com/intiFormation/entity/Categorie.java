package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idCat;
	
private String nomCat;

@OneToMany(mappedBy = "catAnnonce")

private List<Annonces> listeAnnonces;


public int getIdCat() {
	return idCat;
}
public void setIdCat(int idCat) {
	this.idCat = idCat;
}
public String getNomCat() {
	return nomCat;
}
public void setNomCat(String nomCat) {
	this.nomCat = nomCat;
}
public List<Annonces> getListeAnnonces() {
	return listeAnnonces;
}
public void setListeAnnonces(List<Annonces> listeAnnonces) {
	this.listeAnnonces = listeAnnonces;
}
public Categorie() {
	super();
	// TODO Auto-generated constructor stub
}

}
