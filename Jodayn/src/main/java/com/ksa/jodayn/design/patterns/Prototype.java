package com.ksa.jodayn.design.patterns;

abstract class Prototype implements Cloneable {
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
}

class ConcretePrototype extends Prototype {
    private String field;

    public void setField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
