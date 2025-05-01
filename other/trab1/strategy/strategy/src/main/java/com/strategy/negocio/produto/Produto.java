package com.strategy.negocio.produto;

import com.strategy.negocio.produto.promocao.Promocao;

public abstract class Produto {

    private String nome;
    
    private double preco;

    private Promocao P;
    
    public Produto(String nome, double preco, Promocao P) {
        this.nome = nome;
        this.preco = preco;
        this.P = P;
    }

    public void setPromocao(Promocao P) {
        this.P = P;
    }

    public Promocao getPromocao() {
        return P;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double calPreco() {
        if (P == null) return preco;
        return P.Descontar(preco);
    }
}