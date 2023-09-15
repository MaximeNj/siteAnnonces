package com.intiFormation.entity;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Annonces {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idAnnonce;
private String titreAnnonce;
private String descriAnnonce;
private String photoAnnonce;
@Temporal(TemporalType.DATE)
private Date datePubli;
@Temporal(TemporalType.DATE)
private Date dateExp;
private boolean statut;

@ManyToOne
@JoinColumn(name ="idAnnonceCat")
@JsonIgnore
private Categorie catAnnonce;

@OneToMany(mappedBy = "commAnnonce",fetch = FetchType.EAGER)

private List<Commentaire> listeComm;

@ManyToOne
@JoinColumn(name="idUserAnnonce")
@JsonIgnore
private Utilisateurs annonceUser;
public int getIdAnnonce() {
	return idAnnonce;
}
public void setIdAnnonce(int idAnnonce) {
	this.idAnnonce = idAnnonce;
}
public String getTitreAnnonce() {
	return titreAnnonce;
}
public void setTitreAnnonce(String titreAnnonce) {
	this.titreAnnonce = titreAnnonce;
}
public String getDescriAnnonce() {
	return descriAnnonce;
}
public void setDescriAnnonce(String descriAnnonce) {
	this.descriAnnonce = descriAnnonce;
}



public String getPhotoAnnonce() {
	return photoAnnonce;
}
public void setPhotoAnnonce(String photoAnnonce) {
	this.photoAnnonce = photoAnnonce;
}
public Date getDatePubli() {
	return datePubli;
}
public void setDatePubli(Date datePubli) {
	this.datePubli = datePubli;
}
public Date getDateExp() {
	return dateExp;
}
public void setDateExp(Date dateExp) {
	this.dateExp = dateExp;
}
public boolean isStatut() {
	return statut;
}
public void setStatut(boolean statut) {
	this.statut = statut;
}
public Categorie getCatAnnonce() {
	return catAnnonce;
}
public void setCatAnnonce(Categorie catAnnonce) {
	this.catAnnonce = catAnnonce;
}
public List<Commentaire> getListeComm() {
	return listeComm;
}
public void setListeComm(List<Commentaire> listeComm) {
	this.listeComm = listeComm;
}
public Utilisateurs getAnnonceUser() {
	return annonceUser;
}
public void setAnnonceUser(Utilisateurs annonceUser) {
	this.annonceUser = annonceUser;
}

public Annonces(int idAnnonce, String titreAnnonce, String descriAnnonce, String photoAnnonce, Date datePubli,
		Date dateExp, boolean statut, Categorie catAnnonce, List<Commentaire> listeComm, Utilisateurs annonceUser) {
	super();
	this.idAnnonce = idAnnonce;
	this.titreAnnonce = titreAnnonce;
	this.descriAnnonce = descriAnnonce;
	this.photoAnnonce = photoAnnonce;
	this.datePubli = datePubli;
	this.dateExp = dateExp;
	this.statut = statut;
	this.catAnnonce = catAnnonce;
	this.listeComm = listeComm;
	this.annonceUser = annonceUser;
}
public Annonces() {
	super();
	// TODO Auto-generated constructor stub
}



}
