package org.academiadecodigo.unbitables;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.unbitables.components.Player;

public class KeyboardLogic implements KeyboardHandler {

        private Player player;

        private Keyboard keyboard;

        public void init() {

            keyboard = new Keyboard(this);

            KeyboardEvent right = new KeyboardEvent();
            right.setKey(KeyboardEvent.KEY_D);
            right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            KeyboardEvent left = new KeyboardEvent();
            left.setKey(KeyboardEvent.KEY_A);
            left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            KeyboardEvent up = new KeyboardEvent();
            up.setKey(KeyboardEvent.KEY_W);
            up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            KeyboardEvent down = new KeyboardEvent();
            down.setKey(KeyboardEvent.KEY_S);
            down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            keyboard.addEventListener(right);
            keyboard.addEventListener(left);
            keyboard.addEventListener(up);
            keyboard.addEventListener(down);

        }

        public void setPlayer(Player player) {
            this.player = player;
        }

        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {
            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_A:
                    player.moveLeft();
                    break;
                case KeyboardEvent.KEY_D:
                    player.moveRight();
                    break;
                case KeyboardEvent.KEY_W:
                    player.moveUp();
                    break;
                case KeyboardEvent.KEY_S:
                    player.moveDown();
                    break;

            }
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {


        }




}
