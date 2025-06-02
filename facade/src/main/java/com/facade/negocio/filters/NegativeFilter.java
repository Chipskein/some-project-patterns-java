package com.facade.negocio.filters;

import java.awt.image.BufferedImage;
import java.awt.Color;

public class NegativeFilter extends FilterApplier{

    @Override
    public BufferedImage apply(BufferedImage data) {
        BufferedImage output = new BufferedImage(data.getWidth(), data.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < data.getHeight(); y++) {
            for (int x = 0; x < data.getWidth(); x++) {
                Color c = new Color(data.getRGB(x, y));
                int r = 255 - c.getRed();
                int g = 255 - c.getGreen();
                int b = 255 - c.getBlue();
                Color newColor = new Color(r, g, b);
                output.setRGB(x, y, newColor.getRGB());
            }
        }
        return output;
    }
    
}
