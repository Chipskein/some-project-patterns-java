package com.facade.negocio.enums;

public enum ColorSpaceEnum {
    RGB("RGB"),
    CMYK("CMYK");

    private final String colorSpace;

    ColorSpaceEnum(String colorSpace) {
        this.colorSpace = colorSpace.toUpperCase();
    }

    public String getColorSpace() {
        return colorSpace.toUpperCase();
    }
}
