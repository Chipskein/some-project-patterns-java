package com.facade.negocio.colorspace;

import java.awt.image.BufferedImage;
import com.facade.negocio.enums.ColorSpaceEnum;
import java.awt.Color;

public class CMYKConverter implements ColorSpaceConverter {

    @Override
    public BufferedImage convert(BufferedImage data, ColorSpaceEnum to) {
        if (to == ColorSpaceEnum.CMYK) return data;
        if (to == ColorSpaceEnum.RGB) {
            BufferedImage rgbImage = new BufferedImage(data.getWidth(), data.getHeight(), BufferedImage.TYPE_INT_RGB);
            for (int y = 0; y < data.getHeight(); y++) {
                for (int x = 0; x < data.getWidth(); x++) {
                    Color color = new Color(data.getRGB(x, y));
                    // Normalize CMYK values to [0, 1]
                    float c = 1 - color.getRed() / 255f;
                    float m = 1 - color.getGreen() / 255f;
                    float yC = 1 - color.getBlue() / 255f;
                    float k = Math.min(c, Math.min(m, yC));
                    
                    // Convert back to RGB
                    int r = (int)((1 - Math.min(1, c + k)) * 255);
                    int g = (int)((1 - Math.min(1, m + k)) * 255);
                    int b = (int)((1 - Math.min(1, yC + k)) * 255);
                    
                    rgbImage.setRGB(x, y, new Color(r, g, b).getRGB());
                }
            }
            return rgbImage;
        }
        System.err.println("Unsupported color space conversion: " + to);
        return data;
    }
    
}
