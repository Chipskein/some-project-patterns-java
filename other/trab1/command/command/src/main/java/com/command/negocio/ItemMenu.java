package com.command.negocio;

import com.command.negocio.comandos.Comando;

public class ItemMenu {
    
    private String nome;

    private String descricao;

    private Comando comando;

    public ItemMenu(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    
    }

    public ItemMenu(String nome, String descricao, Comando comando) {
        this.nome = nome;
        this.descricao = descricao;
        this.comando = comando;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Comando getComando() {
        return comando;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void setComando(Comando comando) {
        this.comando = comando;
    }

    public void click() {
        if (comando != null) {
            comando.executar();
        } else {
            System.out.println("Comando não definido.");
        }
    }
}
