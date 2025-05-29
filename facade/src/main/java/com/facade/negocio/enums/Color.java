package com.facade.negocio.enums;

public enum Color {
    RGB("RGB"),
    CMYK("CMYK");

    private final String colorSpace;

    Color(String colorSpace) {
        this.colorSpace = colorSpace;
    }

    public String getColorSpace() {
        return colorSpace;
    }
}
