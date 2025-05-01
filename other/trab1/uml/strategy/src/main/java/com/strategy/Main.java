package com.strategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testando Strategy");
        Context context = new Context(new ConcreteStrategyA());
        context.doStrategy();
        
        context.setStrategy(new ConcreteStrategyB());
        context.doStrategy();

        context.setStrategy(new ConcreteStrategyA());
        context.doStrategy();
    }
}