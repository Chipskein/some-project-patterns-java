package com.proxy.negocio;

public class GarageSistema implements Sistema{

    @Override
    public void manobrar(Empregado e,Carro c) {
        c.manobrar(e);
    }
    
}
