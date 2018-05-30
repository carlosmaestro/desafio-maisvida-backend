package com.chmmaestro.maisvidabackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chmmaestro.maisvidabackend.domain.Status;

@Repository
public interface StatusRepository extends MongoRepository<Status, String> {

}
