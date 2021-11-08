package com.joe.spring6web.bootstrap;

import com.joe.spring6web.domain.Author;
import com.joe.spring6web.domain.Book;
import com.joe.spring6web.domain.repositories.AuthorRepository;
import com.joe.spring6web.domain.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    
    @Override
    public void run (String... args ) throws Exception {
        Author a = new Author("Eric", "Evans");
        Book b = new Book("Domain Driven Design", "123");
        a.getBooks().add(b);
        b.getAuthors().add(a);
        authorRepository.save(a);
        bookRepository.save(b);
       
        Author a2 = new Author("Joe", "Rodriguez");
        Book b2 = new Book("Joe's Book", "123");
        a2.getBooks().add(b2);
        b2.getAuthors().add(a2);
        authorRepository.save(a2);
        bookRepository.save(b2);
        
        System.out.println("Started in bootstrap");
        System.out.println("Number of books : " + bookRepository.count());
        
    }
}
