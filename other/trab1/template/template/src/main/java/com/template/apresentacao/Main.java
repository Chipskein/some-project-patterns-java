package com.template.apresentacao;
import com.template.negocio.frete.Convesional;
import com.template.negocio.frete.Frete;
import com.template.negocio.frete.Sedex;
import com.template.negocio.frete.Transportadora;
public class Main {
    public static void main(String[] args) {
        System.out.println("Testando Frete");
        
        Frete frete1 = new Sedex(1000, 2000);
        System.out.println("Frete Sedex: " + frete1.calcularFrete());
        
        Frete frete2 = new Convesional(1000, 2000);
        System.out.println("Frete Convesional: " + frete2.calcularFrete());
        
        Frete frete3 = new Transportadora(1000, 2000);
        System.out.println("Frete Transportadora: " + frete3.calcularFrete());

    }
}