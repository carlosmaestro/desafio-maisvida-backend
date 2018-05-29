package com.chmmaestro.maisvidabackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chmmaestro.maisvidabackend.domain.User;
import com.chmmaestro.maisvidabackend.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	 
	public List<User> findAll(){
		return repo.findAll();
	}
	
	
}
