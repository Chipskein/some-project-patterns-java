package com.state;

public class ConcreteStateA implements State {
    @Override
    public void handle() {
        System.out.println("Handling request in ConcreteStateA");
    }
    
}
