package com.facade.negocio;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Resizer {
    
    public BufferedImage resize(BufferedImage data,int width,int height){
        if(data==null){
            System.err.println("Image is null");
            return data;
        }
        if (width <= 0) {
            System.err.println("negative width");
            return data;
        }
        if (height <= 0){
            System.err.println("negative height");
            return data;
        }  
        BufferedImage scaled = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = scaled.createGraphics();
        g2d.drawImage(data.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
        g2d.dispose(); 
        return scaled;
    }
    
}
