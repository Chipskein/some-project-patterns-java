package com.proxy.negocio;

public class ProxyProtecao implements Sistema{
    
    private GarageSistema sistema;

    public ProxyProtecao(GarageSistema sistema){
        this.sistema=sistema;
    }

    public void manobrar(Empregado e,Carro c){
        if(sistema==null) throw new IllegalAccessError("Sistema é null");
        if(e==null) throw new IllegalAccessError("Empregado é null");
        if(c==null) throw new IllegalAccessError("Carro é null");

        if(e.calcularIdade()< 18){
            System.out.println("Usuario Menor de idade");
            return;
        }
        if(e.getCnh() == null || e.getCnh().isEmpty()){
            System.out.println("Não possui CNH");
            return;
        }
        sistema.manobrar(e,c);
    }
}
