package com.git.spring.data.repositories;

import com.git.spring.data.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomRepository extends JpaRepository<Book, Long> {

    /** QUERIES ARE WRITTEN IN JPQL. **/
    /** MAINLY USED FOR WRITING COMPLEX QUERIES THAT YOU CAN'T JUST DERIVE. **/

    @Query("SELECT b FROM Book b")
    List<Book> queryForAllBooks();

    //It would be better to use named parameters instead of positional parameters.
    @Query("SELECT b FROM Book b WHERE b.pageCount > ?1") //?1 references the first parameter.
    List<Book> queryForAllBooksWherePageCountIsLargerThan(int pageCount);

    @Query("SELECT b FROM Book b WHERE b.title= :title")
    List<Book> queryByTitle(@Param("title") String title); //Specify the named parameter in the @Param to bind it to the passed in value.

    /** NamedQuery. Bound in Book entity. **/
    /** BETTER TO USE @QUERY THAN @NAMEDQUERY **/
    List<Book> queryAll();
    List<Book> queryForAllWithGreaterPageCount();
    List<Book> queryAllWithTitle();

}
