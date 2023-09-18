package com.qa.person.demo.rest;

import com.qa.person.demo.domain.Person;
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
    public Person createPerson(@RequestBody Person p) {
        people.add(p);
        return this.people.get(this.people.size() - 1); // return the last element in the list
    }

    @GetMapping("/get/{bloop}")
    public Person getPerson(@PathVariable int bloop ) {
        System.out.println("ID: " + bloop);
        return null;
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
