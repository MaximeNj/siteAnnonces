package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Utilisateurs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idUser;
private String nomUser;
private String prenomUser;
private String mailUser;

@OneToMany(mappedBy = "annonceUser")
private List<Annonces> listeAnnonces;

@OneToMany(mappedBy =  "commUser")
private List<Commentaire> listeComm;

@ManyToOne
@JoinColumn(name="idRoleUser")
private Role roleUser;

private String username;
private String password;

public int getIdUser() {
	return idUser;
}
public void setIdUser(int idUser) {
	this.idUser = idUser;
}
public String getNomUser() {
	return nomUser;
}
public void setNomUser(String nomUser) {
	this.nomUser = nomUser;
}
public String getPrenomUser() {
	return prenomUser;
}
public void setPrenomUser(String prenomUser) {
	this.prenomUser = prenomUser;
}
public String getMailUser() {
	return mailUser;
}
public void setMailUser(String mailUser) {
	this.mailUser = mailUser;
}
public List<Annonces> getListeAnnonces() {
	return listeAnnonces;
}
public void setListeAnnonces(List<Annonces> listeAnnonces) {
	this.listeAnnonces = listeAnnonces;
}
public List<Commentaire> getListeComm() {
	return listeComm;
}
public void setListeComm(List<Commentaire> listeComm) {
	this.listeComm = listeComm;
}
public Role getRoleUser() {
	return roleUser;
}
public void setRoleUser(Role roleUser) {
	this.roleUser = roleUser;
}

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Utilisateurs() {
	super();
	// TODO Auto-generated constructor stub
}




}
