package com.decorator.negocio.tags;

public class Span extends TagDecorator {

    private String texto;

    public Span(Tag tag, String texto) {
        super(tag, false);
        this.texto = texto;
    }

    @Override
    public String build() {
        return tag.build().replace("<!--CHILDREN-->", "<span>" + texto + "</span>\n<!--CHILDREN-->");
    }

    @Override
    public String getTagName() {
        return "span";
    }
    
}
