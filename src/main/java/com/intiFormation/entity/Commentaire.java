package com.intiFormation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Commentaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idCommentaire;
private String contenuCommentaire;


@ManyToOne
@JoinColumn(name="idUserComm")
private Utilisateurs commUser;

@ManyToOne
@JoinColumn(name ="idCommAnnonce")
@JsonIgnore
private Annonces commAnnonce;
public int getIdCommentaire() {
	return idCommentaire;
}
public void setIdCommentaire(int idCommentaire) {
	this.idCommentaire = idCommentaire;
}
public String getContenuCommentaire() {
	return contenuCommentaire;
}
public void setContenuCommentaire(String contenuCommentaire) {
	this.contenuCommentaire = contenuCommentaire;
}
public Utilisateurs getCommUser() {
	return commUser;
}
public void setCommUser(Utilisateurs commUser) {
	this.commUser = commUser;
}
public Annonces getCommAnnonce() {
	return commAnnonce;
}
public void setCommAnnonce(Annonces commAnnonce) {
	this.commAnnonce = commAnnonce;
}
public Commentaire() {
	super();
	// TODO Auto-generated constructor stub
}



}
