package com.strategy.negocio.produto.promocao;

public class Regular implements Promocao {
    
    private double desconto;

    private double descontoExtra;

    public Regular(double descontoExtra) {
        this.desconto = 0.1;
        this.descontoExtra = descontoExtra;
    }
    public Regular(double desconto,double descontoExtra) {
        this.desconto = desconto;
        this.descontoExtra = descontoExtra;
    }
    
    @Override
    public double Descontar(double preco) {
        return preco - (preco * desconto) - (preco * descontoExtra);
    }
}
