package com.bookservice.controller;

import com.bookservice.config.ConfigurationEnv;
import com.bookservice.dto.BookDTO;
import com.bookservice.model.Book;
import com.bookservice.response.Cambio;
import com.bookservice.service.BookService;
import com.bookservice.service.ResponseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "book-service/")
public class BookController {

    private final ConfigurationEnv ENVS;

    private final BookService BOOK_SERVICE;

    private final ResponseService RESPONSE_SERVICE;

    public BookController(ConfigurationEnv configurationEnv, BookService bookService, ResponseService responseService){
        this.ENVS = configurationEnv;
        this.BOOK_SERVICE = bookService;
        this.RESPONSE_SERVICE = responseService;
    }

    @GetMapping("{id}/{currency}")
    public BookDTO findBook(

            @PathVariable(name = "id") Long id,
            @PathVariable(name = "currency") String currency

    ){

        Book book = BOOK_SERVICE.getBookById(id);

        String port = ENVS.returnPort();

        Cambio cambio = RESPONSE_SERVICE.retornaCambio(currency, book.getPrice());

        return BOOK_SERVICE.factoryBookDTO(book, currency, port, cambio.getConvertedValue());
    }

}
