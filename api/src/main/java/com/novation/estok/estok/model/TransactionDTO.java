package com.novation.estok.estok.model;

import jakarta.validation.constraints.Size;


public class TransactionDTO {

    private Long id;

    @Size(max = 255)
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

}
