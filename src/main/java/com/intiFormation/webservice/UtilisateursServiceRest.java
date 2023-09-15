package com.intiFormation.webservice;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import com.intiFormation.entity.Utilisateurs;
import com.intiFormation.service.IUtilisateursService;
@Component
@Path("Utilisateurs")
public class UtilisateursServiceRest {

	/*
	 * Déclaration de la couche service pour interagir avec la BDD
	 */
	
	private IUtilisateursService utilisateursService;
	/*
	 * Setter de la couche service pour injection Spring
	 */

	public void setEmployeService(IUtilisateursService utilisateursService) {
		this.utilisateursService = utilisateursService;
	}
	
	/*-------------------------------------------------------------------------------------------------------------------------- */
	/*-----------------------------------------------Methode du ws rest--------------------------------------------------------- */
	/*-------------------------------------------------------------------------------------------------------------------------- */
	
	 /*
	  * Méthode qui expose la liste des employés dans le web service 
	  * Url de la requête : http://localhost:8080/01_Spring_RestFull/rest/employes/all
	  */
	@Path("all")
	@GET
	@Produces("application/json") // produit un document en json 
	public ArrayList<Utilisateurs> getAllUtilisateurs (){
		System.out.println("getAll");
		return  (ArrayList<Utilisateurs>)utilisateursService.selectAllUser();
	}
}
