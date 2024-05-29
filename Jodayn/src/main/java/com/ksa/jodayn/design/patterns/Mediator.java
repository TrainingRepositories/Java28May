package com.ksa.jodayn.design.patterns;

interface Mediator {
    void sendMessage(String message, Colleague colleague);
}

abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receiveMessage(String message);
}

class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    public void receiveMessage(String message) {
        System.out.println("Colleague1 received: " + message);
    }
}

class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    public void receiveMessage(String message) {
        System.out.println("Colleague2 received: " + message);
    }
}

class ConcreteMediator implements Mediator {
    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    public void setColleague1(ConcreteColleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(ConcreteColleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    public void sendMessage(String message, Colleague colleague) {
        if (colleague == colleague1) {
            colleague2.receiveMessage(message);
        } else {
            colleague1.receiveMessage(message);
        }
    }
}

// Client
class MediatorPatternDemo {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteColleague1 colleague1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);

        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        colleague1.receiveMessage("Hi from Colleague1");
        colleague2.receiveMessage("Hi from Colleague2");
    }
}
