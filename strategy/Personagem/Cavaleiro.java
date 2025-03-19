package Personagem;

import Arma.Arma;
public class Cavaleiro extends Personagem{
    
    public Cavaleiro(String nome, float vida, float forca, float sorte,Arma arma) {
        super(nome,vida,forca,sorte,arma);
    }
    

    @Override
    public void atacar(Personagem inimigo) {
        if(this.isMorto() || inimigo.isMorto()) return;
        if(inimigo.getSorte()>this.getSorte()){
            System.out.println("Ataque falhou");
            return;
        }
        this.computarAtaque(inimigo, this);
    }

}