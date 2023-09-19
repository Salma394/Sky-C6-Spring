package com.qa.person.demo.rest;

import com.qa.person.demo.domain.Person;
import com.qa.person.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 'annotates' the class as a controller
public class PersonController {

//    @Autowired // valid but less intuitive/efficient than a constructor
    private PersonService service;

    // Spring will automatically inject a PersonService when it boots
    public PersonController(PersonService service) {
        this.service = service;
    }

    // 'maps' this method to a GET request at /hello
    @GetMapping("/hello")
    public String test() {
        return "Hello, World!";
    }

    // 'maps' the method to a POST request at /crate
    @PostMapping("/create")
    // The Person will be passed in via the request body
    public ResponseEntity<Person> createPerson(@RequestBody Person p) {
        return new ResponseEntity<>(this.service.createPerson(p), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id) {
        System.out.println("ID: " + id);

        Person found = this.service.getPerson(id);

        if (found == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(found);
    }

    @GetMapping("/getAll")
    public List<Person> getPeople() {
        return this.service.getAll();
    }

    @PatchMapping("/update")
    public ResponseEntity<Person> updatePerson(
            @RequestParam(name = "id", required = true) int id,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "jobTitle", required = false) String jobTitle) {
        System.out.println("ID: " + id);
        System.out.println("NAME: " + name);
        System.out.println("AGE: " + age);
        System.out.println("JOB: " + jobTitle);


        Person updated = this.service.updatePerson(id, name, age, jobTitle);
        if (updated == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removePerson(@PathVariable int id) {
        String result = this.service.removePerson(id);
        if ("NOT FOUND".equalsIgnoreCase(result)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return ResponseEntity.ok(result);
    }
}
