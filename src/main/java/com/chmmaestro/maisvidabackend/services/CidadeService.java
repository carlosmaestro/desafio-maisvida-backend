package com.chmmaestro.maisvidabackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chmmaestro.maisvidabackend.domain.Cidade;
import com.chmmaestro.maisvidabackend.domain.Estado;
import com.chmmaestro.maisvidabackend.dto.CidadeDTO;
import com.chmmaestro.maisvidabackend.exception.ObjectNotFounException;
import com.chmmaestro.maisvidabackend.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;

	@Autowired
	private EstadoService estadoService;

	public List<Cidade> findAll() {
		return repo.findAll();
	}

	public Cidade findById(String id) {
		Optional<Cidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFounException("Objeto não encontrado"));
	}

	public Cidade insert(CidadeDTO objDTO) {
		Estado estado = estadoService.findById(objDTO.getEstado());
		Cidade newObj = new Cidade(null, objDTO.getName(), estado);
		return repo.insert(newObj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public Cidade update(CidadeDTO objDTO) {
		Cidade newObj = findById(objDTO.getId());
		updateData(newObj, objDTO);
		return repo.save(newObj);
	}

	private void updateData(Cidade newObj, CidadeDTO objDTO) {
		if (objDTO.getName() != null) {
			newObj.setName(objDTO.getName());
		}
		if (objDTO.getEstado() != null) {
			Estado estado = estadoService.findById(objDTO.getEstado());
			newObj.setEstado(estado);
		}
	}

}
