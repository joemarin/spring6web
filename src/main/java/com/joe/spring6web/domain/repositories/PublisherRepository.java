package com.joe.spring6web.domain.repositories;

import com.joe.spring6web.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    
}
