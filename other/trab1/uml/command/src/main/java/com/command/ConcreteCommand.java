package com.command;

public class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("ConcreteCommand: Executando o comando...");
        receiver.action();
    }
    
}
