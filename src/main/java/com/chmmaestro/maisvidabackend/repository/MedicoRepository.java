package com.chmmaestro.maisvidabackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chmmaestro.maisvidabackend.domain.Medico;

@Repository
public interface MedicoRepository extends MongoRepository<Medico, String> {

}
