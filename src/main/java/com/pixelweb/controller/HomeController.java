package com.pixelweb.controller;

import com.pixelweb.model.Book;
import com.pixelweb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;

@Controller
public class HomeController {

    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/ng")
    public String getAll(Model model){

        model.addAttribute("book",bookRepository.findAll());
        HashSet<Book> books = new HashSet<>();
        bookRepository.findAll()
                .forEach(books::add);
        return "index";
    }
    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String displayAddBookForm(Model model){
        model.addAttribute("books","name");
        model.addAttribute(new Book());
        return "add";
    }
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String processAddBookForm(@ModelAttribute @Valid Book bookNames,
                                     Errors errors, Model model){
        bookRepository.save(bookNames);

        return "redirect:";
    }
}
