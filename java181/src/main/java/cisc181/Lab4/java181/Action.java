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
        if(game.getBoard().inBounds(fromSpaceRow, fromSpaceColumn)){
            if(game.turn.contains()){
                valid = true;
            }
        }
        return valid;
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


}
