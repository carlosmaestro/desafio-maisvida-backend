package com.chmmaestro.maisvidabackend.dto;

import com.chmmaestro.maisvidabackend.domain.Cidade;

public class CidadeDTO {
	
	String id;
	String name;
	String estado;
	
	public CidadeDTO() {
		
	}

	public CidadeDTO(Cidade obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.estado = obj.getEstado().getId();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
