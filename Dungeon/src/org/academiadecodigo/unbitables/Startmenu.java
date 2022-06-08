package org.academiadecodigo.GameTesting.Startmenu;

import org.academiadecodigo.GameTesting.KeyboardLogic;
import org.academiadecodigo.simplegraphics.pictures.Picture;




public class Startmenu {

    private Picture startBackground;
    private Picture gameName;
    private Picture start_game;
    private Picture fanuca;


    private boolean isSkipped = false;

    private int delay = 50;

    // logo color #50824c
    // logo outline color #30502d

    private KeyboardLogic keyboardLogic = new KeyboardLogic();

    public Startmenu() {
        keyboardLogic.setStarmenu(this);
        keyboardLogic.init();
        Startmenu.this.init();

    }

    Thread thread1 = new Thread() {
        public void run() {
            startPressFanuca();
        }
    };

    public void init() {
        startBackground();
        startGameName();
        startFanuca();
        thread1.start();
    }


    public void delete() {
        startBackground.delete();
        start_game.delete();
        gameName.delete();
        fanuca.delete();
    }

    public void startBackground() {
        startBackground = new Picture(10, 10, "StartGamePicture.png");
        startBackground.draw();
        startBackground.grow(500, 200);
        startBackground.translate(500, 200);
    }

    public void startFanuca(){
        fanuca = new Picture(startBackground.getWidth()/2,startBackground.getHeight()/2, "start.png");
        fanuca.draw();
        fanuca.translate(-fanuca.getWidth()/2, -fanuca.getHeight()/2 + 50);
    }
    public void startGameName() {
        gameName = new Picture(startBackground.getWidth() / 2, 150, "fanucatheexplorer.png");
        gameName.translate(-gameName.getWidth() / 2, 0);
        gameName.grow(50, 20);
        gameName.draw();
    }


    public void startPressFanuca() {
        start_game = new Picture(startBackground.getWidth() / 2, 650, "pressfanuca.png");
        start_game.translate(-start_game.getWidth() / 2, 0);
        start_game.draw();
        while (!isSkipped)
            try {
                Thread.sleep(delay);
                start_game.grow(4, 2);
                Thread.sleep(delay);
                start_game.grow(4, 2);
                Thread.sleep(delay);
                start_game.grow(4, 2);
                Thread.sleep(delay);
                start_game.grow(4, 2);
                Thread.sleep(delay);
                start_game.grow(4, 2);
                Thread.sleep(delay);
                start_game.grow(4, 2);
                Thread.sleep(delay);
                start_game.grow(4, 2);
                Thread.sleep(delay);
                start_game.grow(4, 2);
                Thread.sleep(delay);
                start_game.grow(4, 2);
                Thread.sleep(delay);
                start_game.grow(4, 2);
                Thread.sleep(delay);
                start_game.grow(-4, -2);
                Thread.sleep(delay);
                start_game.grow(-4, -2);
                Thread.sleep(delay);
                start_game.grow(-4, -2);
                Thread.sleep(delay);
                start_game.grow(-4, -2);
                Thread.sleep(delay);
                start_game.grow(-4, -2);
                Thread.sleep(delay);
                start_game.grow(-4, -2);
                Thread.sleep(delay);
                start_game.grow(-4, -2);
                Thread.sleep(delay);
                start_game.grow(-4, -2);
                Thread.sleep(delay);
                start_game.grow(-4, -2);
                Thread.sleep(delay);
                start_game.grow(-4, -2);
                Thread.sleep(delay);
                System.out.println("loop");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}












