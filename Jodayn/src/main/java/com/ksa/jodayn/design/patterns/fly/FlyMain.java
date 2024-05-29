package com.ksa.jodayn.design.patterns.fly;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class FlyMain extends JFrame implements Runnable {

    private final List<Shape> shapes = new ArrayList<Shape>();

    private Random random = new Random();

    FlyMain() {
        init();
        new Thread(this).start();
    }

    final void init() {
        setTitle("Flyweight Pattern Demo");
        setBackground(Color.WHITE);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        for (int i = 0; i < 20; i++) {
            shapes.add(randomShape());
        }

//        shapes.add(new Circle(100,100,50,Color.RED, ShapeDirection.DownRight));
//        shapes.add(new Rect(100, 100, 100, 100, Color.BLUE, ShapeDirection.UpLeft));
//        shapes.add(new Triangle(100,100,100,100, Color.GRAY, ShapeDirection.UpRight));
    }

    private Shape randomShape() {
        return switch (random.nextInt() % 3) {
            case 0 ->
                    new Circle(random.nextInt(getWidth()), random.nextInt(getHeight()), random.nextInt(50), randomColor(), randomDirection());
            case 1 ->
                    new Rect(random.nextInt(getWidth()), random.nextInt(getHeight()), random.nextInt(100), random.nextInt(100), randomColor(), randomDirection());
            default ->
                    new Triangle(random.nextInt(getWidth()), random.nextInt(getHeight()), random.nextInt(100), random.nextInt(100), randomColor(), randomDirection());
        };
    }

    private ShapeDirection randomDirection() {
        return switch (random.nextInt() % 4) {
            case 0 -> ShapeDirection.UpLeft;
            case 1 -> ShapeDirection.UpRight;
            case 2 -> ShapeDirection.DownLeft;
            default -> ShapeDirection.DownRight;
        };
    }

    private Color randomColor() {
        return switch (random.nextInt() % 3) {
            case 0 -> Color.RED;
            case 1 -> Color.BLUE;
            case 2 -> Color.GREEN;
            default -> Color.BLUE;
        };
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (Shape shape : shapes) {
            shape.move(getWidth(), getHeight());
            shape.paint(g);
        }
    }

    public static void main(String[] args) {
        new FlyMain().setVisible(true);
    }

    @Override
    public void run() {
        while (true) {
            Thread.yield();
            repaint();
        }
    }
}
