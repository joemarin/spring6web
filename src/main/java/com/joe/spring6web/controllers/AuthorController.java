package com.joe.spring6web.controllers;

import com.joe.spring6web.domain.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    
    @RequestMapping("/authors")
    public String getBooks(Model model) {
        model.addAttribute( "authors", authorRepository.findAll() );
        
        return "authors/list";
    }
    
}
