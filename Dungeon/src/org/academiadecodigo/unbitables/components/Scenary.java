package org.academiadecodigo.unbitables.components;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.unbitables.audio.Sound;

import java.io.*;
import java.nio.file.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Scenary {

    public static final int PADDING = 10;
    public static final int PIXELS = 20;

    private LinkedList<Walls> limits;

    private Blocks[] walls = new Walls[20];

    private Sound sound;

    private Rectangle background;

    public Scenary() {

        background = new Rectangle (PADDING, PADDING, 1500, 800);
        limits = new LinkedList<>();
        //audioPlayer = new AudioPlayer();

    }

    public void init() {
        background.draw();
        setLimits();
        setFloor();

        //audioPlayer.playMusic("pokemon.wav");
    }

    public void setLimits() {


    }

    private void setFloor() {

        File file = new File(Paths.get("resources/textFiles/position.txt").toAbsolutePath().toUri());

        try {

            int row = PADDING;
            int col = PADDING;

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String[] line = sc.nextLine().split(" ");

                for (String item : line) {

                    if (item.equals("0")) {

                        limits.add(new Walls(col, row, "block_top.png"));
                        col += 50;

                    } else if (item.equals("1")) {

                        new Floor(col, row);
                        col += 50;

                    } else if (item.equals("2")) {
                        limits.add(new Walls(col, row, "block.png"));

                       //new Walls(col, row, "block.png");
                       col += 50;
                    } else if (item.equals("3")) {

                        limits.add(new Walls(col, row, "block_lateral.png"));
                        //new Walls(col, row, "block_lateral.png");
                        col += 50;
                    } else if (item.equals("4")) {
                        limits.add(new Walls(col, row, "block_corner.png"));
                        //new Walls(col, row, "block_corner.png");
                        col += 50;
                    } else if (item.equals("5")) {

                        limits.add(new Walls(col, row, "block_top.png"));
                        col += 50;
                    } else if (item.equals("6")) {
                        limits.add(new Walls(col, row, "block_inner_corner.png"));
                        //new Walls(col, row, "block_inner_corner.png");
                        col += 50;
                    }

                    if (col >= 1500) {
                        row += 50;
                        col = PADDING;
                    }

                }

            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            //System.err.println(file.getAbsolutePath());
        }

    }

    public LinkedList<Walls> getBlocks() {
        return limits;
    }
}
