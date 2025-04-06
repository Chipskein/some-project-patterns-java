
package maquina;

import maquina.estados.*;

public class MaquinaGoma{
    private int gomas;
    private int moedas;
    
    private Estado estadoAtual;

    public MaquinaGoma(int gomas,int moedas){
        this.gomas = gomas;
        this.moedas = moedas;
        this.estadoAtual = null;
    }

    public void ligar(){
        this.estadoAtual = new AguardandoMoeda(this);
    }
    

    public void setEstado(Estado estado){
        this.estadoAtual = estado;
    }

    public void inserirMoeda(){
        this.estadoAtual=this.estadoAtual.inserirMoeda(this.estadoAtual);
    }
    public void puxarAlavanca(){
        this.estadoAtual=this.estadoAtual.puxarAlavanca(this.estadoAtual);
        this.entregarGoma();

    }
    public void ejetarMoeda(){
        this.estadoAtual=this.estadoAtual.ejetarMoeda(this.estadoAtual);
    }
    
    public void entregarGoma(){
        this.estadoAtual=this.estadoAtual.entregarGoma(this.estadoAtual);
    }

    public void setGomas(int gomas){
        this.gomas = gomas;
    }

    public void setMoedas(int moedas){
        this.moedas = moedas;
    }
    
    public int getGomas(){
        return this.gomas;
    }

    public int getMoedas(){
        return this.moedas;
    }

}