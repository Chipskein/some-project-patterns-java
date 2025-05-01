package com.command.negocio.comandos;

import com.command.negocio.Documento;
public class ColarComando implements Comando {

    private int posInicial;

    private Documento documento;

    public ColarComando(Documento documento,int posInicial) {
        this.documento = documento;
        this.posInicial = posInicial;
    }

    @Override
    public void executar() {
        System.out.println("Colando o documento...");
        documento.colar(posInicial);
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

}
