package com.ksa.jodayn.design.patterns;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update();
}

class MySubject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

class ConcreteObserver implements Observer {
    private MySubject subject;

    public ConcreteObserver(MySubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public void update() {
        System.out.println("State changed: " + subject.getState());
    }
}

// Client
class ObserverPatternDemo {
    public static void main(String[] args) {
        MySubject subject = new MySubject();

        new ConcreteObserver(subject);
        new ConcreteObserver(subject);

        subject.setState(1);
        subject.setState(2);
    }
}
