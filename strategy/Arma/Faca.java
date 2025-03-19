package Arma;

import Personagem.Personagem;

public class Faca implements Arma {
    public float usar(Personagem inimigo, Personagem atacante){
        System.out.printf("Personagem %s atacou com faca\n", atacante.getNome());
        System.out.printf("Personagem %s recebeu o ataque\n", inimigo.getNome());
        float dano = 0;
        if (inimigo.getArma()==null)
            dano = atacante.getForca()-inimigo.getSorte();
        else
            dano = inimigo.getVida() - (float)Math.ceil((float)Math.random() * inimigo.getSorte());
        return dano;
    }
}