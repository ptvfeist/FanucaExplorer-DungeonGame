package org.academiadecodigo.unbitables.components;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Blocks {

    Rectangle block;

    public Blocks(int x, int y, int maxX, int maxY) {
        block = new Rectangle(x, y, maxX, maxY);
        block.setColor(Color.MAGENTA);
        block.draw();
    }

    public int getX() {
        return block.getX();
    }

    public int getMaxX() {
        return block.getX() + block.getWidth();
    }

    public int getY() {
        return block.getY();
    }

    public int getMaxY() {
        return block.getY() + block.getHeight();
    }


}
