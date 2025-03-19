package Arma;

import Personagem.Personagem;

public class Espada implements Arma {
    public float usar(Personagem inimigo, Personagem atacante){
        System.out.printf("Personagem %s atacou com espada\n", atacante.getNome());
        System.out.printf("Personagem %s recebeu o ataque\n", inimigo.getNome());
        float dano = 0;
        if (inimigo.getArma()==null)
            dano = atacante.getForca()*(inimigo.getVida() - inimigo.getSorte());
        else if(inimigo.getArma() instanceof Espada){
            if (inimigo.getForca()==atacante.getForca()) dano=1;
            else dano = inimigo.getSorte();
        }
        else dano = atacante.getForca();
        return dano;
    }
}