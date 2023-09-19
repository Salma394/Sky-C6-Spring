package com.qa.person.demo.repo;

import com.qa.person.demo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

    Person findByNameIgnoreCase(String name);
}
