package com.facade.negocio;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.facade.negocio.enums.ImageFormat;

public class Saver {
    
    public void save(String outPath,ImageFormat format,BufferedImage data){
        try{
            File outputFile = new File(outPath);
            boolean result = ImageIO.write(data,format.getformat().toLowerCase(), outputFile);
            if (result) System.out.println("Image saved successfully.");
            else System.out.println("Failed to save image (unsupported format?).");

        } catch (IOException e) {
            System.err.println("Error saving image: " + e.getMessage());
            throw new IllegalArgumentException("Error saving image: " + e.getMessage(), e);

        } catch (IllegalArgumentException e) {
            System.err.println("Invalid arguments provided for saving image: " + e.getMessage());
            throw new IllegalArgumentException("Invalid arguments provided for saving image: " + e.getMessage(), e);

        } catch (Exception e) {
            System.err.println("Unexpected error occurred while saving image: " + e.getMessage());
            throw new RuntimeException("Unexpected error occurred while saving image: " + e.getMessage(), e);
            
        }
    }

}
