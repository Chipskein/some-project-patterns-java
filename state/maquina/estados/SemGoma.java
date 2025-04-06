package maquina.estados;
import maquina.MaquinaGoma;

public class SemGoma implements Estado{
    private MaquinaGoma maquina;
    
    public SemGoma(MaquinaGoma maquina) {
        System.out.println("Sem goma.");
        this.maquina=maquina;
    }

    @Override
    public Estado ejetarMoeda(Estado e) {
        System.out.println("Sem goma.");
        return this;
    }

    @Override
    public Estado entregarGoma(Estado e) {
        System.out.println("Sem goma.");
        return this;
    }

    @Override
    public Estado inserirMoeda(Estado e) {
        System.out.println("Sem goma.");
        return this;
    }

    @Override
    public Estado puxarAlavanca(Estado e) {
        System.out.println("Sem goma.");
        return this;
    }
    
}
