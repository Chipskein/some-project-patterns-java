package com.observer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testando Observer");
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");
        Observer observer3 = new ConcreteObserver("Observer 3");
        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        subject.registerObserver(observer3);
        subject.setState("Novo estado");
        System.out.println("Estado do sujeito: " + subject.getState());
        subject.removeObserver(observer3);
        subject.setState("Outro estado");

        

    }
}