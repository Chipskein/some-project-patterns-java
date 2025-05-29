package com.facade.negocio;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Loader {
    
    private BufferedImage currentImage = null;

    private String file_path;

    public Loader(String file_path){
        try {
            currentImage = ImageIO.read(new File(file_path));
            this.file_path=file_path;
        } catch (IOException e) {
            System.err.println("Error:" +e.getMessage());
        }
    }

    public BufferedImage getCurrentImage() {
        return currentImage;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setCurrentImage(BufferedImage newImage){
        this.currentImage=newImage;
    }
}
