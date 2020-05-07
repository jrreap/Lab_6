package cisc181.Lab4.java181;

public class ActionMove extends Action {

    public ActionMove(Game181 game, int fromSpaceRow, int fromSpaceColumn, int toSpaceRow, int toSpaceColumn) {
        super(game, fromSpaceRow, fromSpaceColumn, toSpaceRow, toSpaceColumn);
    }

    @Override
    public boolean validAction() {
        if(fromSpaceValid() && toSpaceValid(true)) {
            BoardSpace[][] spaces = game.getBoard().getSpaces();
            return spaces[fromSpaceRow][fromSpaceCol].getPiece().validPath(fromSpaceRow, fromSpaceCol, toSpaceRow, toSpaceCol);
        }
        else {
            return false;
        }
    }

    @Override
    public void performAction() {
        BoardSpace[][] spaces = game.getBoard().getSpaces();

        Piece piece = spaces[fromSpaceRow][fromSpaceCol].removePiece();
        spaces[toSpaceRow][toSpaceCol].setPiece(piece);

        if((piece == game.currentTerminator1.getPiece()) || (piece == game.currentTerminator2.getPiece())){
            if(game.getCurrentTeam() == game.team1){
                game.currentTerminator1 = spaces[toSpaceRow][toSpaceCol];
            }
            else{
                game.currentTerminator2 = spaces[toSpaceRow][toSpaceCol];
            }
        }

        game.changeTurn();
    }
}
