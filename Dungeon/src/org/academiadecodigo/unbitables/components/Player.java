package org.academiadecodigo.unbitables.components;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.unbitables.Directions;
import org.academiadecodigo.unbitables.audio.Sound;

import java.util.LinkedList;

public class Player {

    private Picture player;
    private boolean oneImg = true;
    private Scenary scenary;
    private boolean isPressed;

    private boolean openedChest = false;
    private Sound sound;

    public Player(Scenary scenary, int x, int y) {

        player = new Picture(x,  y, "right1.png");
        player.draw();

        this.scenary = scenary;

        this.sound = new Sound();

    }


    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }

    public void moveRight() {

        if (checkBoundaries(Directions.RIGHT)) {

            if (openedChest) {
                scenary.gameWon();
            }

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
            if (openedChest) {
                scenary.gameWon();
            }
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

            if (openedChest) {
                scenary.gameWon();
            }

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

            if (openedChest) {
                scenary.gameWon();
            }

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

        LinkedList<Blocks> blocks = scenary.getBlocks();

        for (Blocks block : blocks) {

            if (block == null) {
                break;
            }

            if (direction == Directions.DOWN) {

                if (block.getY() <= player.getMaxY() + Scenary.PIXELS && block.getMaxY() >= player.getMaxY()) {

                    if (block.getX() <= player.getX() && block.getMaxX() >= player.getX()) {

                        if (block instanceof Trunk) {
                            openedChest = true;
                        }

                        return true;
                    } else if (block.getX() <= player.getMaxX() && block.getMaxX() >= player.getMaxX()) {

                        if (block instanceof Trunk) {
                            openedChest = true;
                        }

                        return true;
                    }

                }

            } else if (direction == Directions.UP) {

                if (block.getMaxY() >= getLowerY() - Scenary.PIXELS && block.getY() <= getLowerY()) {

                    if (block.getX() <= player.getX() && block.getMaxX() >= player.getX()) {

                        if (block instanceof Trunk) {
                            openedChest = true;
                        }

                        return true;
                    } else if (block.getX() <= player.getMaxX() && block.getMaxX() >= player.getMaxX()) {

                        if (block instanceof Trunk) {
                            openedChest = true;
                        }

                        return true;
                    }

                }

            } else if (direction == Directions.LEFT) {

                if (block.getMaxX() >= player.getX() - Scenary.PIXELS && block.getX() <= player.getX()) {

                    if (block.getY() <= getLowerY() && block.getMaxY() >= getLowerY()) {

                        if (block instanceof Trunk) {

                            openedChest = true;
                        }

                        return true;
                    } else if(block.getY() <= player.getMaxY() && block.getMaxY() >= player.getMaxY()) {

                        if (block instanceof Trunk) {
                            openedChest = true;
                        }

                        return true;
                    }

                }

            } else if (direction == Directions.RIGHT) {

                if (block.getX() <= player.getMaxX() + Scenary.PIXELS && block.getMaxX() >= player.getMaxX()) {

                    if (block.getY() <= getLowerY() && block.getMaxY() >= getLowerY()) {
                        if (block instanceof Trunk) {
                            openedChest = true;

                        }

                        return true;
                    } else if (block.getY() <= player.getMaxY() && block.getMaxY() >= player.getMaxY()) {

                        if (block instanceof Trunk) {
                            openedChest = true;
                        }
                        return true;
                    }

                }

            }
        }

        return false;
    }

    public int getLowerY() {
        return player.getY() + (Scenary.PIXELS * 2);
    }

    public int getX() {
        return player.getX();
    }

    public int getMaxX() {
        return player.getMaxX();
    }

    public int getMaxY() {
        return player.getMaxY();
    }

    public int  getIntermediateY() {
        return player.getY() + Scenary.PIXELS;
    }

    public void deletePlayer() {
        player.delete();
    }

}
