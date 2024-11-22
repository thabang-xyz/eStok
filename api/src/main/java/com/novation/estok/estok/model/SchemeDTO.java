package com.novation.estok.estok.model;

import jakarta.validation.constraints.Size;


public class SchemeDTO {

    private Long id;

    @Size(max = 255)
    private String schemeName;

    @Size(max = 255)
    private String schemeDescription;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(final String schemeName) {
        this.schemeName = schemeName;
    }

    public String getSchemeDescription() {
        return schemeDescription;
    }

    public void setSchemeDescription(final String schemeDescription) {
        this.schemeDescription = schemeDescription;
    }

}
