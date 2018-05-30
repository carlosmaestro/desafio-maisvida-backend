package com.chmmaestro.maisvidabackend.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chmmaestro.maisvidabackend.domain.Medico;
import com.chmmaestro.maisvidabackend.dto.MedicoDTO;
import com.chmmaestro.maisvidabackend.services.MedicoService;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoResources {

	@Autowired
	private MedicoService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Medico>> findAll() {

		List<Medico> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Medico> findById(@PathVariable String id) {
		Medico obj = service.findById(id);

		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody MedicoDTO obj) {

		service.insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody MedicoDTO objDTO, @PathVariable String id) {
		objDTO.setId(id);
		service.update(objDTO);
		return ResponseEntity.noContent().build();
	}

}
