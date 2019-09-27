package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AppUserRepository;
import com.example.demo.model.User;

@Component
@Service
public class UserService implements UserDetailsService{
	@Autowired
	private AppUserRepository repository;

	public UserService(AppUserRepository repository) {
		this.repository=repository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final Iterable<User> users = repository.getAll();


		for (User appUser : users) {
			if (appUser.getUsername().equals(username)) {
				List<GrantedAuthority> grantedAuthorities = AuthorityUtils
						.commaSeparatedStringToAuthorityList("ROLE_" + appUser.getRoles());
				
				System.out.println("ROLE=========================="+appUser.getRoles()
				+"\n"+grantedAuthorities);
				return new org.springframework.security.core.userdetails.User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
			}
		}
		throw new UsernameNotFoundException("Username: " + username + " not found");  
	}

}
