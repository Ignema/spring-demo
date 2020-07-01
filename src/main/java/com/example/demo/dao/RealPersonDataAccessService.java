package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class RealPersonDataAccessService implements PersonDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RealPersonDataAccessService(JdbcTemplate jdbcTemplate){

        this.jdbcTemplate = jdbcTemplate;

    }

    @Override
    public List<Person> selectAllPeople() {

        final String sql = "SELECT id,name FROM person";

        return jdbcTemplate.query(sql,(rs, rowNum) -> {

            UUID id = UUID.fromString(rs.getString("id"));

            return new Person(id,rs.getString("name"));

        });

    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public boolean insertPerson(UUID id, Person person) {
        return false;
    }

    @Override
    public boolean deletePersonById(UUID id) {
        return false;
    }

    @Override
    public boolean updatePersonById(UUID id, Person person) {
        return false;
    }
}
