package com.joe.spring6web.domain.repositories;

import com.joe.spring6web.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    
}
