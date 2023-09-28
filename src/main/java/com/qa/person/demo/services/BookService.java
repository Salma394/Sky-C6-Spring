package com.qa.person.demo.services;

import com.qa.person.demo.domain.Book;
import com.qa.person.demo.dtos.BookDTO;
import com.qa.person.demo.repo.BookRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {


    private BookRepo repo;

    public BookService(BookRepo repo) {
        this.repo = repo;
    }


    public Book createBook(Book b) {
        return this.repo.save(b);
    }

    public List<BookDTO> getBooks() {
        List<BookDTO> dtos = new ArrayList<>();

        for (Book b : this.repo.findAll())
            dtos.add(new BookDTO(b));

        return dtos;
    }
}
