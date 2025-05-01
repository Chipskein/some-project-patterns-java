package com.template.negocio.frete;

public abstract class Frete {
    private double peso;

    private double distancia;

    private double valorBaseFrete;

    private double desconto_percentual;

    public Frete(double peso, double distancia, double valorBaseFrete, double desconto_percentual) {
        this.peso = peso;
        this.distancia = distancia;
        this.valorBaseFrete = valorBaseFrete;
        this.desconto_percentual = desconto_percentual;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public double getDistancia() {
        return distancia;
    }

    public double getValorBaseFrete() {
        return valorBaseFrete;
    }

    public double getDesconto_percentual() {
        return desconto_percentual;
    }

    public abstract double calcularTaxaPorDistancia();

    public double calcularTaxaPorPeso(){
        double taxaPorPeso = 0;
        if (peso <= 50) {
            taxaPorPeso = 0.1;
        } else if (peso > 50 && peso <= 100) {
            taxaPorPeso = 0.2;
        } else if (peso > 100 && peso <= 200) {
            taxaPorPeso = 0.3;
        } else {
            taxaPorPeso = 0.5;
        }
        return taxaPorPeso;
    };
    public double calcularDescontos(){
        return (valorBaseFrete * desconto_percentual);
    };
    
    public double calcularFrete() {
        double taxaPorDistancia = calcularTaxaPorDistancia();
        double taxaPorPeso = calcularTaxaPorPeso();
        double descontos = calcularDescontos();
        double frete= valorBaseFrete + (valorBaseFrete * taxaPorDistancia) + (valorBaseFrete * taxaPorPeso) - descontos;
        return frete;
    }
}
