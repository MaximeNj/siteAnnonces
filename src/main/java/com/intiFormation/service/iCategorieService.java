package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Categorie;

public interface iCategorieService {

	public Categorie ajouterCat(Categorie c);
	
	public Categorie selectCat (int idCat);
	public List<Categorie> selectAllCat();
	
	public Optional<Categorie> supprCat(int idCat);
	
}
