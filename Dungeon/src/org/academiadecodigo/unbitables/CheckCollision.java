package org.academiadecodigo.unbitables;

import org.academiadecodigo.unbitables.components.Player;
import org.academiadecodigo.unbitables.components.Scenary;
import org.academiadecodigo.unbitables.components.enemies.Enemy;

public class CheckCollision {

    private Player player;

    public CheckCollision (Player player) {
        this.player = player;
    }

    public boolean checkEnemyCollision (Enemy enemy) {

        //check left enemy side
        if (enemy.getX() <= player.getMaxX() && enemy.getMaxX() >= player.getMaxX()) {

            if (enemy.getY() <= player.getIntermediateY() && enemy.getMaxY() >= player.getIntermediateY()) {
                return true;
            } else if (enemy.getY() <= player.getMaxY() && enemy.getMaxY() >= player.getMaxY()) {

                return true;
            }
        //check right enemy side
        } else if (enemy.getMaxX() >= player.getX() && enemy.getX() <= player.getX()) {

            if (enemy.getY() <= player.getIntermediateY() && enemy.getMaxY() >= player.getIntermediateY()) {

                return true;
            } else if (enemy.getY() <= player.getMaxY() && enemy.getMaxY() >= player.getMaxY()) {
                return true;
            }
        //check up enemy side
        } else if (enemy.getY() <= player.getMaxY() && enemy.getMaxY() >= player.getMaxY()) {

            if (enemy.getX() <= player.getX() && enemy.getMaxX() >= player.getX()) {
                return true;
            } else if (enemy.getX() <= player.getMaxX() && enemy.getMaxX() >= player.getMaxX()) {
                return true;
            }

            // check down enemy side
        }  else if (enemy.getMaxY() >= player.getIntermediateY() && enemy.getY() <= player.getIntermediateY()) {

            if (enemy.getX() <= player.getX() && enemy.getMaxX() >= player.getX()) {
                return true;
            } else if (enemy.getX() <= player.getMaxX() && enemy.getMaxX() >= player.getMaxX()) {
                return true;
            }

        }

        return false;
    }




}
