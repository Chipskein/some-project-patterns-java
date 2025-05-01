package com.decorator.negocio.tags;

public class Img extends TagDecorator {

    private String src;
    private String alt;

    public Img(Tag tag, String src, String alt) {
        super(tag, false);
        this.src = src;
        this.alt = alt;
    }

    @Override
    public String build() {
        return tag.build().replace("<!--CHILDREN-->", "<img src=\"" + src + "\" alt=\"" + alt + "\" />\n<!--CHILDREN-->");
    }

    @Override
    public String getTagName() {
        return "img";
    }
    
}
