package org.academiadecodigo.unbitables;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.unbitables.components.Player;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;

public class KeyboardLogic implements KeyboardHandler {

    private Player player;
    private Startmenu startmenu;

    private Keyboard keyboard;

    public void init() {

        keyboard = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KEY_D);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KEY_A);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KEY_W);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KEY_S);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent skipMenu = new KeyboardEvent();
        skipMenu.setKey(KEY_SPACE);
        skipMenu.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(right);
        keyboard.addEventListener(left);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(skipMenu);

    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setStartmenu(Startmenu startmenu) {
        this.startmenu = startmenu;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (player != null)
            switch (keyboardEvent.getKey()) {
                case KEY_A:
                    player.moveLeft();
                    break;
                case KEY_D:
                    player.moveRight();
                    break;
                case KEY_W:
                    player.moveUp();
                    break;
                case KEY_S:
                    player.moveDown();
                    break;
            } else {
            switch (keyboardEvent.getKey()) {
                case KEY_SPACE:
                startmenu.delete();
                break;
            }
        }
    }




    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {


    }


}
