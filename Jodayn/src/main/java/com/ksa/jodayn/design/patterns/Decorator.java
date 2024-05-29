package com.ksa.jodayn.design.patterns;

interface MyComponent {
    void operation();
}

class ConcreteComponent implements MyComponent {
    public void operation() {
        System.out.println("ConcreteComponent");
    }
}

abstract class Decorator implements MyComponent {
    protected MyComponent component;

    public Decorator(MyComponent component) {
        this.component = component;
    }

    public void operation() {
        component.operation();
    }
}

class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(MyComponent component) {
        super(component);
    }

    public void operation() {
        super.operation();
        System.out.println("ConcreteDecorator");
    }
}
