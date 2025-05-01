package com.strategy;

public class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing ConcreteStrategyA");
    }
    
}
