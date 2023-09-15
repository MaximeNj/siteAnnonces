package com.intiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Utilisateurs;
import com.intiFormation.service.IUtilisateursService;

@RestController
@RequestMapping("/Utilisateurs")
@CrossOrigin("http://localhost:4200")
public class UtilisateursController {
@Autowired
IUtilisateursService service;


@GetMapping("/login")
public List<Utilisateurs> afficherPageCo () {
	
	
	return service.selectAllUser();
	
	
}
@PostMapping("/signin")
public void ajouterUser(@RequestBody Utilisateurs u) {
	
	service.ajouterUser(u);
	
	
}

@DeleteMapping("/ad/suppUser/{idUser}")
public void suppUser(@PathVariable int idUser ) {
	
	service.supprUser(idUser);
}

@PostMapping("/modUser")
public void modifierUser(@RequestBody Utilisateurs u) {
	
	service.ajouterUser(u);
	
	
}

/*

@RequestMapping("/UserAuth")
public String UserLogin (@RequestParam("login") String login , @RequestParam("password") String password) {


Utilisateurs u= service.userAuth(login, password);
if(u==null)
{
	return "redirect:/pageConnexion";
}
else
{
	return "redirect:/afficherAnnonces";
}



}*/
}