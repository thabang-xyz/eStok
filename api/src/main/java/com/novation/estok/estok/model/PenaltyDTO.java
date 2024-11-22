package com.novation.estok.estok.model;

import jakarta.validation.constraints.Size;


public class PenaltyDTO {

    private Long id;

    @Size(max = 255)
    private String reason;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(final String reason) {
        this.reason = reason;
    }

}
