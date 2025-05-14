package com.adapter.negocio;

public interface EnviadorSMS {
    
    public void enviarSMS(String destino,String origem,String[] msgs);
    
}
