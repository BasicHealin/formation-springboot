package com.maltem.recap.service;

import com.maltem.recap.dto.BookDTO;
import com.maltem.recap.exception.BookNotFoundException;
import com.maltem.recap.mapper.BookMapper;
import com.maltem.recap.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private List<BookDTO> books = new ArrayList<>();
    private  BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository=  bookRepository;
    }

    public List<BookDTO> listBooks(){
        return bookRepository.findAll()
                .stream()
                .map(e-> BookMapper.mapBookToBookDto(e))
                .collect(Collectors.toList());
    }

    public BookDTO addBook(BookDTO book){
        book.setId((long) (books.size()+1));
        books.add(book);
        return book;
    }

    public BookDTO getById(Long id ) throws Exception {
        return   books
                .stream()
                .filter(b->b.getId()==id)
                .findFirst()
                .orElseThrow(()-> new BookNotFoundException(String.format("this book id %s is not found ! ", id)));
    }

    public BookDTO update(Long id, BookDTO book) throws Exception {
        BookDTO oldBook = getById(id);
        oldBook.setLabel(book.getLabel());
        oldBook.setPrice(book.getPrice());
        return oldBook;
    }

    public void delete (Long id) throws Exception {
        books.remove(getById(id));
    }
}
