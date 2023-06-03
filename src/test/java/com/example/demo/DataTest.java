package com.example.demo;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.repositories.BookRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.example.demo.bootstrap"})
public class DataTest {
    
    @Autowired
    BookRepository bookRepository;

    @Commit
    @Order(1)
    @Test
    public void Test1(){
       long count = bookRepository.count();
       assertThat(count).isEqualTo(3);
       bookRepository.deleteById(1L);

    }

    @Order(2)
    @Test
    public void Test2(){
        long count = bookRepository.count();
        assertThat(count).isEqualTo(2);
    }
}

