package com.git.spring.data.application;

import com.git.spring.data.entities.Book;
import com.git.spring.data.repositories.PageableRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;

public class PageableExample {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        PageableRepository repository = context.getBean(PageableRepository.class);

        //First value is the page you're on and the second the size of the page. Pages are 0 based.
        for(Book book : repository.findAll(new PageRequest(0, 3))) {
            System.out.println(book);
        }
        repository.findBypageCountGreaterThan(150, new PageRequest(1, 3));
    }
}
