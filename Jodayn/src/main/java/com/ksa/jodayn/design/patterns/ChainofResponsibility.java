package com.ksa.jodayn.design.patterns;

abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(int request);
}

class ConcreteHandler1 extends Handler {
    public void handleRequest(int request) {
        if (request < 10) {
            System.out.println("Handler1 handled request: " + request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

class ConcreteHandler2 extends Handler {
    public void handleRequest(int request) {
        if (request >= 10 && request < 20) {
            System.out.println("Handler2 handled request: " + request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

// Client
class Client {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();

        handler1.setSuccessor(handler2);

        handler1.handleRequest(5);
        handler1.handleRequest(15);
        handler1.handleRequest(25);
    }
}
