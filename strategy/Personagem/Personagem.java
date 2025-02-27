package Personagem;

public abstract class Personagem{
    protected String nome;
    protected boolean morto;
    protected float vida;
    protected float forca;
    protected float destreza;
    protected float agilidade;
    protected float sorte;

    protected ComportamentoAtaque comportamentoAtaque;
    
    abstract public void atacar(Personagem inimigo){}
    
    abstract public void receberDano(ComportamentoAtaque comportamentoAtaqueInimigo,Personagem inimigo){}
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String n){
        nome=n;
    }

    public ComportamentoAtaque getAtaque(){
        return comportamentoAtaque;
    }

    public void setAtaque(ComportamentoAtaque ca){
        comportamentoAtaque=ca;
    }

}