package com.percylee.sample.rediscache.controller;

import com.percylee.sample.base.model.Book;
import com.percylee.sample.rediscache.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李鹏翔(lipengxiang1)
 * @date 2019-08-22
 **/
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{isbn}")
    public Book getOne(@PathVariable String isbn) {
        return bookService.getOne(isbn);
    }

    @PostMapping("/{isbn}")
    public Book update(@PathVariable String isbn, String name) {
        return bookService.update(isbn, name);
    }

    @DeleteMapping("/{isbn}")
    public String delete(@PathVariable String isbn) {
        bookService.delete(isbn);
        return isbn;
    }
}
