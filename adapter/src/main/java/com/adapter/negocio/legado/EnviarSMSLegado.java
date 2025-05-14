package com.adapter.negocio.legado;

public class EnviarSMSLegado implements SMSSender {

    private int MAX_CHARACTERS = 160;

    @Override
    public boolean sendSMS(SMS sms) {
        System.out.println("[SISTEMA LEGADO] Enviando SMS");
        
        if(sms==null){
            System.out.println("[SISTEMA LEGADO] SMS NULL");
            return false;
        }
        
        if(sms.getDestino()==null || sms.getDestino().isEmpty()){
            System.out.println("[SISTEMA LEGADO] SMS Destino inválido");
            return false;
        }
        
        if(sms.getOrigem()==null || sms.getOrigem().isEmpty()){
            System.out.println("[SISTEMA LEGADO] SMS Origem inválido");
            return false;
        }

        if(sms.getTexto()==null || sms.getTexto().isEmpty()){
            System.out.println("[SISTEMA LEGADO] SMS Texto inválido");
            return false;
        }

        int sent=0;
        int msgLength=sms.getTexto().length();
        System.out.println("[SISTEMA LEGADO] Número de characters totais: "+msgLength);
        while(!sms.getTexto().isEmpty()){
            sent++;
            
            int limiter=MAX_CHARACTERS;
            if(sms.getTexto().length() < MAX_CHARACTERS) 
                limiter = sms.getTexto().length();

            String message=sms.getTexto().substring(0,limiter);
            sms.setTexto(sms.getTexto().substring(message.length()));
            System.out.println("[SISTEMA LEGADO] SMS Enviado "+sent);
            System.out.println("[SISTEMA LEGADO] SMS Message "+message);
        }
        
        return true;

    }
    
}
