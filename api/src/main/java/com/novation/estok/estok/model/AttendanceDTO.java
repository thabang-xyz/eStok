package com.novation.estok.estok.model;

import jakarta.validation.constraints.Size;


public class AttendanceDTO {

    private Long id;

    @Size(max = 255)
    private String present;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(final String present) {
        this.present = present;
    }

}
