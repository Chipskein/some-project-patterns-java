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
        facade.saveImage("./teste.jpg", "jpg");


        
    }
}