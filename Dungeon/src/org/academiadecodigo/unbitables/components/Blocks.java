package org.academiadecodigo.unbitables.components;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Blocks {

    Picture block;
    public Blocks(int x, int y, String resource) {
        block = new Picture(x, y, resource);
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
