package com.git.spring.data.repositories;

import com.git.spring.data.entities.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageableRepository extends JpaRepository<Book, Long> {

    //To get a custom pageable query.
    public List<Book> findBypageCountGreaterThan(int pageCount, Pageable pageable);
}
