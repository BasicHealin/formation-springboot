package com.maltem.recap.controller;

import com.maltem.recap.dto.BookDTO;
import com.maltem.recap.service.BookService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/books")
public class BookController {

  private BookService bookService;

  public BookController(BookService bookService){
      this.bookService = bookService;
  }

  @GetMapping("")
    public List<BookDTO> listBooks(){
        return bookService.listBooks();
    }

    @PostMapping("")
    public BookDTO addBook(@RequestBody @Validated BookDTO book){
       return bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public BookDTO update(@PathVariable Long id, @RequestBody BookDTO book) throws Exception {
      return bookService.update(id, book);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) throws Exception {
        bookService.delete(id);
    }
}
