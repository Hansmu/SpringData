package com.git.spring.data.repositories;

import com.git.spring.data.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationalQueryRepository extends JpaRepository<Book, Long> {

    /** RELATIONAL OPERATORS **/
    /** CAN ONLY BE USED WHEN THE FIELD HAS IMPLEMENTED THE COMPARABLE INTERFACE **/
    //Finds a value that's equal to the one supplied.
    List<Book> findByPageCountEquals(int pageCount);

    // >
    List<Book> findByPageCountGreaterThan(int pageCount);

    // >=
    List<Book> findByPageCountGreaterThanEqual(int pageCount);

    // <
    List<Book> findByPageCountLessThan(int pageCount);

    // <=
    List<Book> findByPageCountLessThanEqual(int pageCount);

    //In between the provided values
    List<Book> findByPageCountBetween(int min, int max);
}
