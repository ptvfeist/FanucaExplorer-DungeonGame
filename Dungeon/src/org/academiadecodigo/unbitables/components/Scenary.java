package org.academiadecodigo.unbitables.components;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.unbitables.audio.AudioPlayer;

public class Scenary {

    public static final int PADDING = 10;
    public static final int PIXELS = 20;

    private Blocks[] walls = new Walls[20];
    private Blocks[] floors = new Floor[20];

    private AudioPlayer audioPlayer;

    private Picture background;
    private Picture[] grid;

    public Scenary() {

        background = new Picture(PADDING, PADDING, "blackBackground.jpeg");


        //audioPlayer = new AudioPlayer();

    }

    public void init() {
        background.draw();
        setLimits();
        setFloor();

        //audioPlayer.playMusic("pokemon.wav");
    }

    public void setLimits() {

        walls[0] = new Walls(10, 10);
        walls[1] = new Walls( 300, 500);
        walls[2] = new Walls( 500, 300);
        walls[3] = new Walls( 800, 500);
        walls[4] = new Walls( 500, 300);

    }

    private void setFloor() {

        floors[0] = new Floor(20, 20);
        floors[1] = new Floor(60, 20);

    }

    public Blocks[] getBlocks() {
        return walls;
    }
}
