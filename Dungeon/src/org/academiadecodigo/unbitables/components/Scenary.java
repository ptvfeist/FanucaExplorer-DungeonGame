package org.academiadecodigo.unbitables.components;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.unbitables.CheckCollision;
import org.academiadecodigo.unbitables.Directions;
import org.academiadecodigo.unbitables.EndScreen;
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

    private LinkedList<Blocks> limits;

    private LinkedList<Floor> floors;
    private ArrayList<Enemy> enemies;

    private ArrayList<Items> items;

    private Trunk trunk;

    private Player player;

    private Sound sound;

    private Rectangle background;

    private EndScreen endScreen;

    public Scenary() {

        background = new Rectangle(PADDING, PADDING, 1500, 800);
        limits = new LinkedList<>();
        enemies = new ArrayList<>();
        floors = new LinkedList<>();
        items = new ArrayList<>();
        //audioPlayer = new AudioPlayer();

    }

    public void init() {
        background.draw();

        setFloor();
        setItems();
        setEnemies();

        //audioPlayer.playMusic("pokemon.wav");
    }

    public void setItems() {
        items.add(new Items(60,650,"items/escadas.png"));
        items.add(new Items(60,665,"items/escadas.png"));
        items.add(new Items(1350,35,"items/bandeiras2.png"));
        limits.add(new Items(1275,35,"items/Chair1.png"));
        limits.add(new Items(1345,50,"items/Crown.png"));
        items.add(new Items(1240,35,"items/bandeiras2.png"));
        items.add(new Items(1175,40,"items/Armoury.png"));
        limits.add(new Items(1235,50,"items/close chest.png"));
        items.add(new Items(1425,40,"items/Armoury.png"));
        items.add(new Items(60,575,"items/courtines.png"));
        limits.add(new Items(1440,300,"items/open chest.png"));
        items.add(new Items(1235,135,"items/tapete3.png"));
        items.add(new Items(760,425,"items/boxes.png"));
        limits.add(new Items(900,550,"items/pote.png"));
        items.add(new Items(1160,550,"items/sword.png"));
        items.add(new Items(1230,530,"items/Armoury.png"));
        items.add(new Items(1000,440,"items/food.png"));
        items.add(new Items(1075,590,"items/lanças.png"));
        limits.add(new Items(950,675,"items/lavatorio.png"));
        limits.add(new Items(760,675,"items/vinho.png"));
        limits.add(new Items(1270,715,"items/bed.png"));
        limits.add(new Items(1325,670,"items/minitable.png"));
        limits.add(new Items(540,60, "items/escadas2.png.jpeg"));
        items.add(new Items(500, 125, "items/tapete.png"));
        items.add(new Items(200,40,"items/lanças4.png"));
        items.add(new Items(100,40,"items/Armoury.png"));
        items.add(new Items(150,50,"items/knife.png"));
        items.add(new Items(125,125,"items/tapete2.png"));
        items.add(new Items(350,370,"items/quadro.png"));
        items.add(new Items(450,370,"items/quadro2.png"));
        limits.add(new Trunk(1285,185));

    }

    public void setPlayer(Player player) {
        this.player = player;
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

    public LinkedList<Blocks> getBlocks() {
        return limits;
    }

    public Trunk getTrunk() {
        return trunk;
    }

    public void unmountScenary() {
        endScreen = new EndScreen();
        endScreen.lost();

        for (Enemy enemy : enemies) {
            enemy.deleteEnemy();
        }

        for (Blocks limit : limits) {
            limit.delete();
        }

        for (Floor floor : floors) {
            floor.delete();
        }

        enemies.clear();

        limits.clear();
        floors.clear();
        background.delete();
        player.deletePlayer();
    }

    public void gameWon() {

        endScreen = new EndScreen();
        endScreen.init();


        /*for (Enemy enemy : enemies) {
            enemy.deleteEnemy();
        }

        for (Blocks limit : limits) {
            limit.delete();
        }

        for (Floor floor : floors) {
            floor.delete();
        }

        enemies.clear();

        limits.clear();
        floors.clear();
        background.delete();
        player.deletePlayer();


        endScreen = new EndScreen();
        endScreen.win();*/

    }
}
