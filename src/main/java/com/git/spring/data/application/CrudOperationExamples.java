package com.git.spring.data.application;

import com.git.spring.data.entities.Book;
import com.git.spring.data.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class CrudOperationExamples {

    //Spring data looks at the IDs to decide what to do - save or update. If they don't have IDs, it goes for saving. If the ID isn't used, goes for updating
    public static void modifyTitleOfBook(Long id, String newTitle, BookRepository repository) {
        Book book = repository.findOne(id);
        System.out.println(book);
        book.setTitle(newTitle);
        repository.save(book);
        System.out.println(book);
    }

    public static List<Book> returnMultipleBooksByListOfIDs(BookRepository repository) {
        return repository.findAll(new ArrayList<Long>() {{
            add(1L);
            add(3L);
            add(7L);
        }});
    }

    public static void showFoundSingleBookAndAllBooks(BookRepository repository, Long id) {
        Book bookGet = repository.findOne(1L); //Get a single book by ID;
        List<Book> books = repository.findAll(); //Get all books.

        System.out.println("Single book queried for with the ID of: " + id);
        System.out.println("\t" + bookGet);

        System.out.println("List of all the books that are in the database: ");
        for(Book singleBook : books) {
            System.out.println("\t" + singleBook);
        }
    }

    public static void saveOneBook(Book book, BookRepository repository) {
        repository.save(book);
    }

    public static void saveMultipleBooks(List<Book> books, BookRepository repository) {
        repository.save(books);
    }

    public static void deleteBookByIdAndByEntityReference(Long id, BookRepository repository) {
        repository.delete(1L);
        repository.delete(repository.getOne(2L));
    }

    public static void overloadedBooksDelete(BookRepository repository) {
        repository.delete(returnMultipleBooksByListOfIDs(repository));
        //Could use deleteInBatch instead, doesn't do multiple single deletes, deletes in batch.
        //Batch operations are specific to JPA repository interface. Not found on CRUDRepository interface.
    }
}
