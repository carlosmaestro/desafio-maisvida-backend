package com.chmmaestro.maisvidabackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chmmaestro.maisvidabackend.domain.Cidade;
import com.chmmaestro.maisvidabackend.domain.Especialidade;
import com.chmmaestro.maisvidabackend.domain.Medico;
import com.chmmaestro.maisvidabackend.domain.Status;
import com.chmmaestro.maisvidabackend.dto.MedicoDTO;
import com.chmmaestro.maisvidabackend.exception.ObjectNotFounException;
import com.chmmaestro.maisvidabackend.repository.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository repo;

	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private EspecialidadeService espService;

	@Autowired
	private StatusService statusService;

	public List<Medico> findAll() {
		return repo.findAll();
	}

	public Medico findById(String id) {
		Optional<Medico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFounException("Objeto não encontrado"));
	}

	public Medico insert(MedicoDTO objDTO) {
		Cidade cidade = cidadeService.findById(objDTO.getCidade());
		Especialidade esp = espService.findById(objDTO.getEspecialidade());
		Status status = statusService.findById(objDTO.getStatus());
		Medico newObj = new Medico(null, objDTO.getFirst_name(), objDTO.getLast_name(), objDTO.getAtivo(), esp, status,
				cidade, objDTO.getEmail());
		return repo.insert(newObj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public Medico update(MedicoDTO objDTO) {
		Medico newObj = findById(objDTO.getId());
		updateData(newObj, objDTO);
		return repo.save(newObj);
	}

	private void updateData(Medico newObj, MedicoDTO objDTO) {
		if (objDTO.getFirst_name() != null) {
			newObj.setFirst_name(objDTO.getFirst_name());
		}

		if (objDTO.getAtivo() != null) {
			newObj.setAtivo(objDTO.getAtivo());
		}

		if (objDTO.getLast_name() != null) {
			newObj.setLast_name(objDTO.getLast_name());
		}
		if (objDTO.getCidade() != null) {
			Cidade cidade = cidadeService.findById(objDTO.getCidade());
			newObj.setCidade(cidade);
		}

		if (objDTO.getEspecialidade() != null) {
			Especialidade esp = espService.findById(objDTO.getEspecialidade());
			newObj.setEspecialidade(esp);
		}

		if (objDTO.getStatus() != null) {
			Status status = statusService.findById(objDTO.getStatus());
			newObj.setStatus(status);
		}
		if (objDTO.getEmail() != null) {
			newObj.setEmail(objDTO.getEmail());
		}

	}

}
