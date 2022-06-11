package org.academiadecodigo.unbitables.components;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.unbitables.CheckCollision;
import org.academiadecodigo.unbitables.Directions;
import org.academiadecodigo.unbitables.EndScreen;
import org.academiadecodigo.unbitables.audio.Sound;
import org.academiadecodigo.unbitables.components.enemies.CornerEnemy;
import org.academiadecodigo.unbitables.components.enemies.Enemy;
import org.academiadecodigo.unbitables.components.enemies.LineEnemy;

import java.util.ArrayList;
import java.util.LinkedList;

public class Scenary {

    public static final int PADDING = 10;
    public static final int PIXELS = 25;

    private LinkedList<Blocks> limits;

    private LinkedList<Floor> floors;
    private ArrayList<Enemy> enemies;

    private ArrayList<Items> items;

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
        sound = new Sound();
    }

    public void init() {
        background.draw();

        sound.playMusic(8);

        setFloor();
        setItems();
        setEnemies();

    }

    public void setItems() {

        items.add(new Items(1235,135,"items/tapete3.png"));
        limits.add(new Trunk(1275,175));
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

        int[][] map = {
                {5, 2, 2, 2, 2, 6, 0, 0, 5, 2, 2, 2, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 2, 2, 2, 2, 2, 2, 6},
                {5, 1, 1, 1, 1, 4, 2, 2, 2, 1, 1, 1, 4, 2, 2, 2, 2, 2, 2, 6, 0, 0, 5, 1, 1, 1, 1, 1, 1, 3},
                {5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 0, 5, 1, 1, 1, 1, 1, 1, 3},
                {5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 0, 5, 1, 1, 1, 1, 1, 1, 3},
                {5, 1, 1, 1, 1, 3, 5, 5, 5, 1, 1, 1, 3, 5, 5, 5, 5, 1, 1, 3, 0, 0, 5, 1, 1, 1, 1, 1, 1, 3},
                {5, 5, 1, 1, 3, 5, 0, 0, 5, 5, 5, 5, 5, 0, 0, 0, 5, 1, 1, 3, 0, 0, 5, 1, 1, 1, 1, 1, 1, 3},
                {0, 5, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 1, 1, 3, 0, 0, 5, 1, 1, 1, 1, 1, 1, 3},
                {0, 5, 1, 1, 4, 2, 2, 2, 2, 2, 2, 2, 6, 0, 0, 0, 5, 1, 1, 3, 0, 0, 5, 5, 5, 1, 1, 3, 5, 5},
                {0, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 5, 2, 2, 1, 1, 4, 2, 6, 0, 0, 5, 1, 1, 3, 0, 0},
                {0, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 5, 1, 1, 1, 1, 1, 1, 3, 0, 0, 5, 1, 1, 3, 0, 0},
                {0, 5, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1, 3, 0, 5, 1, 1, 1, 1, 1, 1, 3, 5, 2, 2, 1, 1, 3, 0, 0},
                {5, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 3, 0, 5, 1, 1, 1, 1, 1, 1, 4, 2, 1, 1, 1, 1, 3, 0, 0},
                {5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 0},
                {5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 0},
                {5, 1, 1, 1, 3, 5, 5, 5, 5, 5, 5, 5, 5, 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1, 1, 3, 0, 0},
                {5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 5, 5, 5, 5, 0, 0},
        };

        int row = PADDING;
        int col = PADDING;

        for (int i = 0; i < map.length; i++) {

            for (int j = 0; j < map[i].length; j++) {

                if (map[i][j] == 0) {

                    limits.add(new Walls(col, row, "block_top.png"));
                    col += 50;

                } else if (map[i][j] == 1) {

                    floors.add(new Floor(col, row));
                    col += 50;

                }  else if (map[i][j] == 2) {

                    limits.add(new Walls(col, row, "block.png"));
                    col += 50;

                }  else if (map[i][j] == 3) {

                    limits.add(new Walls(col, row, "block_lateral.png"));
                    col += 50;

                }  else if (map[i][j] == 4) {

                    limits.add(new Walls(col, row, "block_corner.png"));
                    col += 50;

                }  else if (map[i][j] == 5) {

                    limits.add(new Walls(col, row, "block_top.png"));
                    col += 50;

                }   else if (map[i][j] == 6) {

                    limits.add(new Walls(col, row, "block_inner_corner.png"));
                    col += 50;

                }

                if (col >= 1500) {
                    row += 50;
                    col = PADDING;
                }

            }

        }

    }

    public LinkedList<Blocks> getBlocks() {
        return limits;
    }

    public void unmountScenary() {

        for (Enemy enemy : enemies) {
            enemy.deleteEnemy();
        }

        sound.stop();

        /*for (Blocks limit : limits) {
            limit.delete();
        }

        for (Floor floor : floors) {
            floor.delete();
        }

        enemies.clear();

        limits.clear();

        floors.clear();*/

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        endScreen = new EndScreen();
        endScreen.lost();

        player.deletePlayer();
        background.delete();


    }

    public void gameWon() {

        try {

            for (Blocks block : limits) {

                if (block instanceof Trunk) {

                    ((Trunk) block).open();

                    break;
                }
            }

            Thread.sleep(1000);

            sound.stop();

            endScreen = new EndScreen();
            endScreen.init();


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }






    }


}


