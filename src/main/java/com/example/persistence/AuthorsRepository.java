// src/main/java/com/example/persistence/AuthorsRepository.java
package com.example.persistence;

import com.example.splab.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Long> { }
