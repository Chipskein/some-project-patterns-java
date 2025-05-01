package com.template.negocio.frete;

public class Convesional extends Frete {
    public Convesional(double peso, double distancia) {
        // O valor base do frete é calculado como R$5.0 * distancia + R$1.5 *peso 5% desconto
        super(peso, distancia, 5.0*distancia+1.5*peso , 0.05);
    }
    @Override
    public double calcularTaxaPorDistancia() {
        double taxaPorDistancia = 0;
        if (getDistancia() <= 100) {
            taxaPorDistancia = 0.1;
        } else if (getDistancia() > 100 && getDistancia() <= 500) {
            taxaPorDistancia = 0.2;
        } else if (getDistancia() > 500 && getDistancia() <= 1000) {
            taxaPorDistancia = 0.3;
        } else {
            taxaPorDistancia = 0.5;
        }
        return taxaPorDistancia;
    }
    
}
