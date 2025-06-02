package com.facade.negocio.colorspace;

import java.awt.image.BufferedImage;
import com.facade.negocio.enums.ColorSpaceEnum;

public interface ColorSpaceConverter {
    public BufferedImage convert(BufferedImage data,ColorSpaceEnum To);
}
