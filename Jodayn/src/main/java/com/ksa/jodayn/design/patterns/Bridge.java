package com.ksa.jodayn.design.patterns;

interface BankOperations {
    void doOperation();
}

class IslamicBankOperations implements BankOperations {
    @Override
    public void doOperation() {
        System.out.println("Islamic Bank Operations");
    }
}

class NonIslamicBankOperations implements BankOperations {
    @Override
    public void doOperation() {
        System.out.println("NonIslamic Bank Operations");
    }
}

abstract class BankWithOperations {
    protected final BankOperations operations;

    BankWithOperations(BankOperations operations) {
        this.operations = operations;
    }

    public abstract void doOperation();
}

class Bank extends BankWithOperations {

    Bank(BankOperations operations) {
        super(operations);
    }

    @Override
    public void doOperation() {
        operations.doOperation();
    }
}

class IsamicBank extends Bank{

    IsamicBank() {
        super(new IslamicBankOperations());
    }
}

class NonIsamicBank extends Bank{
    NonIsamicBank() {
        super(new NonIslamicBankOperations());
    }
}


class MainY{
    public static void main(String[] args) {
        Bank bank = new IsamicBank();
        bank.doOperation();
    }
}