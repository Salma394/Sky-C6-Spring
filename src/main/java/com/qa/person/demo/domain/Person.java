package com.qa.person.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity // tells Spring this class is linked to a table
public class Person {

    @Id // marks the field as a unique identifier (Primary Key)
    // sets the field to AUTO_INCREMENT (id starts at 1 and goes up by 1 each new record)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int age;

    private String jobTitle;

    // Bidirectional relationship
    @OneToMany(mappedBy = "owner")
//    @JsonManagedReference
    private List<Book> books;

    public Person(Integer id, String name, int age, String jobTitle) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.jobTitle = jobTitle;
    }

    public Person(String name, int age, String jobTitle) {
        super();
        this.name = name;
        this.age = age;
        this.jobTitle = jobTitle;
    }

    // REQUIRED
    public Person() {
        super();
    }


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", jobTitle='" + jobTitle + '\'' + '}';
    }
}
