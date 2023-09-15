package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IAnnonceDao;
import com.intiFormation.entity.Annonces;

@Service
public class AnnonceService implements IAnnonceService{
	@Autowired
	IAnnonceDao daoA;

	
	public Annonces ajouterAnnonce(Annonces a) {

	return	daoA.save(a);

	}

	public List<Annonces> afficherAllAnnonces() {
		List<Annonces> listeAnnonces = daoA.findAll();

		return listeAnnonces;

	}
	
	public Annonces selectAnnonceId(int idAnnonce) {
		
		Annonces a = daoA.findById(idAnnonce).get();
		
		return a;
		
	}
	
	public void supprAnnonces(int idAnnonce) {
		
		daoA.deleteById(idAnnonce);
	}

	public IAnnonceDao getDaoA() {
		return daoA;
	}

	public void setDaoA(IAnnonceDao daoA) {
		this.daoA = daoA;
	}
	
	
}
