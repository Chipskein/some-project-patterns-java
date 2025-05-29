package com.adapter.negocio.nova;

public class NovaSMS implements EnviadorSMS{
    
    @Override
    public void enviarSMS(String destino, String origem, String[] msgs) throws SMSException {
        if (destino == null || origem == null || msgs == null || msgs.length == 0) throw new SMSException("Parâmetros inválidos para envio de SMS.");
        System.out.println("[Nova] Enviando SMS de " + origem + " para " + destino);
        for (String msg : msgs) {
            System.out.println("[Nova] Mensagem: " + msg);
        }
        System.out.println("[Nova] SMS enviado com sucesso!");
    }
    
}
