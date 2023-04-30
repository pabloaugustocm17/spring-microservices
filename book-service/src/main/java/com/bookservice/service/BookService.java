package com.bookservice.service;

import com.bookservice.dto.BookDTO;
import com.bookservice.model.Book;
import com.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository BOOK_REPOSITORY;

    public BookService(BookRepository bookRepository){
        this.BOOK_REPOSITORY =  bookRepository;
    }

    /* Comunicação JPA */

    public Book getBookById(Long id){

        Book book = BOOK_REPOSITORY.getReferenceById(id);

        if(book == null){
            throw new RuntimeException("Book not found");
        }

        return book;

    }

    /* Utils */

    public BookDTO factoryBookDTO(Book book, String port, String currency){

        return new BookDTO(book, port, currency);

    }


}
