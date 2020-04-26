package cisc181.Lab4.java181;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
        if(game.getBoard().inBounds(fromSpaceRow, fromSpaceColumn)){
            BoardSpace[][] spaces = game.getBoard().getSpaces();
            ArrayList<Piece> team = game.getCurrentTeam().getTeamPieces();

            if(team.contains(spaces[fromSpaceRow][fromSpaceColumn].getPiece())) {
                return true;
            }
        }

        return false;
    }
}
