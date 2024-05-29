package com.ksa.jodayn.design.patterns.fly;

class Location {
    private int x, y;

    private boolean visible = true;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public boolean isVisible() {
        return visible;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void moveTo(int x, int y) {
        if (isVisible()) {
            setVisible(false);
            this.x = x;
            this.y = y;
            setVisible(true);
        } else {
            this.x = x;
            this.y = y;
        }
    }


}
