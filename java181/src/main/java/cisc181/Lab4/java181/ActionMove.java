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
        if(spaces[toSpaceRow][toSpaceCol] == game.getCurrentTeam().getFortress().getFortress()){
            System.out.println("The fortress rises around " + piece.getSymbol() + " defending against all attacks and recruits");
            if(piece instanceof PieceTerminator){
                game.getCurrentTeam().getFortress().reconstruct();
                System.out.println("The Fortress is Greatly Strengthen now needing" + game.getCurrentTeam().getFortress().getFortressHealth() + " attacks to bring it down");
                spaces[toSpaceRow][toSpaceCol].setPiece(piece);
                game.getCurrentTeam().setCurrentTerminatorBoardSpace(spaces[toSpaceRow][toSpaceCol]);
            }
            else{
                spaces[toSpaceRow][toSpaceCol].setPiece(piece);
            }
        }
        // this is so that we can keep track of the terminator piece to determine if the piece exists or not
        else if(spaces[toSpaceRow][toSpaceCol] == game.getOpponentTeam().getFortress().getFortress()){
            if(piece instanceof PieceTerminator){
                game.getOpponentTeam().getFortress().attackFortressTerminator();
                ((PieceTerminator)piece).setHealth(((PieceTerminator)piece).getHealth()-1);
                if(game.getOpponentTeam().getFortress().getFortressHealth()>2){
                    System.out.println("The " + game.getCurrentTeam().getTeamName() + "'s Terminator accidentally stepped into the " + game.getOpponentTeam().getTeamName() + "'s fortress");
                    game.getOpponentTeam().getFortress().PrintHealth();
                    ((PieceTerminator)piece).PrintHealth();
                }
                else{
                    game.getOpponentTeam().getFortress().PrintHealth();
                    if(!(spaces[toSpaceRow][toSpaceCol].getPiece() instanceof Piece)){
                        spaces[toSpaceRow][toSpaceCol].setPiece(piece);
                        game.getCurrentTeam().setCurrentTerminatorBoardSpace(spaces[toSpaceRow][toSpaceCol]);
                    }
                    else{
                        spaces[fromSpaceCol][fromSpaceCol].setPiece(piece);
                        game.getCurrentTeam().setCurrentTerminatorBoardSpace(spaces[fromSpaceRow][fromSpaceCol]);
                    }
                }
            }
            else{
                game.getCurrentTeam().getTeamPieces().remove(piece);
                game.getCurrentTeam().getDiedPieces().add(piece);
                System.out.println("The " + game.getCurrentTeam().getTeamName() + "'s "+ spaces[fromSpaceRow][fromSpaceCol].getPiece().getSymbol() + " tried to move into the " + game.getOpponentTeam().getTeamName() + "'s fortress and failed");
            }
        }
        else if(piece instanceof PieceTerminator){
            game.getCurrentTeam().setCurrentTerminatorBoardSpace(spaces[toSpaceRow][toSpaceCol]);
            spaces[toSpaceRow][toSpaceCol].setPiece(piece);
        }
        else{
            spaces[toSpaceRow][toSpaceCol].setPiece(piece);
        }
    }
}
