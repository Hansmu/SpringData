package com.git.spring.data.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * Since we have component scan turned on, it searches for this interface, finds it, creates an implementation.
 * Since we want a read only interface, we need to change that behavior.
 *
 * NoRepositoryBean - stops Spring from picking out our interface and building an implementation.
 * **/
@NoRepositoryBean
public interface ReadOnlyRepository<T, ID extends Serializable> extends Repository<T, ID> {

    /**
     * The way that they're declared should match the underlying Spring data repositories.
     * **/
    T findOne(ID id);
    Iterable<T> findAll();
}
