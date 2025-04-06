import java.util.Scanner;

import maquina.MaquinaGoma;

public class Main{
    public static void main(String[] args) {
        System.out.println("Máquina de Goma!");
        MaquinaGoma maquina = new MaquinaGoma(5,0);
        maquina.ligar();
        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("1. Inserir Moeda");
            System.out.println("2. Puxar Alavanca");
            System.out.println("3. Ejetar Moeda");
            System.out.println("4. Sair");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    maquina.inserirMoeda();
                    break;
                case "2":
                    maquina.puxarAlavanca();
                    break;
                case "3":
                    maquina.ejetarMoeda();
                    break;
                case "4":
                    running = false;
                    System.out.println("Saindo da máquina de goma. Até logo!");
                    break;
                default:
                    System.out.println("Opção invalida\n");
            }
        }
        scanner.close();
    }
}