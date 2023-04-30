package com.bookservice.controller;

import com.bookservice.config.ConfigurationEnv;
import com.bookservice.dto.BookDTO;
import com.bookservice.model.Book;
import com.bookservice.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "book-service/")
public class BookController {

    private final ConfigurationEnv ENVS;

    private final BookService BOOK_SERVICE;

    public BookController(ConfigurationEnv configurationEnv, BookService bookService){
        this.ENVS = configurationEnv;
        this.BOOK_SERVICE = bookService;
    }

    @GetMapping("{id}/{currency}")
    public BookDTO findBook(

            @PathVariable(name = "id") Long id,
            @PathVariable(name = "currency") String currency

    ){

        Book book = BOOK_SERVICE.getBookById(id);

        String port = ENVS.returnPort();

        return BOOK_SERVICE.factoryBookDTO(book, port, currency);
    }

}
