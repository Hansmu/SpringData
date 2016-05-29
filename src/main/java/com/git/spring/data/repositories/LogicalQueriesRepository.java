package com.git.spring.data.repositories;

import com.git.spring.data.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogicalQueriesRepository extends JpaRepository<Book, Long> {

    //Title contains parameter 1 or parameter 2.
    List<Book> findByTitleContainingOrTitleContaining(String title, String title2);

    //Title contains parameter 1 and page count is >.
    List<Book> findByTitleContainingAndPageCountGreaterThan(String title, int pageCount);

    //Finds books that don't match the provided title.
    List<Book> findByTitleNot(String title);
}
