package com.example.springJPA.SpringJPA.controller;

import com.example.springJPA.SpringJPA.model.Book;
import com.example.springJPA.SpringJPA.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    // post /books
    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }
    // get /books
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/latest")
    // Do te kthej nje objekt te tipit book nqs e gjejme
    // dhe do kete status HTTP (200 ose 404)
    public ResponseEntity<Book> getLatestBook(){
        return bookService.getLatestBook()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        // nese ekziston nje liber(Optional eshte present) ai mbyllet brenda klases ResponseEntity
        //dhe pergjigjet me status 200:: 0k
    }

}
