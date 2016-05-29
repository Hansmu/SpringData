package com.git.spring.data.repositories;

import com.git.spring.data.entities.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadOnlyBookRepository extends ReadOnlyRepository<Book, Long> {

}
