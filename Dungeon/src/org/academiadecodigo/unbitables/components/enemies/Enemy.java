package org.academiadecodigo.unbitables.components.enemies;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.unbitables.CheckCollision;
import org.academiadecodigo.unbitables.Directions;
import org.academiadecodigo.unbitables.components.Scenary;

public abstract class Enemy {

    protected Directions direction;
    protected int steps;
    protected Picture enemy;
    protected Scenary background;

    protected boolean exit = false;

    protected CheckCollision checkCollision = null;


    Thread thread1 = new Thread(){
        public void run(){
            enemyMove();
        }
    };



    public Enemy(int x, int y, Directions direction, int steps, Scenary background) {
        this.direction = direction;
        this.steps = steps;
        this.background = background;

        setEnemy(x, y);

        try {
            Thread.sleep(300);

            thread1.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }

    private void setEnemy(int x, int y) {

        if (direction == Directions.LEFT) {
            enemy = new Picture(x, y, "enemy/enemy1left.png");
        } else if (direction == Directions.RIGHT || direction ==  Directions.DOWN ||  direction == Directions.UP) {
            enemy = new Picture(x, y, "enemy/enemy1right.png");
        }

        enemy.draw();
    }

    public void enemyMove() {

        try {
            while (true) {

                Thread.sleep(50);

                if (direction == Directions.LEFT) {
                    enemy.load("enemy/enemy1left.png");
                } else {
                    enemy.load("enemy/enemy1right.png");
                }

                for (int i = 0; i < steps; i++) {

                    if (exit) {
                        thread1.interrupt();
                        return;}

                    Thread.sleep(100);

                    switch (this.direction) {
                        case UP:
                            enemy.translate(0, -10);
                            break;
                        case DOWN:
                            enemy.translate(0, 10);
                            break;
                        case RIGHT:
                            enemy.translate(10, 0);
                            break;
                        case LEFT:
                            enemy.translate(-10, 0);
                            break;

                    }

                    if (checkCollision != null) {

                        if (checkCollision.checkEnemyCollision(this)) {
                            background.unmountScenary();
                        }


                    }


                }
                direction = direction.getOposite(direction);

            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getX() {
        return enemy.getX();
    }

    public int getMaxX() {
        return enemy.getMaxX();
    }

    public int getMaxY() {
        return enemy.getMaxY();
    }

    public int  getY() {
        return enemy.getY();
    }

    public void setCheckCollision(CheckCollision checkCollision) {
        this.checkCollision = checkCollision;
    }

    public void deleteEnemy() {
        exit =  true;

        /*try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        enemy.delete();*/
    }
}
