package com.ksa.jodayn.design.patterns.fly;

import java.awt.*;

public class Circle extends Shape {
    public Circle(int x, int y, int radius, Color color, ShapeDirection direction) {
        super(x, y, 2 * radius, 2 * radius, color, direction);
    }

    @Override
    protected void draw(Graphics g) {
        g.drawOval(getX(),getY(),getWidth(),getWidth());
    }
}
