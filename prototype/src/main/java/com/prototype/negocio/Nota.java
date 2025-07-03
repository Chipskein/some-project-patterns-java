package com.prototype.negocio;

public class Nota implements Cloneable{
    private String titulo;
    
    private String conteudo;

    public Nota(String titulo, String conteudo){
        this.titulo = titulo;
        this.conteudo = conteudo;
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

    @Override
    public Nota clone(){
        try{
            return (Nota)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar a nota", e);
        }
        

    }
    
}
