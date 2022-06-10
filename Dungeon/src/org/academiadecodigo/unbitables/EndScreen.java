package org.academiadecodigo.unbitables;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class EndScreen {

    private final Picture background;
    private Picture lost;
    private Picture win;
    private Picture fanuca1;

    private boolean isWin = false;

    private boolean isSkipped = false;

    private Picture goAgain;
    private final Game game;

    private KeyboardLogic keyboardLogic = new KeyboardLogic();

    public EndScreen(){
        game = new Game();
        keyboardLogic.setEndScreen(this);
        keyboardLogic.init();
        background = new Picture(10,10,"StartGamePicture.png");
        background.draw();
        background.grow(365,200);
        background.translate(365,200);
    }

    public void delete() {
        fanuca1.delete();
        background.delete();
        goAgain.delete();
        if(isWin){
            win.delete();
        } else {
            lost.delete();
        }
        game.init();
    }

    Thread Thread = new Thread(){
        public void run(){
            try {
                win();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    };

    public void init(){
        Thread.start();

    }

    public void lost(){
        isWin = false;
        lost = new Picture(background.getWidth()/2,background.getHeight()/2,"wasted.png");
        lost.draw();
        lost.grow(80,55);
        lost.translate(-lost.getWidth()/2+80,-lost.getHeight()/2+55);
        try {
            fanuca1 = new Picture(background.getWidth()-100,-20,"left1.png");
            Thread.sleep(3000);
            fanuca1.draw();
            fanuca1.grow(35,35);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            goAgain = new Picture(background.getWidth()/2,600,"pressfanuca.png");
            goAgain.translate(-goAgain.getWidth() / 2, 0);
            goAgain.draw();
            while (!isSkipped)
                try {
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void win() throws InterruptedException {
        isWin = true;
        win = new Picture(background.getWidth()/2,background.getHeight()/2,"youwin.png");
        win.draw();
        win.grow(88,55);
        win.translate(-win.getWidth()/2+110,-250);
        try {
            fanuca1 = new Picture(background.getWidth()-100,-20,"left1.png");
            Thread.sleep(3000);
            fanuca1.draw();
            fanuca1.grow(35,35);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down2.png");
            Thread.sleep(200);
            fanuca1.translate(0,20);
            fanuca1.load("down1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left2.png");
            Thread.sleep(200);
            fanuca1.translate(-20,0);
            fanuca1.load("left1.png");
            Thread.sleep(200);
            goAgain = new Picture(background.getWidth()/2,600,"pressfanuca.png");
            goAgain.translate(-goAgain.getWidth() / 2, 0);
            goAgain.draw();
            while (!isSkipped)
                try {
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(4, 2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);
                    Thread.sleep(50);
                    goAgain.grow(-4, -2);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
