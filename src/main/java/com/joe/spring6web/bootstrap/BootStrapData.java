package com.joe.spring6web.bootstrap;

import com.joe.spring6web.domain.Author;
import com.joe.spring6web.domain.Book;
import com.joe.spring6web.domain.Publisher;
import com.joe.spring6web.domain.repositories.AuthorRepository;
import com.joe.spring6web.domain.repositories.BookRepository;
import com.joe.spring6web.domain.repositories.PublisherRepository;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
            PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }
    
    @Override
    public void run (String... args ) throws Exception {
        Author a = new Author("Eric", "Evans");
        Author a2 = new Author("Joe", "Evans");
        
        Book b = new Book("Domain Driven Design", "123");
        Book b2 = new Book("Joe's Book", "123");
        Book b3 = new Book("Joe2's Book", "123");
        
        Publisher p = new Publisher("Calle del Rey", "Sto Domingo", "CR", "123");
        

        publisherRepository.save(p);
        authorRepository.save(a);
        authorRepository.save(a2);
        bookRepository.save(b);
        bookRepository.save(b2);
        bookRepository.save(b3);
        
        p.getBooks().add(b);
        p.getBooks().add(b2);
        p.getBooks().add(b3);
        
        b.setAuthors( new HashSet<>( Arrays.asList( new Author[]{a, a2} )) );
        
        publisherRepository.save(p);
        authorRepository.save(a);
        bookRepository.save(b);
        //bookRepository.save(b2);
        
        System.out.println("Started in bootstrap");
        System.out.println("Number of books : " + bookRepository.count());
        System.out.println("Number of Author in books : " + b.getAuthors().size() );
        System.out.println("Publisher Number of books : " + p.getBooks().size());
        
        /*
                Author a2 = new Author("Joe", "Rodriguez");
        
        a2.getBooks().add(b2);
        b2.getAuthors().add(a2);
        p.getBooks().add(b2);
        b2.setPublisher(p);
        authorRepository.save(a2);
        bookRepository.save(b2);
        publisherRepository.save(p);


        b.setPublisher(p);        
        a.getBooks().add(b);
        b.getAuthors().add(a);
        p.getBooks().add(b);

        publisherRepository.save(p);
        authorRepository.save(a);
        bookRepository.save(b);
        */
    }
}
