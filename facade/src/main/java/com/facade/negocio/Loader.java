package com.facade.negocio;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.facade.negocio.enums.ImageFormat;
import com.facade.negocio.enums.ColorSpaceEnum;

import java.awt.color.ColorSpace;
import java.awt.image.ColorModel;
public class Loader {
    
    private BufferedImage currentImage;

    private String filePath;

    private ImageFormat currentFormat;

    private ColorSpaceEnum currentColorSpace;

    public Loader(String filePath){
        this.filePath = filePath;
        loadImage(filePath);
    }

    public void loadImage(String filePath) {
        try {
            
            this.currentImage = ImageIO.read(new File(filePath));
            if (currentImage == null) throw new IOException("Could not load image from file: " + filePath);
            this.filePath = filePath;
            
            String ext=this.extractExtension(filePath);
            ImageFormat format = ImageFormat.valueOf(ext.toUpperCase());
            this.currentFormat = format;

            String colorSpaceStr = extractColorSpace(currentImage);
            if (colorSpaceStr == null || colorSpaceStr.isEmpty() || colorSpaceStr.equals("UNKNOWN")) {
                throw new IOException("Unsupported color space in image: " + filePath);
            }
            this.currentColorSpace = ColorSpaceEnum.valueOf(colorSpaceStr.toUpperCase());
            
            System.out.println("Loaded image: " + filePath);
            System.out.println("Dimensions: " + currentImage.getWidth() + "x" + currentImage.getHeight());
            System.out.println("Image type: " + currentImage.getType());
        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
            this.currentImage = null;
            this.filePath = null;
            this.currentFormat = null;
        }
    }

    private String extractExtension(String filePath) {
        String extension = "";
        int dotIndex = filePath.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < filePath.length() - 1) {
            extension = filePath.substring(dotIndex + 1).toLowerCase();
        }
        return extension;
    }

    private String extractColorSpace(BufferedImage image) {
        if (image == null) return "UNKNOWN";
        ColorModel colorModel = image.getColorModel();
        ColorSpace colorSpace = colorModel.getColorSpace();
        int csType = colorSpace.getType();
        switch (csType) {
            case ColorSpace.TYPE_RGB:
                return "RGB";
            case 9: 
                return "CMYK";// CMYK is not defined in standard Java; TwelveMonkeys uses type 9
            default:
                System.err.println("Unsupported color space type: " + csType);
                return "UNKNOWN";
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

    public ImageFormat getCurrentFormat() {
        return currentFormat;
    }
    
    public void setCurrentFormat(ImageFormat currentFormat) {
        this.currentFormat = currentFormat;
    }
    
    public ColorSpaceEnum getCurrentColorSpace() {
        return currentColorSpace;
    }
    
    public void setCurrentColorSpace(ColorSpaceEnum currentColorSpace) {
        this.currentColorSpace = currentColorSpace;
    }
}
