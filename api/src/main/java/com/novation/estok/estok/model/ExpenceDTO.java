package com.novation.estok.estok.model;

import jakarta.validation.constraints.Size;


public class ExpenceDTO {

    private Long id;

    @Size(max = 255)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

}
