package com.ksa.jodayn.design.patterns.fly;

import java.awt.*;

enum ShapeDirection {
    UpLeft,
    UpRight,
    DownLeft,
    DownRight,
}

abstract class Shape extends Location {
    private int width, height;
    private Color color;
    private ShapeDirection direction;

    public Shape(int x, int y, int width, int height, Color color, ShapeDirection direction) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.color = color;
        this.direction = direction;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setSize(int width, int height) {
        if (isVisible()) {
            setVisible(false);
            this.width = width;
            this.height = height;
            setVisible(true);
        } else {
            this.width = width;
            this.height = height;
        }
    }

    void move(int width, int height) {
        switch (direction) {
            case UpLeft:
                moveTo(getX() - 5, getY() - 5);
                if (getX() <= 0) {
                    direction = ShapeDirection.UpRight;
                } else if (getY() <= 0) {
                    direction = ShapeDirection.DownLeft;
                }
                break;
            case UpRight:
                moveTo(getX() + 5, getY() - 5);
                if (getX() + getWidth() >= width) {
                    direction = ShapeDirection.UpLeft;
                } else if (getY() <= 0) {
                    direction = ShapeDirection.DownRight;
                }
                break;
            case DownLeft:
                moveTo(getX() - 5, getY() + 5);
                if (getX() <= 0) {
                    direction = ShapeDirection.DownRight;
                } else if (getY() + getHeight() >= height) {
                    direction = ShapeDirection.UpLeft;
                }
                break;
            case DownRight:
                moveTo(getX() + 5, getY() + 5);
                if (getX() + getWidth() >= width) {
                    direction = ShapeDirection.DownLeft;
                } else if (getY() + getHeight() >= height) {
                    direction = ShapeDirection.UpRight;
                }
        }
    }

    void paint(Graphics g) {
        if (isVisible()) {
            g.setColor(color);
        } else {
            g.setColor(Color.WHITE);
        }
        draw(g);
    }

    protected abstract void draw(Graphics g);
}
