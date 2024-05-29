package com.ksa.jodayn.design.patterns;

 class MyProduct {
    private String partA;
    private String partB;

    public void setPartA(String partA) {
        this.partA = partA;
    }
    public void setPartB(String partB) {
        this.partB = partB;
    }
}

abstract class Builder {
    protected MyProduct product = new MyProduct();

    public abstract void buildPartA();
    public abstract void buildPartB();

    public MyProduct getResult() {
        return product;
    }
}

class ConcreteBuilder extends Builder {
    public void buildPartA() {
        product.setPartA("Part A");
    }
    public void buildPartB() {
        product.setPartB("Part B");
    }
}

class Director {
    public void construct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}
