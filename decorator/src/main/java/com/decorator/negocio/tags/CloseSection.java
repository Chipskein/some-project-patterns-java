package com.decorator.negocio.tags;

public class CloseSection  extends TagDecorator {

    public CloseSection(Tag tag) {
        super(tag, false);
    }

    @Override
    public String build() {
        return tag.build().replace("<!--CHILDREN-->","").replace("</body>","<!--CHILDREN--></body>");
    }

    @Override
    public String getTagName() {
        return "internal not a tag";
    }
}
