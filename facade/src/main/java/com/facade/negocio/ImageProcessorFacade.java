package com.facade.negocio;

import java.awt.image.BufferedImage;

import com.facade.negocio.enums.Color;

public class ImageProcessorFacade{
    
    private Loader loader = null;
    
    private Saver saver = null;

    private Resizer resizer = null;

    private Thumber thumber = null;

    private ColorConverter colorVerter = null;

    private Filterizer filterizer = null;
    
    public ImageProcessorFacade(String filePath){
        this.loader=new Loader(filePath);
        this.saver=new Saver();
        this.resizer=new Resizer();
        this.thumber=new Thumber(this.resizer,this.saver);
        this.colorVerter=new ColorConverter();
        this.filterizer=new Filterizer();
    }

    public void saveImage(String out_path,String format){
        this.saver.save(out_path,format, this.loader.getCurrentImage());
    }

    public void resize(int width,int heigth){
        BufferedImage newData=this.resizer.resize(this.loader.getCurrentImage(), width, heigth);
        this.loader.setCurrentImage(newData);
    }

    public void thumb(int width, int heigth, String out_path, String format, int numberOfImages) {
        thumber.thumbIt(this.loader.getCurrentImage(), width, heigth, numberOfImages, out_path, format);
    }

    public void convertColor(Color color){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void applyFilter(String filterName) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}