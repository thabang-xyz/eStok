package com.novation.estok.estok.model;

import jakarta.validation.constraints.Size;


public class AccountDTO {

    private Long id;

    @Size(max = 255)
    private String accountNumber;

    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(final String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

}
