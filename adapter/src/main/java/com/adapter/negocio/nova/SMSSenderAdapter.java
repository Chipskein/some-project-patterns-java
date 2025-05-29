package com.adapter.negocio.nova;


import com.adapter.negocio.legado.SMS;
import com.adapter.negocio.legado.SMSSender;

public class SMSSenderAdapter implements SMSSender{

    private EnviadorSMS novaOperadora;

    public SMSSenderAdapter(EnviadorSMS novaOperadora) {
        this.novaOperadora = novaOperadora;
    }

    @Override
    public boolean sendSMS(SMS sms) {
        try{
            String txt=sms.getTexto();
            String[] msgs = this.dividirTexto(txt, 160);
            novaOperadora.enviarSMS(sms.getDestino(), sms.getOrigem(), msgs);
            return true;
        } 
        catch (Exception e) {
            System.out.println("Erro ao enviar SMS: " + e.getMessage());
            return false;
        }
    }

    public String[] dividirTexto(String texto, int MAX_CHARACTERS) {
        int partsCount = (texto.length() + MAX_CHARACTERS - 1) / MAX_CHARACTERS;
        String[] mensagens = new String[partsCount];
        int c = 0;
        while (!texto.isEmpty()) {
            c++;
            int limiter = Math.min(MAX_CHARACTERS, texto.length());
            String message = texto.substring(0, limiter);
            mensagens[c - 1] = message;
            texto = texto.substring(limiter);
        }
        
        return mensagens;
    }
}
