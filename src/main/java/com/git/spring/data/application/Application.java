package com.git.spring.data.application;


import com.git.spring.data.entities.Book;
import com.git.spring.data.repositories.BookRepository;
import com.git.spring.data.repositories.CustomRepository;
import com.git.spring.data.repositories.DerivedQueriesRepository;
import com.git.spring.data.repositories.ReadOnlyBookRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.Date;

public class Application {

    public static void main(String[] args) {
        //Bootstrap the configuration to our application.
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        try ( AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration.class)) {

            BookRepository repository = context.getBean(BookRepository.class);
            ReadOnlyBookRepository readOnlyRepository = context.getBean(ReadOnlyBookRepository.class);
            DerivedQueriesRepository derivedRepository = context.getBean(DerivedQueriesRepository.class);
            CustomRepository customRepository = context.getBean(CustomRepository.class);


            for(Book book: customRepository.queryAll()) {
                System.out.println(book);
            }
            //In order to sort your results on your own.
            //If we provide the sort, we can direct sorting.
            //Create a new sort class and provide the field name. First argument in overloaded construct to specify sort.
            //Can provide more than one field to sort by.
            //Provide with .and() to do sorting in another direction for another field. Used as a secondary sort.
            repository.findAll(new Sort(Sort.Direction.DESC, "author.lastName", "pageCount") //By default in ascending order.
                    .and(new Sort(Sort.Direction.ASC, "pageCount"))); //Can provide the Sort argument to your repository methods as well.

            CrudOperationExamples.showFoundSingleBookAndAllBooks(repository, 1L);
        }
    }

    private static Book createNewBook(String title) {
        Book book = new Book();
        book.setTitle("Title");
        book.setPageCount(150);
        book.setPrice(new BigDecimal("100.00"));
        book.setPublishDate(new Date());

        return book;
    }
}