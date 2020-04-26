package cisc181.Lab4.java181;

public abstract class Action {
    private Game181 game;
    private int fromSpaceRow;
    private int fromSpaceColumn;
    private int toSpaceRow;
    private int toSpaceColumn;

    public Action(Game181 game, int fromSpaceRow, int fromSpaceColumn,
                  int toSpaceRow, int toSpaceColumn) {
        this.game = game;
        this.fromSpaceRow = fromSpaceRow;
        this.fromSpaceColumn = fromSpaceColumn;
        this.toSpaceColumn = toSpaceColumn;
        this.toSpaceRow = toSpaceRow;
    }

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
