package com.chmmaestro.maisvidabackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chmmaestro.maisvidabackend.domain.Especialidade;
import com.chmmaestro.maisvidabackend.exception.ObjectNotFounException;
import com.chmmaestro.maisvidabackend.repository.EspecialidadeRepository;

@Service
public class EspecialidadeService {

	@Autowired
	private EspecialidadeRepository repo;

	public List<Especialidade> findAll() {
		return repo.findAll();
	}

	public Especialidade findById(String id) {
		Optional<Especialidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFounException("Objeto não encontrado"));
	}

	public Especialidade insert(Especialidade obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public Especialidade update(Especialidade obj) {
		Especialidade newObj = findById(obj.getId());
		newObj.setName(obj.getName());
		return repo.save(newObj);
	}

}
