package com.maltem.recap.mapper;

import com.maltem.recap.domaine.Book;
import com.maltem.recap.dto.BookDTO;

public class BookMapper {
    public static BookDTO mapBookToBookDto(Book book){

        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setLabel(book.getLabel());
        bookDTO.setPrice(book.getPrice());
        return bookDTO;

    }
}
