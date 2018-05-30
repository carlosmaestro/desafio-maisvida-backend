package com.chmmaestro.maisvidabackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chmmaestro.maisvidabackend.domain.Status;
import com.chmmaestro.maisvidabackend.exception.ObjectNotFounException;
import com.chmmaestro.maisvidabackend.repository.StatusRepository;

@Service
public class StatusService {

	@Autowired
	private StatusRepository repo;

	public List<Status> findAll() {
		return repo.findAll();
	}

	public Status findById(String id) {
		Optional<Status> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFounException("Objeto não encontrado"));
	}

	public Status insert(Status obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public Status update(Status obj) {
		Status newObj = findById(obj.getId());
		newObj.setName(obj.getName());
		return repo.save(newObj);
	}

}
