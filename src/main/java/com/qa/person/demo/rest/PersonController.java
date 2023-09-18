package com.qa.person.demo.rest;

import com.qa.person.demo.domain.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // 'annotates' the class as a controller
public class PersonController {

    private List<Person> people = new ArrayList<>();

    // 'maps' this method to a GET request at /hello
    @GetMapping("/hello")
    public String test() {
        return "Hello, World!";
    }

    // 'maps' the method to a POST request at /crate
    @PostMapping("/create")
    // The Person will be passed in via the request body
    public ResponseEntity<Person> createPerson(@RequestBody Person p) {
        people.add(p);
        Person created = this.people.get(this.people.size() - 1); // return the last element in the list
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id) {
        System.out.println("ID: " + id);

        if (id >= this.people.size()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(this.people.get(id));
    }

    @GetMapping("/getAll")
    public List<Person> getPeople() {
        return null;
    }

    @PatchMapping("/update")
    public void updatePerson(
            @RequestParam(name = "id", required = true)  int id,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "jobTitle", required = false) String jobTitle
    ) {
        System.out.println("ID: " + id);
        System.out.println("NAME: " + name);
        System.out.println("AGE: " + age);
        System.out.println("JOB: " + jobTitle);
        return;
    }


    @DeleteMapping("/remove/{id}")
    public String removePerson(@PathVariable int id) {
        return null;
    }
}
