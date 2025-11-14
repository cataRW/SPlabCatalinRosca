// src/main/java/com/example/persistence/BooksRepository.java
package com.example.persistence;

import com.example.splab.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {
}
