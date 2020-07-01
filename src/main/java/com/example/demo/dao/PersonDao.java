package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    List<Person> selectAllPeople();
    Optional<Person> selectPersonById(UUID id);

    boolean insertPerson(UUID id, Person person);
    boolean deletePersonById(UUID id);
    boolean updatePersonById(UUID id, Person person);

    default boolean insertPerson(Person person){

        UUID id = UUID.randomUUID();

        return insertPerson(id,person);

    };

}
