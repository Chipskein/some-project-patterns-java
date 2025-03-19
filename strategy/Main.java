import Personagem.*;
import Arma.*;
public class Main{
    public static void main(String args[]){
        System.out.println("Regras do jogo:");
        System.out.println("1. Cada personagem tem uma vida, força e sorte.");
        System.out.println("2. Cada personagem tem uma arma.");
        System.out.println("3. Cada personagem pode atacar outro personagem.");
        System.out.println("4. Cada personagem tem um padrão de falha de ataque diferente.");
        System.out.println("4.1 Cavaleiro: Se a sorte do inimigo for maior que a sorte do cavaleiro, o ataque falha.");
        System.out.println("4.2 Rainha: Nenhum ataque falha.");
        System.out.println("4.3 Rei: Se a sorte do inimigo for maior que o dobro da sorte do rei, o ataque falha.");
        System.out.println("5. Cada arma tem um efeito diferente.");
        System.out.println("5.1 Espada: Se o inimigo não tiver arma, o dano é a força do atacante vezes a vida do inimigo menos a sorte do inimigo.");
        System.out.println("5.2 Faca: Se o inimigo não tiver arma, o dano é a força do atacante menos a sorte do inimigo.");
        System.out.println("5.2.1 Faca: Se o inimigo tiver arma, o dano é a vida do inimigo menos um valor aleatório baseado na sorte do inimigo.");
        System.out.println("5.3 Arco: Se o inimigo não tiver arma, o dano é a sorte do atacante vezes a vida do inimigo menos a sorte do inimigo.");
        System.out.println("5.3.1 Arco: Se o inimigo tiver arma, o dano é a vida do inimigo menos um valor aleatório baseado na sorte do inimigo -10.");
        System.out.println("5.4 Machado: Se o inimigo não tiver arma, vida do inimigo menos a sorte do inimigo.");
        System.out.println("5.4.1 Machado: Se o inimigo tiver arma, o dano é a força do atacante.");
        System.out.println("6. O jogo acaba quando um personagem morre.");

        Arma espada = new Espada();
        Arma faca = new Faca();
        Arma arco = new Arco();
        Arma machado = new Machado();

        Personagem cavaleiro = new Cavaleiro("Cavaleiro",100,10,10,espada);
        Personagem cavaleiro2 = new Cavaleiro("Cavaleiro 2",100,10,10,espada);
        Personagem rainha = new Rainha("Rainha",100,5,20,faca);
        Personagem rei = new Rei("Rei",90,12,30,arco);

        System.out.println("Cavaleiro ataca Rainha");
        cavaleiro.atacar(rainha);

        System.out.println("Rainha ataca Cavaleiro");
        rainha.atacar(cavaleiro);

        System.out.println("Cavaleiro ataca Cavaleiro 2");
        cavaleiro.atacar(cavaleiro2);
        
        cavaleiro.setArma(machado);
        System.out.println("Cavaleiro ataca Cavaleiro 2");
        cavaleiro.atacar(cavaleiro2);

        cavaleiro2.setArma(faca);
        System.out.println("Cavaleiro 2 ataca Cavaleiro");
        cavaleiro2.atacar(cavaleiro);

        System.out.println("Cavaleiro recebeu benças de Deus");
        cavaleiro.setSorte(1500);

        System.out.println("Cavaleiro ataca Cavaleiro 2");
        cavaleiro.setArma(arco);
        cavaleiro.atacar(cavaleiro2);

        rainha.setArma(arco);
        System.out.println("Rainha ataca Cavaleiro");
        rainha.atacar(cavaleiro);
        
        System.out.println("Rei ataca Cavaleiro2");
        rei.setArma(machado);
        rei.atacar(cavaleiro2);
    }
}