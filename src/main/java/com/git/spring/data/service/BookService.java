package com.git.spring.data.service;

import com.git.spring.data.application.Application;
import com.git.spring.data.entities.Book;
import com.git.spring.data.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public void save(Book book) {
        this.repository.save(book);
    }
}
