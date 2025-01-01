package com.example.demo.repository;

import com.example.demo.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Long addPerson(String name) {
        Person person = new Person();
        person.setName(name);
        entityManager.persist(person);
        return person.getId();
    }

    public Person getPerson(Long id) {
        return entityManager.find(Person.class, id);
    }

}
