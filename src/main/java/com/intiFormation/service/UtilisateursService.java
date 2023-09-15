package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IUtilisateursDao;
import com.intiFormation.entity.Categorie;

import com.intiFormation.entity.Utilisateurs;

@Service
public class UtilisateursService implements IUtilisateursService {
@Autowired
	IUtilisateursDao daoU;
	
	public void ajouterUser(Utilisateurs u) {
		daoU.save(u);
	}
	
	public Utilisateurs selectUser (int idUser) {
		
		
		return daoU.findById(idUser).get();
	}
	
	public List<Utilisateurs> selectAllUser() {
	
	List<Utilisateurs> listeUsers = daoU.findAll();
	return listeUsers;
	
}
	
	public void supprUser(int idUser) {
		Utilisateurs uSupp = daoU.findById(idUser).get();
		
		daoU.delete(uSupp);
		
	}
	public Utilisateurs userAuth(String username, String password) {
		Utilisateurs u = daoU.findByUsernameAndPassword(username , password);
		
		return u;
	}
	public Utilisateurs findByUsername(String username) {
		Utilisateurs u = daoU.findByUsername(username);
		return u;
	}

	public IUtilisateursDao getDaoU() {
		return daoU;
	}

	public void setDaoU(IUtilisateursDao daoU) {
		this.daoU = daoU;
	}
	
	
}
