package com.facade.negocio;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.facade.negocio.enums.ImageFormat;

public class Saver {
    
    public void save(String out_path,String format,BufferedImage data){
        try{
            ImageFormat imageformat=ImageFormat.valueOf(format.toUpperCase());
            File outputFile = new File(out_path);
            boolean result = ImageIO.write(data,imageformat.toString().toLowerCase(), outputFile);
            if (result) System.out.println("Image saved successfully.");
            else System.out.println("Failed to save image (unsupported format?).");
        } catch (IOException e) {
            System.err.println("Error Saver.save: "+e.getMessage());
        }
    }

}
