package com.command.negocio;

public class Documento {
    
    private String texto;

    private String nome;
    
    private String caminho;
    
    private String tipo;
    
    private String tamanho;
    
    private String dataCriacao;

    private Clipboard clipboard;
    

    public Documento(String nome, String caminho, String tipo, String tamanho, String dataCriacao, Clipboard clipboard) {
        this.texto = "";
        this.nome = nome;
        this.caminho = caminho;
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.dataCriacao = dataCriacao;
        this.clipboard = clipboard;
    }

    public String getTexto() {
        return texto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTamanho() {
        return tamanho;
    }


    public String getDataCriacao() {
        return dataCriacao;
    }

    public void escrever(String texto) {
        this.texto += texto;
    }

    public void copiar(int inicio, int fim) {
        if (inicio < 0 || fim > texto.length() || inicio >= fim) {
            throw new IllegalArgumentException("Posições inválidas para copiar.");
        }
        String textoCopiado = texto.substring(inicio, fim);
        clipboard.setTexto(textoCopiado);
    }
    
    public void colar(int inicio) {
        if (inicio < 0 || inicio > texto.length()) {
            throw new IllegalArgumentException("Posição inválida para colar.");
        }
        if (clipboard.getTexto() == null || clipboard.getTexto().isEmpty()) {
            throw new IllegalStateException("Não há texto copiado na área de transferência.");
        }
        if (inicio == texto.length()) {
            this.texto += clipboard.getTexto();
            return;
        }
        String textoAntes = texto.substring(0, inicio);
        String textoDepois = texto.substring(inicio);
        this.texto = textoAntes + clipboard.getTexto() + textoDepois;
    }
}
