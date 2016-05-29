package com.git.spring.data.repositories;

import com.git.spring.data.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    /** ORDERING RESULTS **/
    List<Book> findByTitleContainingOrderByTitleAsc(String title);
    List<Book> findByTitleContainingOrderByTitleDesc(String title);

    /** LIMITING RESULTS **/
    //Top - return the first result within the result set. First serves the same purpose. Pick one and stick to it.
    //Order all of the books by their page count in descending order and return the first item in the list.
    List<Book> findTopByOrderByPageCountDesc();
    List<Book> findFirstByOrderByPageCountAsc();

    //Specify some integer value for how many results should be returned
    List<Book> findTop5ByOrderByPriceDesc();
}