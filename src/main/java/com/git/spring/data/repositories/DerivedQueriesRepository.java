package com.git.spring.data.repositories;

import com.git.spring.data.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * There are two ways to define a query in Spring - manually or from the method name.
 * */

@Repository
public interface DerivedQueriesRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String title);

    //Can use wildcards in here.
    //findByTitleLike("%of%")
    List<Book> findByTitleLike(String title);

    //Text that's contained in it.
    //findByTitleContaining("of")
    List<Book> findByTitleContaining(String title);

    //Text that's in the beginning of title.
    //findByTitleStartingWith("O");
    List<Book> findByTitleStartingWith(String title);

    //Text that's at the end of the title.
    //findByTitleEndingWith("s")
    List<Book> findByTitleEndingWith(String title);

    //findByTitleIgnoreCase("ANIMAL FARM")
    List<Book> findByTitleIgnoreCase(String title);
}