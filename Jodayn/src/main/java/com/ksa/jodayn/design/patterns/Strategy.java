package com.ksa.jodayn.design.patterns;

interface Strategy {
    int doOperation(int num1, int num2);
}

class OperationAdd implements Strategy {
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class OperationSubtract implements Strategy {
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class OperationMultiply implements Strategy {
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

class MyContext {
    private Strategy strategy;

    public MyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}

// Client
class StrategyPatternDemo {
    public static void main(String[] args) {
        MyContext context = new MyContext(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new MyContext(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new MyContext(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
