package com.strategy.negocio.produto.promocao;

public class Liquidacao implements Promocao {

    private double desconto;

    public Liquidacao() {
        this.desconto = 0.3;
    }

    @Override
    public double Descontar(double preco) {
        return preco - (preco * desconto);
    }
}
