package cisc181.Lab4.java181;

public class ActionMove extends Action {

    public ActionMove(Game181 game, int fromSpaceRow, int fromSpaceColumn, int toSpaceRow, int toSpaceColumn) {
        super(game, fromSpaceRow, fromSpaceColumn, toSpaceRow, toSpaceColumn);
    }

    @Override
    public boolean validAction() {
        if(fromSpaceValid() && toSpaceValid(true) && (game.getCurrentTeam().getPreviousPiece() != game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece()|| (game.getCurrentTeam().getTeamPieces().size() ==1))) {
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
        game.getCurrentTeam().setPreviousPiece(piece);
        game.changeTurn();
        if(game.getBoard().getSpaces()[toSpaceRow][toSpaceCol] == game.getCurrentTeam().getFortress().getFortress()){
            System.out.println("The fortress rises around " + game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece().getSymbol() + " defending against all attacks");
            if(piece instanceof PieceTerminator){
                game.getCurrentTeam().getFortress().reconstruct();
                System.out.println("The Fortress is Greatly Strengthen now needing" + game.getCurrentTeam().getFortress().getFortressHealth() + " attacks to bring it down");
            }
        }
        else if(spaces[toSpaceRow][toSpaceCol] == game.getOpponentTeam().getFortress().getFortress()){
            if(piece instanceof PieceTerminator){
                game.getCurrentTeam().getFortress().attackFortress(piece);
                ((PieceTerminator)piece).setHealth(((PieceTerminator)piece).getHealth() -1);
                game.getOpponentTeam().getFortress().printFortressHealth();
                ((PieceTerminator)piece).printHealth();
                if(game.getOpponentTeam().getFortress().getFortressHealth() >0 && !(spaces[toSpaceRow][fromSpaceCol].getPiece() instanceof Piece)){
                    spaces[toSpaceRow][toSpaceRow].setPiece(piece);
                    game.getCurrentTeam().setCurrentTerminator(spaces[toSpaceRow][toSpaceCol]);
                }
                else{
                    spaces[fromSpaceRow][fromSpaceCol].setPiece(piece);
                    System.out.println("The Terminator failed to move to " + game.getCurrentTeam().getTeamName() + " fortress");}
            }
            else{
                game.getCurrentTeam().removePieceFromTeam(piece);
                spaces[fromSpaceRow][fromSpaceCol].removePiece();
                System.out.println("The " + game.getCurrentTeam().getTeamName() + "'s " + piece.getSymbol() + " to move the " + game.getOpponentTeam().getTeamName() + "s fortress and failed");
            }

        }
        // this is so that we can keep track of the terminator piece to determine if the piece exists or not
        else if(piece instanceof PieceTerminator){
            spaces[toSpaceRow][toSpaceCol].setPiece(piece);
            game.getCurrentTeam().setCurrentTerminator(spaces[toSpaceRow][toSpaceCol]);
            }
        else{
            spaces[toSpaceRow][toSpaceCol].setPiece(piece);
        }
    }
}
