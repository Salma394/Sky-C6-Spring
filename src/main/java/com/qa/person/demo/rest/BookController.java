package com.qa.person.demo.rest;

import com.qa.person.demo.domain.Book;
import com.qa.person.demo.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Book createBook(@RequestBody Book b) {
        return this.service.createBook(b);
    }

    @GetMapping("/get")
    public List<Book> getBooks() {
        return this.service.getBooks();
    }
}
