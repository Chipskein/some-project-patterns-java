public class Joystick {
    
    private Jogo jogo;

    public void A(){
        this.jogo.pressionaA();
    }
    
    public void B(){
        this.jogo.pressionaB();
    }

    public void setJogo(Jogo jogo){
        this.jogo=jogo;
    }

}
