package com.intiFormation.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intiFormation.entity.Annonces;
import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Commentaire;
import com.intiFormation.entity.Utilisateurs;
import com.intiFormation.service.AnnonceService;
import com.intiFormation.service.IAnnonceService;
import com.intiFormation.service.IUtilisateursService;
import com.intiFormation.service.iCategorieService;

@RestController
@CrossOrigin("http://localhost:4200")
public class AnnoncesController {
	@Autowired
	IAnnonceService service;

	@Autowired
	iCategorieService cateService;

	@Autowired
	IUtilisateursService userService;
	
	@GetMapping("/public/Accueil")
	public List<Annonces> afficherAnnonces() {
		List<Annonces> listeAnnonces = service.afficherAllAnnonces();
		
		

		//List<Categorie> categories = cateService.selectAllCat();

	

		return listeAnnonces;

	}
	
	@GetMapping("/categorie/annonce/{id}")
	public Categorie getCatByIdAnnonce(@PathVariable("id") int id)
	{
		Annonces a=service.selectAnnonceId(id);
		Categorie c=a.getCatAnnonce();
		return c;
	}
	
	@GetMapping("/public/annonceapi/{idAnnonce}")
	public Annonces afficherAnnonceParId (@PathVariable Integer idAnnonce) {
		
		
		
		return service.selectAnnonceId(idAnnonce);
	}

	@PostMapping("/public/annonce")
	public void ajouterAnnonce(@RequestParam("titreAnnonce") String titreAnnonce, @RequestParam("descriAnnonce") String descriAnnonce, 
			@RequestParam("datePubli")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date datePubli, 
			@RequestParam("dateExp")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateExp,
			@RequestParam("catAnnonce") int idCat,
			@RequestParam("annonceUser") int idUser, @RequestParam("fichier") MultipartFile file, HttpSession session) {
		String path=session.getServletContext().getRealPath("/");  
		
		String filename= file.getOriginalFilename();
		//System.out.println(filename);
		//System.out.println(p.getNom());
		//System.out.println(p.getPrenom());
		//p.setPhoto("/dossierimage/"+filename);
		

		try{  
	        byte barr[]=file.getBytes();  
	          
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream(path+"/dossierimage/"+filename));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();  
	         
	        }catch(Exception e){System.out.println(e);} 
		
		
		 Annonces annonce=new Annonces();
		 //recherche de la catégorie et attrib objet à injecter
		Categorie cat= cateService.selectCat(idCat);
		// recherche du user et attrib objet à injecter
		Utilisateurs user= userService.selectUser(idUser);
		 
		 // Inj des attributs
		 annonce.setTitreAnnonce(titreAnnonce);
		 annonce.setDescriAnnonce(descriAnnonce);
		 annonce.setDatePubli(datePubli);
		 annonce.setDateExp(dateExp);
		 annonce.setPhotoAnnonce(filename);
		 annonce.setAnnonceUser(user);
		 annonce.setCatAnnonce(cat);
		 
		 
		 service.ajouterAnnonce(annonce);
				 

	
	}

	@DeleteMapping("/public/{idAnnonce}")
	public String supprAnnonce(@PathVariable("idAnnonce") Integer idAnnonce) {

		service.supprAnnonces(idAnnonce);
		return "Annonce supprimée";
	}

	@PutMapping("/public/{idAnnnonce}")
	public Annonces modifierAnnonces(@PathVariable("idAnnonce") Integer idAnnonce ) {

		Annonces a = service.selectAnnonceId(idAnnonce);
		

		

		return service.ajouterAnnonce(a);

	}

}
