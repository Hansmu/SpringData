package com.git.spring.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean //Not made into a repository.
public interface BaseRepository <T, ID extends Serializable> extends JpaRepository<T, ID> {

    public List<T> findByIds(ID... ids);
}
