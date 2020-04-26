package cisc181.Lab4.java181;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Action {
    protected Game181 game;
    protected int fromSpaceRow;
    protected int fromSpaceColumn;
    protected int toSpaceRow;
    protected int toSpaceColumn;

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

    public boolean toSpaceValid(boolean beEmpty){
        BoardSpace[][] spaces = game.getBoard().getSpaces();
        ArrayList<Piece> team = game.getOpponentTeam().getTeamPieces();

        if(game.getBoard().inBounds(toSpaceRow, toSpaceColumn)){
            if(beEmpty){
                if(spaces[toSpaceRow][toSpaceColumn].isEmpty()){
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                if(team.contains(spaces[toSpaceRow][toSpaceColumn].getPiece())){
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        else {
            return false;
        }
    }

    public boolean validActionPath() {
        BoardSpace[][] spaces = game.getBoard().getSpaces();
        Piece piece = spaces[fromSpaceRow][fromSpaceColumn].getPiece();
        return piece.validPath(fromSpaceRow, fromSpaceColumn, toSpaceRow, toSpaceColumn);
    }

    public abstract boolean validAction();

    public abstract void performAction();
}
