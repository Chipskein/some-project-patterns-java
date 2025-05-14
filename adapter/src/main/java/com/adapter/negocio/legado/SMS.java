package com.adapter.negocio.legado;

public class SMS {
    
    private String origem;
    
    private String destino;

    private String texto;

    public SMS(String origem, String destino, String texto) {
        this.origem = origem;
        this.destino = destino;
        this.texto = texto;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
