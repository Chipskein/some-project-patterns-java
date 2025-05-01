package com.command.negocio.comandos;

import com.command.negocio.Documento;
public class CopiarComando implements Comando {

    private Documento documento;

    private int posicaoInicial;

    private int posicaoFinal;

    public CopiarComando(Documento documento,int posicaoInicial, int posicaoFinal) {
        this.documento = documento;
        this.posicaoInicial = posicaoInicial;
        this.posicaoFinal = posicaoFinal;
    }

    @Override
    public void executar() {
        System.out.println("Copiando o documento...");
        documento.copiar(posicaoInicial, posicaoFinal);
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
    
}
