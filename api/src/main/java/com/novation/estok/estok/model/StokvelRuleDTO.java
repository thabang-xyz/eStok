package com.novation.estok.estok.model;

import jakarta.validation.constraints.Size;


public class StokvelRuleDTO {

    private Long id;

    @Size(max = 255)
    private String rulename;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getRulename() {
        return rulename;
    }

    public void setRulename(final String rulename) {
        this.rulename = rulename;
    }

}
