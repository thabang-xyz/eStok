package com.novation.estok.estok.model;

import jakarta.validation.constraints.Size;


public class PayoutScheduleDTO {

    private Long id;

    @Size(max = 255)
    private String amount;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(final String amount) {
        this.amount = amount;
    }

}
