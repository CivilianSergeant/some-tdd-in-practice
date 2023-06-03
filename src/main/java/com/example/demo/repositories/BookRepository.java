package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    
}