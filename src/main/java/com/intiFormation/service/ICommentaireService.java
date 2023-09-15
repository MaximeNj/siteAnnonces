package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Commentaire;

public interface ICommentaireService {

	
	public void ajouterCom(Commentaire c);
	
	public Commentaire selectCom (int idCom);
	
	public List<Commentaire> selectAllCom();
	
	public void supprCom(int idCom) ;
	
}
