package com.klarna.people.controller;

import com.klarna.people.models.dto.PersonDto;
import com.klarna.people.models.entity.Child;
import com.klarna.people.models.entity.Person;
import com.klarna.people.repository.InMemoryPersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private final InMemoryPersonRepository repository;

    @Autowired
    public PersonController(InMemoryPersonRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody PersonDto personDto) throws IllegalAccessException {

        Person person = new Person();
        BeanUtils.copyProperties(personDto, person);
        person.setId(UUID.randomUUID().toString());

        List<Child> newChildren = personDto.getChildren().stream().map(c->new Child(c, personDto.getSsn())).collect(Collectors.toList());
        person.setChildren(newChildren);
        repository.save(person);

        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @GetMapping("/{ssn}")
    public ResponseEntity<Person> getPerson(@PathVariable("ssn") String ssn) {
        Optional<Person> person = repository.findBySsn(ssn);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{ssn}/oldest-child")
    public ResponseEntity<Child> getOldestChild(@PathVariable("ssn") String ssn) {
        Optional<Person> person = repository.findBySsn(ssn);
        if (person.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Child oldestChild = Collections.max(person.get().getChildren(), Comparator.comparingInt(Child::getAge));
        return ResponseEntity.ok(oldestChild);
    }
}