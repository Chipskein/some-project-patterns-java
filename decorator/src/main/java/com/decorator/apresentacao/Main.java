package com.decorator.apresentacao;


import com.decorator.negocio.tags.Div;
import com.decorator.negocio.tags.Tag;
import com.decorator.negocio.tags.HTML;
import com.decorator.negocio.tags.Link;
import com.decorator.negocio.tags.P;
import com.decorator.negocio.tags.Img;
import com.decorator.negocio.tags.Br;
import com.decorator.negocio.tags.CloseSection;
import com.decorator.negocio.tags.Hr;
import com.decorator.negocio.tags.Span;

public class Main {
    public static void main(String[] args) {
        Tag html = new HTML("HTML de teste");
        html = new Link(html, "Google", "http://www.google.com");
        html = new Div(html);
        html = new P(html,"Texto do parágrafo");
        html = new Img(html, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/37/African_Bush_Elephant.jpg/1200px-African_Bush_Elephant.jpg","Imagem sei la");
        html = new Br(html);
        html = new Hr(html);
        html = new Span(html,"Texto do span");

        html = new Div(html,true);
        html = new Img(html, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/37/African_Bush_Elephant.jpg/1200px-African_Bush_Elephant.jpg", "teste");
        html = new CloseSection(html);
        html = new P(html, "Texto do parágrafo 2");
        System.out.println(html.build());
    }
}