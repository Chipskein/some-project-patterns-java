package com.observer.negocio;

import java.util.Date;

public class Noticia {
    String titulo;

    String conteudo;

    Date data;

    public Noticia(String titulo, String conteudo, Date data) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.data = data;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getConteudo() {
        return conteudo;
    }
    
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
    public Date getData() {
        return data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }

}
