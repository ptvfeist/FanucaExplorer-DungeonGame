package org.academiadecodigo.unbitables;

public enum Directions {
    RIGHT,
    LEFT,
    UP,
    DOWN;

    public Directions getOposite(Directions currentDirection) {
        Directions newDirection = Directions.UP;

        switch (currentDirection) {
            case UP:
                newDirection = Directions.DOWN;
                break;
            case DOWN:
                newDirection = Directions.UP;
                break;
            case LEFT:
                newDirection = Directions.RIGHT;
                break;
            case RIGHT:
                newDirection = Directions.LEFT;
                break;

        }
        return newDirection;
    }
}
