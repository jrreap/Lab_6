package cisc181.Lab4.java181;

public class ActionMove extends Action {

    public ActionMove(Game181 game, int fromSpaceRow, int fromSpaceColumn, int toSpaceRow, int toSpaceColumn) {
        super(game, fromSpaceRow, fromSpaceColumn, toSpaceRow, toSpaceColumn);
    }

    @Override
    public boolean validAction() {
        if(fromSpaceValid() && toSpaceValid(true) && (game.getPreviousPiece() != game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece()|| (game.getCurrentTeam().getTeamPieces().size() ==1))) {
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
        game.setPreviousPiece(piece);
        game.changeTurn();
        if(game.getBoard().getSpaces()[toSpaceRow][toSpaceCol] == game.getFortress()){
            System.out.println("The fortress rises around " + game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece().getSymbol() + " defending against all attacks");
        }
        // this is so that we can keep track of the terminator piece to determine if the piece exists or not
        if(piece instanceof PieceTerminator){
            if(game.isTurn(game.team1)){
                //this sets the currentTerminator1 board space to the new terminator board space to keep track of it
                game.currentTerminator1 = spaces[toSpaceRow][toSpaceCol];
                spaces[toSpaceRow][toSpaceCol].setPiece(piece);
                //this sets the piece to the cool down piece
            }
            else{
                //this keeps track of the piece to make sure it exists
                game.currentTerminator2 = spaces[toSpaceRow][toSpaceCol];
                spaces[toSpaceRow][toSpaceCol].setPiece(piece);
                // this sets the piece to the cool down piece
            }
        }
        else{
            spaces[toSpaceRow][toSpaceCol].setPiece(piece);
        }
    }
}
