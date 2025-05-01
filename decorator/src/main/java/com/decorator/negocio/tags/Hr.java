package com.decorator.negocio.tags;

public class Hr extends TagDecorator {

    public Hr(Tag tag) {
        super(tag, false);
    }

    @Override
    public String build() {
        return tag.build().replace("<!--CHILDREN-->", "<hr />\n<!--CHILDREN-->");
    }

    @Override
    public String getTagName() {
        return "hr";
    }
    
}
