package com.template.negocio.frete;

public class Sedex extends Frete {
    public Sedex(double peso, double distancia) {
        // O valor base do frete é calculado como R$2.0 * distancia + $R1.5 * peso sem desconto
        super(peso, distancia, 2.0*distancia + 1.5 * peso, 0);
    }
    @Override
    public double calcularTaxaPorDistancia() {
        double taxaPorDistancia = 0;
        if (getDistancia() <= 50) {
            taxaPorDistancia = 0.1;
        } else if (getDistancia() > 100 && getDistancia() <= 1000) {
            taxaPorDistancia = 0.5;
        } else if (getDistancia() > 1000 && getDistancia() <= 5000) {
            taxaPorDistancia = 0.7;
        } else {
            taxaPorDistancia = 1.0;
        }
        return taxaPorDistancia;
    }
    
}
