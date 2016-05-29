package com.git.spring.data;

import org.springframework.stereotype.Repository;

@Repository
public interface ReadOnlyBookRepository extends ReadOnlyRepository<Book, Long> {
}
