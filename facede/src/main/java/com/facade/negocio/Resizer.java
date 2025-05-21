package com.facade.negocio;

import java.awt.image.BufferedImage;

public class Resizer {
    
    public BufferedImage resize(BufferedImage data,int width,int height){
        if(data==null) System.err.println("Image is null");
        if (width < 0)  System.err.println("negative width");
        if (height < 0)  System.err.println("negative height");
        BufferedImage scaled = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        return scaled;
    }
    
}
