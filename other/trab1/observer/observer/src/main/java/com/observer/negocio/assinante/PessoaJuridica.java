package com.observer.negocio.assinante;

import com.observer.negocio.Noticia;

public class PessoaJuridica implements Assinante {
    
    private String nome;
    
    private String cnpj;

    public PessoaJuridica(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public void notificar(Noticia noticia) {
        System.out.println("Notificando " + nome + " com CNPJ " + cnpj + ": " + noticia.getTitulo());
    }
    
}
