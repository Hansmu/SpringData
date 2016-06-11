package com.git.spring.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.scheduling.annotation.Async;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean //Not made into a repository.
public interface BaseRepository <T, ID extends Serializable> extends JpaRepository<T, ID> {

    @Async //To run method executions as asynchronous.
    public List<T> findByIds(ID... ids);
}
