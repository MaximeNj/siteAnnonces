package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.intiFormation.entity.Annonces;

public interface IAnnonceDao extends JpaRepository<Annonces, Integer> {

	
	
}
