package com.facade.negocio;

import java.awt.image.BufferedImage;

public class ImageProcessorFacade{
    
    private Loader loader = null;
    
    private Saver saver = null;

    private Resizer resizer = null;
    
    public ImageProcessorFacade(String file_path){
        this.loader=new Loader(file_path);
        this.saver=new Saver();
        this.resizer=new Resizer();
    }

    public void saveImage(String out_path,String format){
        this.saver.save(out_path,format, this.loader.getCurrentImage());
    }

    public void resize(int width,int heigth){
        BufferedImage newData=this.resizer.resize(this.loader.getCurrentImage(), width, heigth);
        this.loader.setCurrentImage(newData);
    }
}