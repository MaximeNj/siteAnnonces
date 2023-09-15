package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idRole;
	
private String nomRole;

@OneToMany(mappedBy = "roleUser")
private List<Utilisateurs> listeUser;
public int getIdRole() {
	return idRole;
}
public void setIdRole(int idRole) {
	this.idRole = idRole;
}
public String getNomRole() {
	return nomRole;
}
public void setNomRole(String nomRole) {
	this.nomRole = nomRole;
}
public List<Utilisateurs> getListeUser() {
	return listeUser;
}
public void setListeUser(List<Utilisateurs> listeUser) {
	this.listeUser = listeUser;
}
public Role() {
	super();
	// TODO Auto-generated constructor stub
}



}
