package cisc181.Lab4.java181;

public abstract class Action {
    Game181 game;
    int fromSpaceRow;
    int fromSpaceColumn;
    int toSpaceRow;
    int toSpaceColumn;

    public int getFromSpaceColumn() {
        return fromSpaceColumn;
    }

    public int getFromSpaceRow() {
        return fromSpaceRow;
    }

    public int getToSpaceColumn() {
        return toSpaceColumn;
    }

    public int getToSpaceRow() {
        return toSpaceRow;
    }

    public Game181 getGame() {
        return game;
    }
}
