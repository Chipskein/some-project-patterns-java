package com.observer.negocio;

import java.util.List;
import java.util.ArrayList;

import com.observer.negocio.assinante.Assinante;

public class Revista {
    private String nome;
    
    private String tipo;

    private List<Noticia> noticias;

    private List<Assinante> assinantes;

    public Revista(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.assinantes = new ArrayList<>();
        this.noticias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean inscrever(Assinante assinante) {
        return this.assinantes.add(assinante);
    }

    public boolean cancelar(Assinante assinante) {
        return this.assinantes.remove(assinante);
    }

    public List<Assinante> getAssinantes() {
        return assinantes;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }
    
    public void adicionarNoticia(Noticia noticia) {
        this.noticias.add(noticia);
        for (Assinante assinante : this.assinantes) {
            assinante.notificar(noticia);
        }
    }
}
