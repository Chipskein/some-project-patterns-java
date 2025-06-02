package com.facade.negocio;


import java.awt.image.BufferedImage;
import com.facade.negocio.enums.Filter;
import com.facade.negocio.filters.*;
import java.util.HashMap;
public class Filterizer {
    
    private HashMap<Filter,FilterApplier> map;

    public Filterizer() {
        map = new HashMap<>();
        map.put(Filter.GRAY, new GrayScaleFilter());
        map.put(Filter.SHARPEN, new SharpenFilter());
        map.put(Filter.NEGATIVE, new NegativeFilter());
        map.put(Filter.BLUR, new BlurFilter());
    }

    public BufferedImage applyFilter(Filter filter, BufferedImage image) {
        FilterApplier applier = map.get(filter);
        if (applier == null) throw new IllegalArgumentException("Filter not supported: " + filter);
        BufferedImage result = applier.apply(image);
        return result;
    }
}
