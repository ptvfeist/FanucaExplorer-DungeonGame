package org.academiadecodigo.unbitables;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.unbitables.components.Player;
import org.academiadecodigo.unbitables.components.Scenary;

public class Game {



    public void init() {
        Scenary scenary = new Scenary();
        scenary.init();

        Player player = new Player(scenary);

        KeyboardLogic keyboardLogic = new KeyboardLogic();
        keyboardLogic.init();
        keyboardLogic.setPlayer(player);

    }

}
