package org.academiadecodigo.unbitables.components;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.unbitables.audio.AudioPlayer;

import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Scenary {

    public static final int PADDING = 10;
    public static final int PIXELS = 20;

    private Blocks[] walls = new Walls[20];
    //private Blocks[] floors = new Floor[250];

    private AudioPlayer audioPlayer;

    private Rectangle background;
    //private Picture[] grid;

    public Scenary() {

        background = new Rectangle (PADDING, PADDING, 1500, 800);

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
                    System.out.println("item: " + item);
                    System.out.println("col: " + col);
                    System.out.println("row: " + row);


                    if (item.equals("0")) {

                        new Walls(col, row, "block_top.png");
                        col += 50;

                    } else if (item.equals("1")) {

                        new Floor(col, row);
                        col += 50;

                    } else if (item.equals("2")) {

                       new Walls(col, row, "block.png");
                       col += 50;
                    } else if (item.equals("3")) {

                        new Walls(col, row, "block_lateral.png");
                        col += 50;
                    } else if (item.equals("4")) {

                        new Walls(col, row, "block_corner.png");
                        col += 50;
                    } else if (item.equals("5")) {

                        new Walls(col, row, "block_top.png");
                        col += 50;
                    } else if (item.equals("6")) {

                        new Walls(col, row, "block_inner_corner.png");
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

    public Blocks[] getBlocks() {
        return walls;
    }
}
