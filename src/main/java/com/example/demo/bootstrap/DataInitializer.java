package com.example.demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Book;
import com.example.demo.repositories.BookRepository;

@Component
public class DataInitializer implements CommandLineRunner{

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
    
        Book book = new Book("Domain Driven Design", "12345", "Wrox Publication");
        Book savedBook = bookRepository.save(book);
        
        System.out.println("ID:"+savedBook.getId());

        Book book2 = new Book("Spring In Action", "123456", "Manning Publication");
        Book savedBook2 = bookRepository.save(book2);
        System.out.println("ID:"+savedBook2.getId());

        Book book3 = new Book("Java Complete Reference", "1234567", "MacgrowHill Publication");
        Book savedBook3 = bookRepository.save(book3);
        System.out.println("ID:"+savedBook3.getId());


        bookRepository.findAll().forEach(b->{
            System.out.println(b.getTitle()+", "+b.getPublisher()+","+b.getIsbn());
        });
        
    }
    
    
}
