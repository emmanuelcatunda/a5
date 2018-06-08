package com.example.a5.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.a5.model.Person;

@Repository
public interface PersonRepository extends ReactiveMongoRepository<Person, String> {

}
