package com.intiFormation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Annonces;
import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Commentaire;
import com.intiFormation.service.IAnnonceService;
import com.intiFormation.service.ICommentaireService;
import com.intiFormation.service.iCategorieService;

@RestController
@CrossOrigin("http://localhost:4200")
public class CommentaireController {
@Autowired 
ICommentaireService service;
@Autowired
IAnnonceService serviceAnnonce;
@Autowired
iCategorieService cateService;

@GetMapping("/comm/{idAnnonce}")
public List<Commentaire> afficherCommentaires(@PathVariable("idAnnonce") Integer idAnnonce) {
	
	
	Annonces a = serviceAnnonce.selectAnnonceId(idAnnonce);
	/*
	
	Commentaire c = new Commentaire();
	
	*/
	
	
	List<Commentaire> listeComm = a.getListeComm();
	
	
	
	
//	c.getCommAnnonce();
	
	/*List<Categorie> categories = cateService.selectAllCat();

	modelCom.addAttribute("categories", categories);*/
	
	return listeComm;
}

@PostMapping("/comm/{idAnnonce}")
public void saveCommentaire (@PathVariable("idAnnonce") int idAnnonce, @RequestBody Commentaire commentaire) {
	//modelCom.getAttribute("idAnnonce", idAnnonce);
	
	Annonces a = serviceAnnonce.selectAnnonceId(idAnnonce);
	commentaire.setCommAnnonce(a);
	service.ajouterCom(commentaire);
			
	
}




@DeleteMapping("/SupprComm")
public void SupprimerCommentaire(@PathVariable("idComm") int idComm) {
	
	//service.selectCom(idSuppCom);
	service.supprCom(idComm);
	
	
}
@PostMapping("/ModifComm")
public void ModifierCommentaire (@RequestBody Commentaire commentaire) {
	
	Commentaire c = service.selectCom(commentaire.getIdCommentaire());

service.ajouterCom(c);
	
	
}
	
}
