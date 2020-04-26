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

    public boolean fromSpaceVaild(){
        boolean valid = false;
        if(game.board.inBounds(fromSpaceRow, fromSpaceColumn)){
            if(game.turn)
        }
    }
}
