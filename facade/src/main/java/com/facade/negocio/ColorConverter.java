package com.facade.negocio;


import java.awt.image.BufferedImage;
import java.util.HashMap;
import com.facade.negocio.enums.ColorSpaceEnum;

import com.facade.negocio.colorspace.ColorSpaceConverter;
import com.facade.negocio.colorspace.RGBConverter;
import com.facade.negocio.colorspace.CMYKConverter;
public class ColorConverter {
    
    private HashMap<ColorSpaceEnum,ColorSpaceConverter> convertersMap;

    public ColorConverter() {
        convertersMap = new HashMap<>();
        convertersMap.put(ColorSpaceEnum.RGB, new RGBConverter());
        convertersMap.put(ColorSpaceEnum.CMYK, new CMYKConverter());
    }

    public BufferedImage convert(BufferedImage data, ColorSpaceEnum from, ColorSpaceEnum to) {
        ColorSpaceConverter converter = convertersMap.get(from);
        if (converter == null) {
            System.err.println("Unsupported color space conversion: " + from);
            return null;
        }
        return converter.convert(data, to);
    }

    

}
