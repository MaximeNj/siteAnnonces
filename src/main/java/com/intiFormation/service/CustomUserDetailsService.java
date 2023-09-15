package com.intiFormation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.intiFormation.entity.Role;
import com.intiFormation.entity.Utilisateurs;

@Service
public class CustomUserDetailsService implements UserDetailsService{
@Autowired
	UtilisateursService service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Utilisateurs u =		service.findByUsername(username);
		if (u == null)
			{throw new UsernameNotFoundException(username);}
		
		List<GrantedAuthority> authorities=getGrantedAuthority(u);
		
		return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(),authorities);
}

	private List<GrantedAuthority> getGrantedAuthority(Utilisateurs u) {
		
		List<GrantedAuthority> liste= new ArrayList<>();
		
		Role role = u.getRoleUser();
		
			liste.add(new SimpleGrantedAuthority(role.getNomRole()));
		
		
		return liste;
		
	}
	

}
