package com.ksa.jodayn.design.patterns.fly;

import java.awt.*;

public class Rect extends Shape{
    public Rect(int x, int y, int width, int height, Color color, ShapeDirection direction) {
        super(x, y, width, height, color, direction);
    }

    @Override
    protected void draw(Graphics g) {
        g.drawRect(getX(),getY(),getWidth(),getHeight());
    }
}
