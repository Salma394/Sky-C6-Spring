package com.qa.person.demo.services;

import com.qa.person.demo.domain.Person;
import com.qa.person.demo.repo.PersonRepo;
//import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary // tells Spring to suse this one over the PersonServiceList
public class PersonServiceDB implements PersonService {

    private PersonRepo repo;

    public PersonServiceDB(PersonRepo repo) {
        this.repo = repo;
    }

    @Override
    public Person createPerson(Person p) {
        return this.repo.save(p);
    }

    @Override
    public Person getPerson(int id) {
        // There MIGHT be a person
        // There MIGHT NOT be a person
        Optional<Person> found = this.repo.findById(id);
        // Rips the top off of Schrodinger's box and uses whatever's inside
        return found.get();
    }

    @Override
    public Person findPersonByName(String name) {
        return this.repo.findByNameIgnoreCase(name);
    }

    @Override
    public List<Person> getAll() {
        return this.repo.findAll();
    }

    @Override
    public Person updatePerson(Integer id, String name, Integer age, String jobTitle) {
        Person toUpdated = this.getPerson(id);

        if (name != null) toUpdated.setName(name);
        if (age != null) toUpdated.setAge(age);
        if (jobTitle != null) toUpdated.setJobTitle(jobTitle);

        return this.repo.save(toUpdated);
    }



    @Override
    public String removePerson(int id) {
        if (this.repo.existsById(id)) {
            this.repo.deleteById(id);
            return "Person removed";
        } else {
            return "NOT FOUND";
        }
    }
}
