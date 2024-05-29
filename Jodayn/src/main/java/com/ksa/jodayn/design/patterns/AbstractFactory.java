package com.ksa.jodayn.design.patterns;

interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WinFactory implements GUIFactory {
    public Button createButton() {
        return new WinButton();
    }
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}

class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

interface Button {
    void paint();
}

class WinButton implements Button {
    public void paint() {
        System.out.println("Windows Button");
    }
}

class MacButton implements Button {
    public void paint() {
        System.out.println("Mac Button");
    }
}

interface Checkbox {
    void paint();
}

class WinCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Windows Checkbox");
    }
}

class MacCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Mac Checkbox");
    }
}
