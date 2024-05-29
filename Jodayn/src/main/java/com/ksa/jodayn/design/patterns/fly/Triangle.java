package com.ksa.jodayn.design.patterns.fly;

import java.awt.*;

public class Triangle extends Shape{
    public Triangle(int x, int y, int width, int height, Color color, ShapeDirection direction) {
        super(x, y, width, height, color, direction);
    }

    @Override
    protected void draw(Graphics g) {
        g.drawLine(getX()+getWidth()/2, getY(), getX()+getWidth(), getY()+getHeight());
        g.drawLine(getX()+getWidth(), getY()+getHeight(), getX(), getY()+getHeight());
        g.drawLine(getX(), getY()+getHeight(), getX()+getWidth()/2, getY());
    }
}
