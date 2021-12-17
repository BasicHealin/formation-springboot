package com.maltem.recap.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import type.RestError;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class BookExceptionHandler {
    @ResponseBody
    @ExceptionHandler(BookNotFoundException.class)
    public ApiError bookNotFOundException(BookNotFoundException ex){
        ApiError error = new ApiError(RestError.CODE_BOOK_NOT_FOUND, ex.getMessage());
        return error;
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> bookNotFOundException(MethodArgumentNotValidException ex){

        List<FieldError> fieldErrors = ex
                .getBindingResult().getFieldErrors().stream()
                .map(err->{
                    FieldError fieldError = new FieldError();
                    fieldError.setField((err.getField()));
                    fieldError.setRejectedValue(err.getRejectedValue()== null ? "null" : String.valueOf(err.getRejectedValue()));
                    fieldError.setMessage(err.getDefaultMessage());
                    return fieldError;
                })
                .collect(Collectors.toList());
        ApiError error = new ApiError(RestError.NOT_VALID_REQUEST, "Bad form values", fieldErrors);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST) ;
    }


}
