package maquina.estados;

import maquina.MaquinaGoma;

public class AguardandoMoeda implements Estado {
    private MaquinaGoma maquina;
    
    public AguardandoMoeda(MaquinaGoma maquina) {
        System.out.println("Aguardando moeda.");
        this.maquina = maquina;
    }

    @Override
    public Estado ejetarMoeda(Estado e) {
        return this;
    }

    @Override
    public Estado entregarGoma(Estado e) {
        return this;
    }

    @Override
    public Estado inserirMoeda(Estado e) {
        System.out.println("Moeda inserida!");
        int moedas = this.maquina.getMoedas() + 1;
        this.maquina.setMoedas(moedas);
        return new AguardandoAlavanca(maquina);
    }

    @Override
    public Estado puxarAlavanca(Estado e) {
        return this;
    }
}