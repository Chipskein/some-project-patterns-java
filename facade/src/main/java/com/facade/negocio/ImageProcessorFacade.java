package com.facade.negocio;

import java.awt.image.BufferedImage;
import com.facade.negocio.enums.ImageFormat;
import com.facade.negocio.enums.Filter;
import com.facade.negocio.enums.ColorSpaceEnum;

public class ImageProcessorFacade{
    
    private Loader loader;
    
    private Saver saver;

    private Resizer resizer;

    private Thumber thumber;

    private Filterizer filterizer;

    private ColorConverter colorConverter;
    
    public ImageProcessorFacade(String filePath){
        this.loader=new Loader(filePath);
        this.saver=new Saver();
        this.resizer=new Resizer();
        this.thumber=new Thumber(this.resizer,this.saver);
        this.filterizer=new Filterizer();
        this.colorConverter=new ColorConverter();
    }

    public void loadImage(String filePath){
        try{
            if (filePath == null || filePath.isEmpty()) throw new IllegalArgumentException("File path cannot be null or empty.");
            this.loader.loadImage(filePath);
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }

    public void saveImage(String outPath,String format){
        try{
            if (format == null || format.isEmpty()) throw new IllegalArgumentException("Format cannot be null or empty.");
            ImageFormat imageFormat = ImageFormat.valueOf(format.toUpperCase());
            this.saveImage(outPath, imageFormat);
        }
        catch (Exception e) {
            System.err.println("Error saving image: " + e.getMessage());
        }
    }

    public void saveImage(String outPath){
        try{
            ImageFormat imageFormat = this.loader.getCurrentFormat();
            this.saveImage(outPath, imageFormat);
        }
        catch (Exception e) {
            System.err.println("Error saving image: " + e.getMessage());
        }
    }

    public void saveImage(String outPath,ImageFormat imageFormat){
        try{
            if (outPath == null || outPath.isEmpty()) throw new IllegalArgumentException("Output path cannot be null or empty.");
            if (this.loader.getCurrentImage() == null) throw new IllegalStateException("No image loaded to save.");
            this.saver.save(outPath,imageFormat, this.loader.getCurrentImage());
        }
        catch (Exception e) {
            System.err.println("Error saving image: " + e.getMessage());
        }
    }

    public void resize(int width,int heigth){
        try{
            if (width <= 0 || heigth <= 0) throw new IllegalArgumentException("Width and height must be greater than zero.");
            if (this.loader.getCurrentImage() == null) throw new IllegalStateException("No image loaded to resize.");
            BufferedImage newData=this.resizer.resize(this.loader.getCurrentImage(), width, heigth);
            this.loader.setCurrentImage(newData);
        } catch (Exception e) {
            System.err.println("Error resizing image: " + e.getMessage());
        }
    }

    public void thumb(int width, int heigth, String outPath, int numberOfImages) {
        try{
            if (numberOfImages <= 0) throw new IllegalArgumentException("Number of images must be greater than zero.");
            if (width <= 0 || heigth <= 0) throw new IllegalArgumentException("Width and height must be greater than zero.");
            if (outPath == null || outPath.isEmpty()) throw new IllegalArgumentException("Output path cannot be null or empty.");
            if (this.loader.getCurrentImage() == null) throw new IllegalStateException("No image loaded to create thumbnail.");
            ImageFormat imageFormat = this.loader.getCurrentFormat();
            thumber.thumbIt(this.loader.getCurrentImage(), width, heigth, numberOfImages, outPath, imageFormat);
        
        } 
        catch (Exception e) {
            System.err.println("Error creating thumbnail: " + e.getMessage());
        }
    }

    public void applyFilter(String filterName) {
        try{
            Filter filter = Filter.valueOf(filterName.toUpperCase());
            BufferedImage currentImage = this.loader.getCurrentImage();
            if (currentImage == null) throw new IllegalStateException("No image loaded to apply filter.");
            if (filter == null) throw new IllegalArgumentException("Filter not recognized: " + filterName);
            BufferedImage filteredImage = this.filterizer.applyFilter(filter, currentImage);
            if (filteredImage == null) throw new IllegalArgumentException("Failed to apply filter: " + filterName);
            this.loader.setCurrentImage(filteredImage);
        } 
        catch (Exception e) {
            System.err.println("Error applying filter: " + e.getMessage());
        }
    }

    public void convertColorSpace(ColorSpaceEnum target) {
        try {
            if (target == null) throw new IllegalArgumentException("Target color space cannot be null.");
            BufferedImage currentImage = this.loader.getCurrentImage();
            if (currentImage == null) throw new IllegalStateException("No image loaded to convert color space.");
            ColorSpaceEnum currentSpace = this.loader.getCurrentColorSpace();
            if (currentSpace == target) {
                System.out.println("Image is already in the target color space: " + target);
                return;
            }
            BufferedImage convertedImage = this.colorConverter.convert(currentImage, currentSpace, target);
            if (convertedImage == null) throw new IllegalArgumentException("Failed to convert color space to: " + target);
            this.loader.setCurrentImage(convertedImage);
            this.loader.setCurrentColorSpace(target);

        } catch (Exception e) {
            System.err.println("Error converting color space: " + e.getMessage());
        }
    }
    
}