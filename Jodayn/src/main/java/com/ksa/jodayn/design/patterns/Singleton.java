package com.ksa.jodayn.design.patterns;

import java.util.HashMap;
import java.util.Map;

public class Singleton {
    private static Map<String,Singleton> instance = new HashMap<>();

    private final String model;
    private Singleton(String model) {
        this.model = model;
    }

    public static Singleton getInstance(String model) {
        if (instance.containsKey(model)){
            return instance.get(model);
        }
        Singleton singleton = new Singleton(model);
        instance.put(model, singleton);
        return singleton;
    }
}

class Main{
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance("java");
        Singleton singleton2 = Singleton.getInstance("java");

    }
}
