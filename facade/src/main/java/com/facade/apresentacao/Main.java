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
        
        // Testando redimensionamento
        facade.resize(300, 300);
        
        //Testando Filtros
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
        
        
        // Testando thumbnails
        facade.loadImage("./teste-resize.jpg");
        facade.thumb(100, 100, ".", 3);

        // Testando conversão de espaço de cores
        facade.loadImage(resource.getPath());
        facade.convertColorSpace("cmyk");
        facade.saveImage("./teste-convert-cmyk.jpg");

        facade.convertColorSpace("rgb");
        facade.saveImage("./teste-convert-rgb.jpg");
        
        
        //Testando outros formatos de imagem
        
        //BMP
        resource = Main.class.getClassLoader().getResource("teste4.bmp");
        if (resource == null) {
            System.out.println("Resource not found!");
            System.exit(1);
        }

        facade.loadImage(resource.getPath());
        facade.saveImage("./teste4.png", "png");

        //PNG
        resource = Main.class.getClassLoader().getResource("teste3.png");
        if (resource == null) {
            System.out.println("Resource not found!");
            System.exit(1);
        }

        facade.loadImage(resource.getPath());
        facade.saveImage("./teste3.jpg", "jpg");

        //JPEG
        resource = Main.class.getClassLoader().getResource("teste2.jpeg");
        if (resource == null) {
            System.out.println("Resource not found!");
            System.exit(1);
        }
        facade.loadImage(resource.getPath());
        facade.saveImage("./teste2.bmp", "bmp");


        //JPEG 2
        resource = Main.class.getClassLoader().getResource("teste1.jpeg");
        if (resource == null) {
            System.out.println("Resource not found!");
            System.exit(1);
        }
        facade.loadImage(resource.getPath());
        facade.saveImage("./teste1.png", "png");






        


        





        
        


        
    }
}