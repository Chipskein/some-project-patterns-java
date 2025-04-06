package maquina.estados;

import maquina.MaquinaGoma;

class AguardandoAlavanca implements Estado {
    private MaquinaGoma maquina;

    public AguardandoAlavanca(MaquinaGoma maquina) {
        System.out.println("Moeda recebida.");
        System.out.println("Puxe a alavanca!");
        this.maquina = maquina;
    }

    @Override
    public Estado ejetarMoeda(Estado e) {
        System.out.println("Moeda devolvida.");
        int moedas = this.maquina.getMoedas() - 1;
        this.maquina.setMoedas(moedas);
        return new AguardandoMoeda(maquina);
    }

    @Override
    public Estado entregarGoma(Estado e) {
        return this;
    }

    @Override
    public Estado inserirMoeda(Estado e) {
        return this;
    }

    @Override
    public Estado puxarAlavanca(Estado e) {
        System.out.println("Alavanca puxada.");
        return new LiberandoGoma(maquina);
    }
    
}