package com.facade.negocio.filters;

import java.awt.image.BufferedImage;
import java.awt.image.Kernel;
import java.awt.image.ConvolveOp;

public class SharpenFilter extends FilterApplier {

    @Override
    public BufferedImage apply(BufferedImage data) {
        float[] sharpenKernel = {
            0f, -1f,  0f,
           -1f,  5f, -1f,
            0f, -1f,  0f
        };
        Kernel kernel = new Kernel(3, 3, sharpenKernel);
        ConvolveOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        return op.filter(data, null);
    }
     
    
}
