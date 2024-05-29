package com.ksa.jodayn.design.patterns;

interface Implementor {
    void operationImpl();
}

class ConcreteImplementorA implements Implementor {
    public void operationImpl() {
        System.out.println("Implementation A");
    }
}

class ConcreteImplementorB implements Implementor {
    public void operationImpl() {
        System.out.println("Implementation B");
    }
}

abstract class Abstraction {
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void operation();
}

class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    public void operation() {
        implementor.operationImpl();
    }
}
