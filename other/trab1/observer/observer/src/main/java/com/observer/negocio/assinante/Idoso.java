package com.observer.negocio.assinante;

import com.observer.negocio.Noticia;

public class Idoso extends PessoaFisica {
    
    private int idade;

    public Idoso(String nome, String cpf, int idade) {
        super(nome, cpf);
        if(idade<50) throw new IllegalArgumentException("Idoso deve ter mais de 50 anos");
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public void notificar(Noticia noticia) {
        System.out.println("Notificando " + this.getCpf() + " com CPF " + this.getCpf() + " e idade " + idade + ": " + noticia.getTitulo());
    }
    
}
