package org.academiadecodigo.unbitables.components;

public class Trunk extends Blocks{

    public Trunk (int x, int y) {
        super(x, y, "items/bau2.png");
    }

    public void open() {
        block.load("items/bau1.png");
    }

}
