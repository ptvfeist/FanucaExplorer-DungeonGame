package org.academiadecodigo.unbitables.components.enemies;

import org.academiadecodigo.unbitables.Directions;
import org.academiadecodigo.unbitables.components.Scenary;

public class CornerEnemy extends Enemy {

    public CornerEnemy(int x, int y, Directions direction, int steps, Scenary background) {
        super(x, y, direction, steps, background);
    }

    @Override
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

                    switch (direction) {
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

                }

                if (direction == Directions.UP) {
                    direction = Directions.RIGHT;
                } else if (direction == Directions.LEFT) {
                    direction = Directions.DOWN;
                } else {
                    direction = direction.getOposite(direction);
                }

                if (checkCollision != null) {

                    if (checkCollision.checkEnemyCollision(this)) {
                        background.unmountScenary();
                    }


                }

            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
