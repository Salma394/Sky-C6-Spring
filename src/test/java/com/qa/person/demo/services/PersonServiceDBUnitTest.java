package com.qa.person.demo.services;

import com.qa.person.demo.domain.Person;
import com.qa.person.demo.repo.PersonRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class PersonServiceDBUnitTest {


    @Autowired
    private PersonService service;

    @MockBean
    private PersonRepo repo;


    @Test
    void testUpdate() {
        int id = 24;

        Optional<Person> found = Optional.of(new Person(id, "Jordan", 29, "Trainer"));
        Person updated = new Person(id, "Harry", 12, "Hamster");

        Mockito.when(this.repo.findById(id)).thenReturn(found);
        Mockito.when(this.repo.save(updated)).thenReturn(updated);


        Assertions.assertEquals(updated, this.service.updatePerson(id, "Harry", 12, "Hamster"));

        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
        Mockito.verify(this.repo, Mockito.times(1)).save(updated);


    }
}
