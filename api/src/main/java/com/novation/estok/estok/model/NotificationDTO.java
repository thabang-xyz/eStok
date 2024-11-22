package com.novation.estok.estok.model;

import jakarta.validation.constraints.Size;


public class NotificationDTO {

    private Long id;

    @Size(max = 255)
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

}
