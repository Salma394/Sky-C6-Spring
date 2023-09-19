package com.qa.person.demo.services;

import com.qa.person.demo.domain.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceList implements PersonService {

    private List<Person> people = new ArrayList<>();

    @Override
    public Person createPerson(Person p) {
        people.add(p);
        Person created = this.people.get(this.people.size() - 1); // return the last element in the list
        return created;
    }

    @Override
    public Person getPerson(int id) {
        if (id < this.people.size())
            return this.people.get(id);
        else
            return null;
    }

    @Override
    public List<Person> getAll() {
        return this.people;
    }

    @Override
    public Person updatePerson(Integer id, String name, Integer age, String jobTitle) {
        if (id >= this.people.size()) return null;
        Person toUpdate = this.people.get(id);

        if (name != null) toUpdate.setName(name);
        if (age != null) toUpdate.setAge(age);
        if (jobTitle != null) toUpdate.setJobTitle(jobTitle);

        return toUpdate;
    }

    @Override
    public String removePerson(int id) {
        if (id >= this.people.size()) return "NOT FOUND";
        else {
            this.people.remove(id);
            return "Person removed";
        }
    }
}
