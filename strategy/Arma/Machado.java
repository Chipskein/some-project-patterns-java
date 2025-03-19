package Arma;

import Personagem.Personagem;

public class Machado implements Arma {
    public float usar(Personagem inimigo, Personagem atacante){
        System.out.printf("Personagem %s atacou com machado\n", atacante.getNome());
        System.out.printf("Personagem %s recebeu o ataque\n", inimigo.getNome());
        float dano = 0;
        if (inimigo.getArma()==null)
            dano = inimigo.getVida() - inimigo.getSorte();
         else
            dano = atacante.getForca();
        return dano;
    }
}