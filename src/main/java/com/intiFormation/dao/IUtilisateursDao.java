package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.intiFormation.entity.Utilisateurs;

public interface IUtilisateursDao extends JpaRepository<Utilisateurs, Integer>{
	public Utilisateurs findByUsernameAndPassword(String username, String password);
	public Utilisateurs findByUsername(String username);
}
