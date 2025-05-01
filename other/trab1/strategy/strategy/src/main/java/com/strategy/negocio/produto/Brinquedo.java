package com.strategy.negocio.produto;

public class Brinquedo extends Produto {

    private String faixaEtaria;
    
    private String tipoBrinquedo;

    public Brinquedo(String nome, double preco, String faixaEtaria, String tipoBrinquedo) {
        super(nome, preco, null);
        this.faixaEtaria = faixaEtaria;
        this.tipoBrinquedo = tipoBrinquedo;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getTipoBrinquedo() {
        return tipoBrinquedo;
    }

    public void setTipoBrinquedo(String tipoBrinquedo) {
        this.tipoBrinquedo = tipoBrinquedo;
    }
    
}
