package cisc181.Lab4.java181;

public class ActionMove extends Action {

    public ActionMove(Game181 game, int fromSpaceRow, int fromSpaceColumn, int toSpaceRow, int toSpaceColumn) {
        super(game, fromSpaceRow, fromSpaceColumn, toSpaceRow, toSpaceColumn);
    }

    @Override
    public boolean validAction() {
        if(fromSpaceValid() && toSpaceValid(true) && (game.getPerviousPiece() != game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece())) {
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
        Piece piece = spaces[fromSpaceRow][fromSpaceCol].getPiece();
        spaces[fromSpaceRow][fromSpaceCol].removePiece();
        game.setPerviousPiece(piece);
        // this is so that we can keep track of the terminator piece to determine if the piece exists or not
        if(piece instanceof PieceTerminator){
            if(game.getCurrentTeam() == game.team1){
                //this sets the currentTerminator1 boardspace to the new terminator boardspace to keep track of it
                game.currentTerminator1 = spaces[toSpaceRow][toSpaceCol];
                spaces[toSpaceRow][toSpaceCol].setPiece(piece);
                //this sets the piece to the cooldown piece
            }
            else{
                //this keeps track of the piece to make sure it exists
                game.currentTerminator2 = spaces[toSpaceRow][toSpaceCol];
                spaces[toSpaceRow][toSpaceCol].setPiece(piece);
                // this sets the piece to the cooldown piece
            }
        }
        else{
            spaces[toSpaceRow][toSpaceCol].setPiece(piece);
        }

        game.changeTurn();
    }
}
