package com.facade.apresentacao;
import java.net.URL;

import com.facade.negocio.ImageProcessorFacade;
public class Main {
    public static void main(String[] args) {
        URL resource = Main.class.getClassLoader().getResource("teste1.jpeg");
        if (resource != null) {
            System.out.println(resource.getPath());
        } else {
            System.out.println("Resource not found!");
            System.exit(1);
        }
        ImageProcessorFacade facade = new ImageProcessorFacade(resource.getPath());
        facade.saveImage("./testando_rescrever.png","png");
    }
}