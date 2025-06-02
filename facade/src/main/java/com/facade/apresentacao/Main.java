package com.facade.apresentacao;
import java.net.URL;

import com.facade.negocio.ImageProcessorFacade;
public class Main {
    public static void main(String[] args) {
        URL resource = Main.class.getClassLoader().getResource("teste_cmyk.jpg");
        if (resource != null) {
            System.out.println(resource.getPath());
        } else {
            System.out.println("Resource not found!");
            System.exit(1);
        }

        ImageProcessorFacade facade = new ImageProcessorFacade(resource.getPath());
        
        facade.resize(300, 300);
        
        facade.saveImage("./teste-resize.jpg", "jpg");
        facade.applyFilter("NEGATIVE");
        facade.saveImage("./teste-filter-negativo.jpg", "jpg");
        
        facade.loadImage("./teste-resize.jpg");
        facade.applyFilter("BLUR");
        facade.saveImage("./teste-filter-blur.jpg", "jpg");

        facade.loadImage("./teste-resize.jpg");
        facade.applyFilter("SHARPEN");
        facade.saveImage("./teste-filter-sharpen.jpg", "jpg");

        facade.loadImage("./teste-resize.jpg");
        facade.applyFilter("GRAY");
        facade.saveImage("./teste-filter-grayscale.jpg", "jpg");
        
        
        facade.loadImage("./teste-resize.jpg");

        facade.thumb(100, 100, ".", 3);

        facade.loadImage(resource.getPath());
        
        facade.convertColorSpace("cmyk");
        facade.saveImage("./teste-convert-cmyk.jpg");

        facade.convertColorSpace("rgb");
        facade.saveImage("./teste-convert-rgb.jpg");
        
        

        


        





        
        


        
    }
}