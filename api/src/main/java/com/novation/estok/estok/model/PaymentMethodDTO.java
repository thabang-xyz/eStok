package com.novation.estok.estok.model;

import jakarta.validation.constraints.Size;


public class PaymentMethodDTO {

    private Long id;

    @Size(max = 255)
    private String methodName;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(final String methodName) {
        this.methodName = methodName;
    }

}
