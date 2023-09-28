package com.qa.person.demo.dtos;

import com.qa.person.demo.domain.Book;
import com.qa.person.demo.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDTO {

    private Integer id;

    private String name;

    private int age;

    private String jobTitle;

    private List<BookDTO> books;

    // Stores the film data fetched from the API
    private FilmDTO film;

    public PersonDTO(Person p) {
        this.id = p.getId();
        this.name = p.getName();
        this.age = p.getAge();
        this.jobTitle = p.getJobTitle();
        List<BookDTO> dtos = new ArrayList<>();
        for (Book b : p.getBooks())
            dtos.add(new BookDTO(b));
        this.books = dtos;
    }

    public PersonDTO() {
        super();
    }


    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
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


    public FilmDTO getFilm() {
        return film;
    }

    public void setFilm(FilmDTO film) {
        this.film = film;
    }
}
