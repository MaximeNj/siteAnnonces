package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.iCategorieDao;
import com.intiFormation.entity.Categorie;

@Service
public class CategorieService implements iCategorieService {

	@Autowired
	iCategorieDao daoCat;
	
	public Categorie ajouterCat(Categorie c) {
		return daoCat.save(c);
	}
	
	public Categorie selectCat (int idCat) {
		
		
		return daoCat.findById(idCat).get();
	}
	
	public List<Categorie> selectAllCat() {
	
	List<Categorie> listeCats = daoCat.findAll();
	return listeCats;
	
}
	
	public Optional<Categorie> supprCat(int idCat) {
		Categorie cSupp = daoCat.findById(idCat).get();
		
		daoCat.delete(cSupp);
		return daoCat.findById(idCat);
	}

	public iCategorieDao getDaoCat() {
		return daoCat;
	}

	public void setDaoCat(iCategorieDao daoCat) {
		this.daoCat = daoCat;
	}
	
	
}