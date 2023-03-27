package com.klarna.people.repository;

import com.klarna.people.models.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryPersonRepository {

    private final Map<String, Person> persons = new HashMap<>();

    public Person save(Person person) {
        persons.put(person.getSsn(), person);
        return person;
    }

    public Optional<Person> findBySsn(String ssn) {
        return Optional.ofNullable(persons.get(ssn));
    }
}
