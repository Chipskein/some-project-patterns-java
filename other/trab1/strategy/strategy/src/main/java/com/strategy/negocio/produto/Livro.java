package com.strategy.negocio.produto;

public class Livro extends Produto {

    private String autor;
    
    private String genero;

    public Livro(String nome, double preco, String autor, String genero) {
        super(nome, preco, null);
        this.autor = autor;
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
