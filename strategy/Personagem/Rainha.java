package Personagem;

import Arma.Arma;

public class Rainha extends Personagem{
    
    public Rainha(String nome, float vida, float forca, float sorte,Arma arma) {
        super(nome,vida,forca,sorte,arma);
    }

    @Override
    public void atacar(Personagem inimigo) {
        if(this.isMorto() || inimigo.isMorto()) return;
        this.computarAtaque(inimigo, this);
    }


}