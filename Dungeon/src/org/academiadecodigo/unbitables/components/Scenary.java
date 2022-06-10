package org.academiadecodigo.unbitables.components;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.unbitables.CheckCollision;
import org.academiadecodigo.unbitables.Directions;
import org.academiadecodigo.unbitables.audio.Sound;
import org.academiadecodigo.unbitables.components.enemies.CornerEnemy;
import org.academiadecodigo.unbitables.components.enemies.Enemy;
import org.academiadecodigo.unbitables.components.enemies.LineEnemy;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.Scanner;

public class Scenary {

    public static final int PADDING = 10;
    public static final int PIXELS = 25;

    private LinkedList<Walls> limits;

    private LinkedList<Floor> floors;
    private ArrayList<Enemy> enemies;

    private Sound sound;

    private Rectangle background;

    public Scenary() {

        background = new Rectangle(PADDING, PADDING, 1500, 800);
        limits = new LinkedList<>();
        enemies = new ArrayList<>();
        floors = new LinkedList<>();
        //audioPlayer = new AudioPlayer();

    }

    public void init() {
        background.draw();
        setLimits();
        setFloor();
        setEnemies();

        //audioPlayer.playMusic("pokemon.wav");
    }

    public void setLimits() {


    }

    public void setEnemies() {

        enemies.add(new LineEnemy(70, 140, Directions.RIGHT, 18, this));
        enemies.add(new LineEnemy(500, 55, Directions.DOWN, 16, this));
        enemies.add(new LineEnemy(760, 550, Directions.RIGHT, 26, this));
        enemies.add(new CornerEnemy(1320, 560, Directions.LEFT, 15, this));

    }

    public void setColisionEnemy(CheckCollision checkCollision) {

        for (Enemy enemy : enemies) {

            enemy.setCheckCollision(checkCollision);

        }

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

                        floors.add(new Floor(col, row));
                        col += 50;

                    } else if (item.equals("2")) {
                        limits.add(new Walls(col, row, "block.png"));

                        col += 50;
                    } else if (item.equals("3")) {

                        limits.add(new Walls(col, row, "block_lateral.png"));

                        col += 50;
                    } else if (item.equals("4")) {
                        limits.add(new Walls(col, row, "block_corner.png"));

                        col += 50;
                    } else if (item.equals("5")) {

                        limits.add(new Walls(col, row, "block_top.png"));
                        col += 50;
                    } else if (item.equals("6")) {
                        limits.add(new Walls(col, row, "block_inner_corner.png"));

                        col += 50;
                    }

                    if (col >= 1500) {
                        row += 50;
                        col = PADDING;
                    }

                }

            }
            sc.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
            //System.err.println(file.getAbsolutePath());
        } catch (
                ConcurrentModificationException e) {

        }

    }

    public LinkedList<Walls> getBlocks() {
        return limits;
    }

    public void unmountScenary() {
        /*for (Enemy enemy : enemies) {
            enemy.deleteEnemy();
        }*/

        for (Blocks limit : limits) {
            limit.delete();
        }

        for (Floor floor : floors) {
            floor.delete();
        }

        enemies.clear();

        background.delete();
    }
}
