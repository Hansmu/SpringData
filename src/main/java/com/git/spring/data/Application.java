package com.git.spring.data;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        //Bootstrap the configuration to our application.
        try ( AnnotationConfigApplicationContext context =
                      new AnnotationConfigApplicationContext(DataConfiguration.class)) {
            //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
            BookRepository repository = context.getBean(BookRepository.class);
            ReadOnlyBookRepository readOnlyRepository = context.getBean(ReadOnlyBookRepository.class);

            System.out.println(readOnlyRepository.findOne(1L));
            //CrudOperationExamples.modifyTitleOfBook(1L, "War and Peace", repository);
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
