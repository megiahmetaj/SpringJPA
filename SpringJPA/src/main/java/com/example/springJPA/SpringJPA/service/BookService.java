package com.example.springJPA.SpringJPA.service;

import com.example.springJPA.SpringJPA.model.Book;
import com.example.springJPA.SpringJPA.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();

    }

    public Book saveBook( Book  book){
        return bookRepository.save(book);

    }
    public Optional<Book> getLatestBook(){
        return bookRepository.findFirstByOrderByYearPublishedDesc();
    }

}
