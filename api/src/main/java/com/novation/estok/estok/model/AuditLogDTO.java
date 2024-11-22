package com.novation.estok.estok.model;

import jakarta.validation.constraints.Size;


public class AuditLogDTO {

    private Long id;

    @Size(max = 255)
    private String action;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(final String action) {
        this.action = action;
    }

}
