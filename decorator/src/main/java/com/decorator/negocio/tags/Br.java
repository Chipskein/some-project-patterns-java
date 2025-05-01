package com.decorator.negocio.tags;

public class Br extends TagDecorator {

    public Br(Tag tag) {
        super(tag, false);
    }

    @Override
    public String build() {
        return tag.build().replace("<!--CHILDREN-->", "<br />\n<!--CHILDREN-->");
    }

    @Override
    public String getTagName() {
        return "br";
    }
    
}
