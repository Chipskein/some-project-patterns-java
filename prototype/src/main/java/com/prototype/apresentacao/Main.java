package com.prototype.apresentacao;


import com.prototype.negocio.Nota;
import com.prototype.negocio.RegistroNota;

public class Main {
    public static void main(String[] args) {
        RegistroNota registro = RegistroNota.getInstance();

        Nota nota1 = registro.criar("base");
        nota1.setTitulo("Minha Primeira Nota");
        nota1.setConteudo("Anotação importante sobre padrões de projeto.");

        Nota nota2 = registro.criar("copia");

        System.out.println("Nota 1: " + nota1.getTitulo() + " - " + nota1.getConteudo() + " | Hash: " + nota1.hashCode());
        System.out.println("Nota 2: " + nota2.getTitulo() + " - " + nota2.getConteudo() + " | Hash: " + nota2.hashCode());
    }
}