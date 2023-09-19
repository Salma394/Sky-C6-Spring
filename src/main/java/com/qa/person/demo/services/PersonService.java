package com.qa.person.demo.services;

import com.qa.person.demo.domain.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person p);

    Person getPerson(int id);

    List<Person> getAll();

    Person updatePerson(
            Integer id,
            String name,
            Integer age,
            String jobTitle);

    String removePerson(int id);

    Person findPersonByName(String name);

}
