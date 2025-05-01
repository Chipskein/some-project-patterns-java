package com.state;

public class ConcreteStateB implements State {
    @Override
    public void handle() {
        System.out.println("Handling request in ConcreteStateB");
    }
    
}
