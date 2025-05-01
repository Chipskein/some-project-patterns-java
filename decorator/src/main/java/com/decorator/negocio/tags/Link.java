package com.decorator.negocio.tags;

public class Link extends TagDecorator {

    private String href;
    private String title;

    public Link(Tag tag, String title, String href) {
        super(tag,false);
        this.title = title;
        this.href = href;
    }

    @Override
    public String build() {
        return tag.build().replace("<!--CHILDREN-->", "<a href=\"" + href + "\">" + title + "</a>\n<!--CHILDREN-->");
    }

    @Override
    public String getTagName() {
        return "link";
    }
    
}
