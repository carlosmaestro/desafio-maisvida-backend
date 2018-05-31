package com.chmmaestro.maisvidabackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chmmaestro.maisvidabackend.domain.User;
import com.chmmaestro.maisvidabackend.repository.UserRepository;
import com.chmmaestro.maisvidabackend.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		 User obj = userRepo.findByEmailContaining(email);
			if (obj == null) {
				throw new UsernameNotFoundException(email);
			}
			return new UserSS(obj.getId(), obj.getEmail(), obj.getSenha(), obj.getPerfis());
	}	

}
