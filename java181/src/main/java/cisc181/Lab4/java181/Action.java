package cisc181.Lab4.java181;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Action {
    protected Game181 game;
    protected int fromSpaceRow;
    protected int fromSpaceCol;
    protected int toSpaceRow;
    protected int toSpaceCol;

    public Action(Game181 game, int fromSpaceRow, int fromSpaceCol,
                  int toSpaceRow, int toSpaceCol) {
        this.game = game;
        this.fromSpaceRow = fromSpaceRow;
        this.fromSpaceCol = fromSpaceCol;
        this.toSpaceCol = toSpaceCol;
        this.toSpaceRow = toSpaceRow;
    }

    public boolean fromSpaceValid(){
        if(game.getBoard().inBounds(fromSpaceRow, fromSpaceCol)){
            BoardSpace[][] spaces = game.getBoard().getSpaces();
            ArrayList<Piece> team = game.getCurrentTeam().getTeamPieces();

            if(team.contains(spaces[fromSpaceRow][fromSpaceCol].getPiece())) {
                return true;
            }
        }

        return false;
    }

    public boolean toSpaceValid(boolean beEmpty){
        BoardSpace[][] spaces = game.getBoard().getSpaces();
        ArrayList<Piece> team = game.getOpponentTeam().getTeamPieces();

        if(game.getBoard().inBounds(toSpaceRow, toSpaceCol)){
            if(beEmpty){
                if(spaces[toSpaceRow][toSpaceCol].isEmpty()){
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                if(team.contains(spaces[toSpaceRow][toSpaceCol].getPiece())){
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
        Piece piece = spaces[fromSpaceRow][fromSpaceCol].getPiece();
        return piece.validPath(fromSpaceRow, fromSpaceCol, toSpaceRow, toSpaceCol);
    }

    public abstract boolean validAction();

    public abstract void performAction();
}
