package com.facade.negocio.filters;


import java.awt.*;
import java.awt.image.BufferedImage;
public class GrayScaleFilter extends FilterApplier {

    @Override
      public BufferedImage apply(BufferedImage data) {
        if (data == null)  throw new IllegalArgumentException("Image data cannot be null");
        BufferedImage output = new BufferedImage(data.getWidth(), data.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < data.getHeight(); y++) {
            for (int x = 0; x < data.getWidth(); x++) {
                Color color = new Color(data.getRGB(x, y));
                int gray = (int)(0.299 * color.getRed() + 0.587 * color.getGreen() + 0.114 * color.getBlue());
                Color newColor = new Color(gray, gray, gray);
                output.setRGB(x, y, newColor.getRGB());
            }
        }
        return output;
    }
    
}
