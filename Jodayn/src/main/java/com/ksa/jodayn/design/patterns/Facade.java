package com.ksa.jodayn.design.patterns;

class Subsystem1 {
    public void operation1() {
        System.out.println("Subsystem1 operation1");
    }
}

class Subsystem2 {
    public void operation2() {
        System.out.println("Subsystem2 operation2");
    }
}

class Facade {
    private Subsystem1 subsystem1 = new Subsystem1();
    private Subsystem2 subsystem2 = new Subsystem2();

    public void operation() {
        subsystem1.operation1();
        subsystem2.operation2();
    }
}
