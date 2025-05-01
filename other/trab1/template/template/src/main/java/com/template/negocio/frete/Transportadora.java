package com.template.negocio.frete;

public class Transportadora extends Frete {
    public Transportadora(double peso, double distancia) {
        // O valor base do frete é calculado como R$6.0 * distancia + R$ 1 * peso sem desconto
        super(peso, distancia, 6.0*distancia + peso, 0);
    }
    @Override
    public double calcularTaxaPorDistancia() {
        double taxaPorDistancia = 0;
        if (getDistancia() <= 150) {
            taxaPorDistancia = 0;
        } else if (getDistancia() > 150 && getDistancia() <= 1000) {
            taxaPorDistancia = 0.2;
        } else if (getDistancia() > 1000 && getDistancia() <= 5000) {
            taxaPorDistancia = 0.5;
        }
        return taxaPorDistancia;
    }
    
}
