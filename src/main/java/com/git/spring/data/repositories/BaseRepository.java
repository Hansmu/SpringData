package com.git.spring.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean //Not made into a repository.
public interface BaseRepository <T, ID extends Serializable> extends JpaRepository<T, ID> {

    @Async //To run method executions as asynchronous.
    public List<T> findByIds(ID... ids);

    @Transactional//Then our query is executed within a transaction.
    @Modifying//Indicator to Spring Data that the method will modify entities.
    @Query("UPDATE Book b SET b.pageCount = ?2 WHERE b.title LIKE ?1")//JPQL query
    public int setPageCount(String title, int pageCount);
}
