package org.academiadecodigo.unbitables.components;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.unbitables.Directions;

import java.util.LinkedList;

public class Player {

    private Picture player;
    private boolean oneImg = true;
    private Scenary scenary;
    private boolean isPressed;

    public Player(Scenary scenary) {

        player = new Picture(120, 650, "right1.png");
        player.draw();

        this.scenary = scenary;

    }


    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }

    public void moveRight() {

        if (checkBoundaries(Directions.RIGHT)) {
            return;
        }
        if (!isPressed) {
            player.translate(Scenary.PIXELS, 0);
            setPressed(true);


            if (oneImg) {
                player.load("right2.png");
                oneImg = false;
            } else {
                player.load("right1.png");
                oneImg = true;
            }
        }
    }

    public void moveLeft() {

        if (checkBoundaries(Directions.LEFT)) {

            return;
        }
        if (!isPressed) {
            player.translate(-Scenary.PIXELS, 0);
            setPressed(true);

            if (oneImg) {
                player.load("left1.png");
                oneImg = false;
            } else {
                player.load("left2.png");
                oneImg = true;
            }
        }
    }

    public void moveUp() {

        if (checkBoundaries(Directions.UP)) {
            return;
        }
        if (!isPressed) {
            player.translate(0, -Scenary.PIXELS);
            setPressed(true);

            if (oneImg) {
                player.load("up1.png");
                oneImg = false;
            } else {
                player.load("up2.png");
                oneImg = true;
            }
        }
    }

    public void moveDown() {

        if (checkBoundaries(Directions.DOWN)) {
            return;
        }
        if (!isPressed) {
            player.translate(0, Scenary.PIXELS);
            setPressed(true);

            if (oneImg) {
                player.load("down1.png");
                oneImg = false;
            } else {
                player.load("down2.png");
                oneImg = true;
            }
        }
    }

    private boolean checkBoundaries(Directions direction) {

        LinkedList<Walls> blocks = scenary.getBlocks();

        for (Blocks block : blocks) {

            if (block == null) {
                break;
            }

            if (direction == Directions.DOWN) {

                if (block.getX() <= player.getX() && block.getMaxX() >= player.getX() && block.getY() <= player.getMaxY() && block.getY() + (2 * Scenary.PIXELS) >= player.getMaxY()) {
                    return true;
                } else if (block.getX() <= player.getMaxX() && block.getMaxX() >= player.getMaxX() && block.getY() <= player.getMaxY() && block.getY() + (2 * Scenary.PIXELS) >= player.getMaxY()) {
                    return true;
                }

            } else if (direction == Directions.UP) {

                if (block.getX() <= player.getX() && block.getMaxX() >= player.getX() && block.getMaxY() >= player.getY() && block.getMaxY() - (2 * Scenary.PIXELS) <= player.getY()) {
                    return true;
                } else if (block.getX() <= player.getMaxX() && block.getMaxX() >= player.getMaxX() && block.getMaxY() >= player.getY() && block.getMaxY() - (2 * Scenary.PIXELS) <= player.getY()) {
                    return true;
                }

            } else if (direction == Directions.LEFT) {

                if (block.getY() <= player.getY() && block.getMaxY() >= player.getY() && block.getMaxX() >= player.getX() && block.getMaxX() - (2 * Scenary.PIXELS) <= player.getX()) {
                    return true;
                } else if (block.getY() <= player.getMaxY() && block.getMaxY() >= player.getMaxY() && block.getMaxX() >= player.getX() && block.getMaxX() - (2 * Scenary.PIXELS) <= player.getX()) {
                    return true;
                }

            } else if (direction == Directions.RIGHT) {

                if (block.getY() <= player.getY() && block.getMaxY() >= player.getY() && block.getX() <= player.getMaxX() && block.getX() + (2 * Scenary.PIXELS) >= player.getMaxX()) {
                    return true;
                } else if (block.getY() <= player.getMaxY() && block.getMaxY() >= player.getMaxY() && block.getX() <= player.getMaxX() && block.getX() + (2 * Scenary.PIXELS) >= player.getMaxX()) {
                    return true;
                }

            }

        }

        return false;
    }


}
