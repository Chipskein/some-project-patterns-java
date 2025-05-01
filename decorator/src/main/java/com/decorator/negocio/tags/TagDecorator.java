package com.decorator.negocio.tags;

public abstract class TagDecorator implements Tag{
    
    protected Tag tag;

    protected Boolean hasSomeChildren = false;

    public TagDecorator(Tag tag, Boolean hasSomeChildren) {
        this.tag = tag;
        this.hasSomeChildren = hasSomeChildren;
    }
}
