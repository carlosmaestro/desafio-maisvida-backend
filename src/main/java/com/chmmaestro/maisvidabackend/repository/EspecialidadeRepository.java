package com.chmmaestro.maisvidabackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chmmaestro.maisvidabackend.domain.Especialidade;

@Repository
public interface EspecialidadeRepository extends MongoRepository<Especialidade, String> {

}
