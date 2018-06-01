package com.chmmaestro.maisvidabackend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.chmmaestro.maisvidabackend.domain.Cidade;

@Repository
public interface CidadeRepository extends MongoRepository<Cidade, String> {
	
	@Query("{ 'estado.id': { $eq: ?0 } }")
	public List<Cidade> cidadeByEstadoId(String text);
	
}
