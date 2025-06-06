package com.facade.negocio;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.RenderingHints;
public class Resizer {
    
    public BufferedImage resize(BufferedImage data,int width,int height){
        BufferedImage scaled = new BufferedImage(width, height, data.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : data.getType());
        Graphics2D g2d = scaled.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(data, 0, 0, width, height, null);
        g2d.dispose();
        return scaled;
    }
    
}
