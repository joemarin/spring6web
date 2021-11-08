package com.joe.spring6web.domain.repositories;

import com.joe.spring6web.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    
}
