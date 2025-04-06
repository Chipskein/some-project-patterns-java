import controle.Joystick;

import jogo.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Cria JoyStick");
        var controle=new Joystick();
        
        System.out.println("Testando Corrida");
        var corrida=new JogoCorrida();
        controle.setJogo(corrida);
        controle.A();
        controle.B();
        
        System.out.println("Testando Futebol");
        var futebol=new JogoFutebol();
        controle.setJogo(futebol);
        controle.A();
        controle.B();

        System.out.println("Testando Luta");
        var luta=new JogoLuta();
        controle.setJogo(luta);
        controle.A();
        controle.B();

    }
}
