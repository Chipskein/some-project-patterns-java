package Personagem;

import Arma.AtaqueComportamento;

public abstract class Personagem {
    protected String nome;
    protected boolean morto;
    protected float vida;
    protected float forca;
    protected float destreza;
    protected float agilidade;
    protected float sorte;

    protected AtaqueComportamento comportamentoAtaque;

    abstract public void atacar(Personagem inimigo);

    abstract public void receberDano(AtaqueComportamento comportamentoAtaqueInimigo, Personagem inimigo);

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

    public float getDestreza() {
        return destreza;
    }

    public void setDestreza(float destreza) {
        this.destreza = destreza;
    }

    public float getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(float agilidade) {
        this.agilidade = agilidade;
    }

    public float getSorte() {
        return sorte;
    }

    public void setSorte(float sorte) {
        this.sorte = sorte;
    }

    public AtaqueComportamento getComportamentoAtaque() {
        return comportamentoAtaque;
    }

    public void setComportamentoAtaque(AtaqueComportamento comportamentoAtaque) {
        this.comportamentoAtaque = comportamentoAtaque;
    }

    public AtaqueComportamento getAtaque() {
        return comportamentoAtaque;
    }

    public void setAtaque(AtaqueComportamento ca) {
        comportamentoAtaque = ca;
    }

}