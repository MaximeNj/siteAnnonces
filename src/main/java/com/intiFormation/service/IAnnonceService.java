package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Annonces;

public interface IAnnonceService{
	public Annonces ajouterAnnonce(Annonces a);
	public List<Annonces> afficherAllAnnonces();
	
	public Annonces selectAnnonceId(int idAnnonce);
	
	public void supprAnnonces(int idAnnonce);
}
