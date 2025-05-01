package com.decorator.negocio.tags;

public class P extends TagDecorator {

    private String texto;

    public P(Tag tag, String texto) {
        super(tag, false);
        this.texto = texto;
    }

    @Override
    public String build() {
        return tag.build().replace("<!--CHILDREN-->", "<p>" + texto + "</p>\n<!--CHILDREN-->");
    }

    @Override
    public String getTagName() {
        return "p";
    }
    
}
