package com.facade.negocio.enums;

public enum ImageFormat {
    
    PNG("PNG"),
    BMP("BMP"),
    JPEG("JPEG"),
    JPG("JPG");

    private final String format;

    ImageFormat(String format) {
        this.format = format.toUpperCase();
    }

    public String getformat() {
        return format.toUpperCase();
    }
}