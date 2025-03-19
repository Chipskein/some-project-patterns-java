package Personagem;

import Arma.Arma;

public abstract class Personagem {
    protected String nome;
    protected boolean morto;
    protected float vida;
    protected float forca;
    protected float sorte;
    protected Arma arma;

    public Personagem(String nome,float vida,float forca,float sorte,Arma arma) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.sorte = sorte;
        this.arma = arma;
    }
    
    
    abstract public void atacar(Personagem inimigo);

    public String getNome() {
        return nome;
    }

    public void setNome(String n) {
        nome = n;
    }

    public boolean isMorto() {
        return morto;
    }

    public void setMorto(boolean morto) {
        this.morto = morto;
    }

    public float getVida() {
        return vida;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }

    public float getForca() {
        return forca;
    }

    public void setForca(float forca) {
        this.forca = forca;
    }


    public float getSorte() {
        return sorte;
    }

    public void setSorte(float sorte) {
        this.sorte = sorte;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void computarAtaque(Personagem inimigo,Personagem atacante){
        float dano=this.arma.usar(inimigo, this);
        if(Math.abs(dano)>inimigo.getVida()) dano = inimigo.getVida();
        else dano=Math.abs(dano);
        inimigo.setVida(inimigo.getVida()-dano);
        System.out.println("Ataque bem sucedido");
        System.out.println("Vida do inimigo: "+inimigo.getVida());
        if (inimigo.getVida() <= 0) inimigo.setMorto(true);
    }


}