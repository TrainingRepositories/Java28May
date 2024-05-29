package com.ksa.jodayn.design.patterns;

import java.util.HashMap;
import java.util.Map;

interface Flyweight {
    void operation(String extrinsicState);
}

class ConcreteFlyweight implements Flyweight {
    private final String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    public void operation(String extrinsicState) {
        System.out.println("Intrinsic State = " + intrinsicState + ", Extrinsic State = " + extrinsicState);
    }
}

class FlyweightFactory {
    private final Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new ConcreteFlyweight(key));
        }
        return flyweights.get(key);
    }
}
