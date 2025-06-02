package com.facade.negocio.colorspace;

import java.awt.image.BufferedImage;
import com.facade.negocio.enums.ColorSpaceEnum;
import java.awt.Color;

public class RGBConverter implements ColorSpaceConverter {

    @Override
    public BufferedImage convert(BufferedImage data, ColorSpaceEnum to) {
        if (to == ColorSpaceEnum.RGB) return data;
        if (to == ColorSpaceEnum.CMYK) {
            // Simulate CMYK Color Space since Java does not support CMYK natively
            BufferedImage cmykImage = new BufferedImage(data.getWidth(),data.getHeight(),BufferedImage.TYPE_INT_RGB);
            for (int y = 0; y < data.getHeight(); y++) {
                for (int x = 0; x < data.getWidth(); x++) {
                    Color color = new Color(data.getRGB(x, y));
                    // Normalize RGB values to [0, 1]
                    float r = color.getRed() / 255f;
                    float g = color.getGreen() / 255f;
                    float b = color.getBlue() / 255f;
                    // Convert to CMY
                    float c = 1 - r;
                    float m = 1 - g;
                    float yC = 1 - b;
                    // Extract K
                    float k = Math.min(c, Math.min(m, yC));
                    // Subtract K to get pure CMY values
                    if (k < 1) {
                        c = (c - k) / (1 - k);
                        m = (m - k) / (1 - k);
                        yC = (yC - k) / (1 - k);
                    } else {
                        c = 0;
                        m = 0;
                        yC = 0;
                    }
                    
                    Color cmykColor = new Color((int)(255 * (1 - c * (1 - k) - k)),
                                                (int)(255 * (1 - m * (1 - k) - k)),
                                                (int)(255 * (1 - yC * (1 - k) - k)))
                    ;

                    cmykImage.setRGB(x, y, cmykColor.getRGB());
                }
            }

            return cmykImage;
        } 
        System.err.println("Unsupported color space conversion: " + to);
        return data;
    }
    
}
