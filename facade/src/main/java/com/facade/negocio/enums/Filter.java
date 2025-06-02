package com.facade.negocio.enums;

public enum Filter {
    
    GRAY("GRAYSCALE"),
    SHARPEN("SHARPEN"),
    BLUR("BLUR"),
    NEGATIVE("NEGATIVE");

    private final String filterName;

    Filter(String filterName) {
        this.filterName = filterName.toUpperCase();
    }

    public String getFilterName() {
        return filterName.toUpperCase();
    }
}