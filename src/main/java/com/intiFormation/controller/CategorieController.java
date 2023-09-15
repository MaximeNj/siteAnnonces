package com.intiFormation.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Categorie;
import com.intiFormation.service.iCategorieService;

@RestController
@CrossOrigin("http://localhost:4200")
public class CategorieController {

	@Autowired
	iCategorieService service;
	
	
	@GetMapping("/public/categorieapi") // affichage de toutes les categories
	public List<Categorie> afficherCats() {

		List<Categorie> categories = service.selectAllCat();

	
		return categories;
		// qund la page jsp sera afficherPersonnes (ràv avec le request mapping)

	}
	@PostMapping("/ad/categorieapi")
	public Categorie saveCat(@RequestBody Categorie categorie) { // Car nécessite obj dans body requête pour transm en JSON
		
		
		return service.ajouterCat(categorie);
	}
	
	@DeleteMapping("categorieapi/{idCat}")
	public String supprimerCat(@PathVariable("idCat") Integer idCat) {
		
	service.supprCat(idCat);
	return "La catégorie est supprimée";
	}
	
	
	@PutMapping("categorieapi")
	public Categorie modifierCat(@RequestBody Categorie categorie) {
		Categorie c = service.selectCat(categorie.getIdCat());


	
		return service.ajouterCat(c);
		
		
	}
	@GetMapping("categorieapi/{idCat}")
	public Categorie trouverCatId(@PathVariable Integer idCat) {
		Categorie c = service.selectCat(idCat); 
		
		
		return c;
		
		
		
	}
}
