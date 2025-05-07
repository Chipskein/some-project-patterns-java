package com.proxy.negocio;

import java.time.LocalDate;

public class Empregado {
    
    private String nome;

    private LocalDate data_nascimento;

    private String cnh;
    

    public Empregado(String nome, LocalDate data_nascimento, String cnh) {
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.cnh = cnh;
    }

    public Empregado(String nome, LocalDate data_nascimento) {
        this.nome = nome;
        this.data_nascimento = data_nascimento;
    }

    public int calcularIdade(){
        return LocalDate.now().getYear()-data_nascimento.getYear();
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
    

}
