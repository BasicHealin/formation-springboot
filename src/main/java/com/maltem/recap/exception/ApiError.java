package com.maltem.recap.exception;

import type.RestError;

import java.util.ArrayList;
import java.util.List;

public class ApiError {
    private RestError code;
    private String message;
    private List<FieldError> formErrors = new ArrayList<>();

    public ApiError(RestError code, String message, List<FieldError> formErrors) {
        this.code = code;
        this.message = message;
        this.formErrors = formErrors;
    }

    public List<FieldError> getFormErrors() {
        return formErrors;
    }

    public void setFormErrors(List<FieldError> formErrors) {
        this.formErrors = formErrors;
    }

    public ApiError(RestError code, String message) {
        this.code = code;
        this.message = message;
    }

    public RestError getCode() {
        return code;
    }

    public void setCode(RestError code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
