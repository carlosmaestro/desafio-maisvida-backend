package com.chmmaestro.maisvidabackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.chmmaestro.maisvidabackend.domain.User;
import com.chmmaestro.maisvidabackend.dto.UserDTO;
import com.chmmaestro.maisvidabackend.exception.ObjectNotFounException;
import com.chmmaestro.maisvidabackend.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired BCryptPasswordEncoder bcrypt;

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFounException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		obj.setSenha(bcrypt.encode(obj.getSenha()));
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(User newObj, User obj) {

		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		newObj.setAtivo(obj.getAtivo());
		newObj.setSenha(bcrypt.encode(obj.getSenha()));
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail(), null ,objDTO.getAtivo());
	}

}
