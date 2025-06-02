package com.facade.negocio.filters;

import java.awt.image.BufferedImage;

public abstract class FilterApplier {
    
    public abstract BufferedImage apply(BufferedImage data);
    
}
