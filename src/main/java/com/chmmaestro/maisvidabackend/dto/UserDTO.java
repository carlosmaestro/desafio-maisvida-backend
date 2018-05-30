package com.chmmaestro.maisvidabackend.dto;

import java.io.Serializable;

import com.chmmaestro.maisvidabackend.domain.User;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String email;
	private Boolean ativo;

	public UserDTO() {

	}

	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
		ativo = obj.getAtivo();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	
}
