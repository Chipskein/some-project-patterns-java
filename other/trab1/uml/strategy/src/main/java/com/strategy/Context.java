package com.strategy;

public class Context {
    
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doStrategy() {
        if (strategy == null) throw new IllegalStateException("Strategy not set");
        strategy.execute();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    
}
