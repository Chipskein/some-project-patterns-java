package com.facade.negocio;

import java.awt.image.BufferedImage;

import com.facade.negocio.enums.ImageFormat;

public class Thumber {
    
    private Resizer resizer;

    private Saver saver;

    public Thumber(Resizer resizer,Saver save) {
        this.resizer = resizer;
        this.saver = save;
    }

    public void thumbIt(BufferedImage data,int width, int height,int numberOfImages,String pathToSaveAll,ImageFormat format) {
        for(int i=1;i<=numberOfImages;i++){
            BufferedImage thumb = resizer.resize(data, width, height);
            if (thumb == null){
                System.err.println("Failed to create thumbnail for image " + i);
                continue;
            }
            String outPath = pathToSaveAll + "/thumbnail_"+i+"."+format.getformat().toLowerCase();
            this.saver.save(outPath, format, thumb);
        };
        
    }
}
