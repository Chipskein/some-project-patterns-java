package com.observer.negocio.assinante;

import com.observer.negocio.Noticia;

public class PessoaFisica implements Assinante {
    
    private String nome;
    
    private String cpf;

    public PessoaFisica(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void notificar(Noticia noticia) {
        System.out.println("Notificando " + nome + " com CPF " + cpf + ": " + noticia.getTitulo());
    }
    
}
