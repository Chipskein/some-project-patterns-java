package maquina.estados;

import maquina.MaquinaGoma;

public class LiberandoGoma implements Estado{
    private MaquinaGoma maquina;

    public LiberandoGoma(MaquinaGoma maquina) {
        System.out.println("Goma sendo liberada.");
        this.maquina=maquina;
    }


    @Override
    public Estado ejetarMoeda(Estado e) {
        return this;
    }

    @Override
    public Estado entregarGoma(Estado e) {
        if (this.maquina.getGomas()>0){
            System.out.println("Goma liberada.");
            int restantes=this.maquina.getGomas()-1;
            System.out.println("Gomas restantes: "+restantes);
            this.maquina.setGomas(restantes);
            if (restantes == 0){
                System.out.println("Gomas esgotadas.");
                return new SemGoma(maquina);
            }
            else return new AguardandoMoeda(maquina);
        }
        else{
            System.out.println("Gomas esgotadas.");
            return new SemGoma(maquina);
        }
    }

    @Override
    public Estado inserirMoeda(Estado e) {
        return this;
    }

    @Override
    public Estado puxarAlavanca(Estado e) {
        return this;
    }

}