package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/create")
    public Long create(@RequestBody Person person) {
        return personRepository.addPerson(person.getName());
    }

    @GetMapping("/get/{id}")
    public Person get(@PathVariable Long id) {
        return personRepository.getPerson(id);
    }
}
