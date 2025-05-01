package com.decorator.negocio.tags;

public class Div extends TagDecorator {
    
    public Div(Tag tag) {
        super(tag,false);
    }
    public Div(Tag tag,Boolean hasChildren) {
        super(tag,hasChildren);
    }

    @Override
    public String build() {
        if (hasSomeChildren) {
            return tag.build().replace("<!--CHILDREN-->","<div><!--CHILDREN--></div>");
        }
        return tag.build().replace("<!--CHILDREN-->", "<div></div><!--CHILDREN-->");
    }

    @Override
    public String getTagName() {
        return "div";
    }
    
}
