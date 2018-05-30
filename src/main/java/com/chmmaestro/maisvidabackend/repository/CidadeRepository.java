package com.chmmaestro.maisvidabackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chmmaestro.maisvidabackend.domain.Cidade;

@Repository
public interface CidadeRepository extends MongoRepository<Cidade, String> {

}
