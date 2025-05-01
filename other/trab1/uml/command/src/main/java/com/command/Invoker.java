package com.command;

public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        if (command == null) {
            System.out.println("Invoker: Nenhum comando definido.");
            return;
        }
        System.out.println("Invoker: Executando o comando...");
        command.execute();
    }
}
