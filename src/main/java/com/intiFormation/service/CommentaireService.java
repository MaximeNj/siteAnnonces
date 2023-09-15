package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.ICommentaireDao;
import com.intiFormation.dao.iCategorieDao;
import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Commentaire;

@Service
public class CommentaireService implements ICommentaireService{

	
	
	@Autowired
	ICommentaireDao daoCom;
	
	public void ajouterCom(Commentaire c) {
		daoCom.save(c);
	}
	
	public Commentaire selectCom (int idCom) {
		
		
		return daoCom.findById(idCom).get();
	}
	
	public List<Commentaire> selectAllCom() {
	
	List<Commentaire> listeComs = daoCom.findAll();
	return listeComs;
	
}
	
	public void supprCom(int idCom) {
		Commentaire comSupp = daoCom.findById(idCom).get();
		
		daoCom.delete(comSupp);
		
	}

	public ICommentaireDao getDaoCom() {
		return daoCom;
	}

	public void setDaoCom(ICommentaireDao daoCom) {
		this.daoCom = daoCom;
	}

	
	
}
