package com.qa.person.demo.services;

import com.qa.person.demo.domain.Person;
import com.qa.person.demo.dtos.PersonDTO;

import java.util.List;

public interface PersonService {

    Person createPerson(Person p);

    Person getPerson(int id);

    List<PersonDTO> getAll();

    Person updatePerson(
            Integer id,
            String name,
            Integer age,
            String jobTitle);

    String removePerson(int id);

    Person findPersonByName(String name);

}
