package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Utilisateurs;

public interface IUtilisateursService {
	public void ajouterUser(Utilisateurs u);
	
	public Utilisateurs selectUser (int idUser);
	
	public List<Utilisateurs> selectAllUser();
	
	public void supprUser(int idUser);
	public Utilisateurs userAuth(String login, String password);
	public Utilisateurs findByUsername(String username);
}
