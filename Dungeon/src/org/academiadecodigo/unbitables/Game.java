package org.academiadecodigo.unbitables;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.unbitables.components.Player;
import org.academiadecodigo.unbitables.components.Scenary;

public class Game {



    public void init() {


        Scenary scenary = new Scenary();
        scenary.init();

        Player player = new Player(scenary, 115, 650);

        scenary.setPlayer(player);

        KeyboardLogic keyboardLogic = new KeyboardLogic();
        keyboardLogic.init();
        keyboardLogic.setPlayer(player);

        CheckCollision checkCollision = new CheckCollision(player);
        scenary.setColisionEnemy(checkCollision);


    }

}
