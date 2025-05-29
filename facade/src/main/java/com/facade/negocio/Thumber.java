package com.facade.negocio;

import java.awt.image.BufferedImage;

public class Thumber {
    
    private Resizer resizer = null;

    private Saver saver = null;

    public Thumber(Resizer resizer,Saver save) {
        this.resizer = resizer;
        this.saver = save;
    }

    public void thumbIt(BufferedImage data,int width, int height,int numberOfImages,String pathToSaveAll,String format) {
        if (resizer == null) {
            System.err.println("Resizer is not initialized");
            return;
        }
        if (width <= 0 || height <= 0) {
            System.err.println("Invalid dimensions for thumbnail: " + width + "x" + height);
            return;
        }
        if (data == null) {
            System.err.println("Image data is null");
            return;
        }

        for(int i=1;i<=numberOfImages;i++){
            BufferedImage thumb = resizer.resize(data, width, height);
            if (thumb == null){
                System.err.println("Failed to create thumbnail for image " + i);
                continue;
            }
            String outPath = pathToSaveAll + "/thumbnail_"+i+"."+format.toLowerCase();
            this.saver.save(outPath, format, thumb);
        };
        
    }
}
