package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("sampleDao")
public class SamplePersonDataAccessService implements PersonDao {

    private static List<Person> db = new ArrayList<>();

    @Override
    public List<Person> selectAllPeople() {
        return db;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return db.stream().filter(person -> person.getUid().equals(id)).findFirst();
    }

    @Override
    public boolean insertPerson(UUID id, Person person) {

        db.add(new Person(id,person.getName()));
        return true;

    }

    @Override
    public boolean deletePersonById(UUID id) {

        Optional<Person> person = selectPersonById(id);

        if(person.isEmpty()) {
            return false;
        }

        db.remove(person.get());

        return true;
    }

    @Override
    public boolean updatePersonById(UUID id, Person person) {

        return selectPersonById(id).map(p -> {

            int indexOfPersonToUpdate = db.indexOf(p);
            if(indexOfPersonToUpdate >= 0){

                db.set(indexOfPersonToUpdate, new Person(id,person.getName()));

                return true;

            }

            return false;

        }).orElse(false);

    }

}
