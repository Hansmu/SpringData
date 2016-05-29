package com.git.spring.data.application;


import com.git.spring.data.entities.Book;
import com.git.spring.data.repositories.BookRepository;
import com.git.spring.data.repositories.DerivedQueriesRepository;
import com.git.spring.data.repositories.ReadOnlyBookRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

            for(Book book: derivedRepository.findByTitleLike("%of%")) {
                System.out.println(book);
            }

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