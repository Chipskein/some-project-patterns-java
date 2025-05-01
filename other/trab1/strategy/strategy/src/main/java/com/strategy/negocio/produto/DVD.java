package com.strategy.negocio.produto;

public class DVD extends Produto {

    private String diretor;
    private String genero;

    public DVD(String nome, double preco, String diretor, String genero) {
        super(nome, preco, null);
        this.diretor = diretor;
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
