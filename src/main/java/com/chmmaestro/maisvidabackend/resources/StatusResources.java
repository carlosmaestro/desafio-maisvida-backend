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

import com.chmmaestro.maisvidabackend.domain.Status;
import com.chmmaestro.maisvidabackend.services.StatusService;

@RestController
@RequestMapping(value = "/status")
public class StatusResources {

	@Autowired
	private StatusService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Status>> findAll() {

		List<Status> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Status> findById(@PathVariable String id) {
		Status obj = service.findById(id);

		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Status obj) {

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
	public ResponseEntity<Void> update(@RequestBody Status obj, @PathVariable String id) {
		obj.setId(id);
		service.update(obj);
		return ResponseEntity.noContent().build();
	}

}
