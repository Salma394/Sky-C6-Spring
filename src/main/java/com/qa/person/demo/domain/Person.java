package com.qa.person.demo.domain;

import javax.persistence.*;

@Entity // tells Spring this class is linked to a table
@Table
public class Person {

    @Id // marks the field as a unique identifier (Primary Key)
    // sets the field to AUTO_INCREMENT (id starts at 1 and goes up by 1 each new record)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int age;

    private String jobTitle;

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
}
