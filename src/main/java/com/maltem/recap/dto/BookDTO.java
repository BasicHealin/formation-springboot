package com.maltem.recap.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

public class BookDTO {
    @Null(message = "id must be null")
    private Long id;

    @NotBlank(message = "label cannot be empty")
    private String label;
    private Long price;

    public BookDTO() {
        this.id = id;
        this.label = label;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
