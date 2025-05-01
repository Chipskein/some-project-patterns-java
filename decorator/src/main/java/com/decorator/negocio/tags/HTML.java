package com.decorator.negocio.tags;

public class HTML  implements Tag {
    
    private String title;
    
    public HTML(String title) {
        this.title = title;
    }

    public String getTagName() {
        return "html";
    }
    
    public String build() {
        return "<html><head><title>"+title +"</title></head><body><!--CHILDREN--></body></html>";
    }

    public String closeSection(){
        return "";
    };
}
