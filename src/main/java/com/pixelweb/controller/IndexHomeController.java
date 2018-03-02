package com.pixelweb.controller;

import com.pixelweb.model.Book;
import com.pixelweb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;

@RestController
public class IndexHomeController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public HashSet<Book> getAllBooks(){
        HashSet<Book> books = new HashSet<>();
        bookRepository.findAll()
                .forEach(books::add);

        return books;
    }


}
