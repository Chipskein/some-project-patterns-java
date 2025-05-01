package com.template;

public abstract class SuperClasse {
    
    public abstract void metodoGancho();

    public final void metodoPrinciapl() {
        System.out.println("Método concreto da superclasse");
        metodoGancho();
    }
    
}
