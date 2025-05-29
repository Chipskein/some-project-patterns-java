package com.facade.negocio;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Loader {
    
    private BufferedImage currentImage = null;

    private String filePath;

    public Loader(String filePath){
        try {
            currentImage = ImageIO.read(new File(filePath));
            this.filePath=filePath;
            if (currentImage == null) {
                System.err.println("Could not load image. Unsupported format or corrupted file.");
            } else {
                System.out.println("Loaded image: " + filePath);
                System.out.println("Dimensions: " + currentImage.getWidth() + "x" + currentImage.getHeight());
                System.out.println("Image type: " + currentImage.getType());
            }
        } 
        catch (IOException e) {
            System.err.println("Error:" +e.getMessage());
        }
    }

    public BufferedImage getCurrentImage() {
        return currentImage;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setCurrentImage(BufferedImage newImage){
        this.currentImage=newImage;
    }
}
