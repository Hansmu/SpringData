package com.git.spring.data;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.Date;

public class Application {

    public static void main(String[] args) {
        //Bootstrap the configuration to our application.
        try ( AnnotationConfigApplicationContext context =
                      new AnnotationConfigApplicationContext(DataConfiguration.class)) {
            BookService service = context.getBean(BookService.class);
            Book book = new Book("First Book", new Date(), 33, new BigDecimal("26.00"));

            service.save(book);
        }
    }
}
