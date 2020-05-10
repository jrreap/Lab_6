package cisc181.Lab4.java181;
import java.util.Random;

public class ActionReviver extends Action {
    public ActionReviver(Game181 game, int fromRow, int fromCol, int toRow, int toCol){
        super(game, fromRow, fromCol,toRow, toCol);
    }

    public boolean validAction() {
        int teamSize = game.getCurrentTeam().getDiedPieces().size();

        if(game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece() instanceof PieceSaraConnor) {
            if ((teamSize >= 1) && ((game.getCurrentTeam().getPreviousPiece() != game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece())
                    || (game.getCurrentTeam().getTeamPieces().size() == 1))) {
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public void performAction(){
        int diedPieceLength = game.getCurrentTeam().getDiedPieces().size();
        Random rand= new Random();

        BoardSpace revivedPieceSpace = game.getBoard().findRandomEmptySpace();
        int randomIndex = rand.nextInt(diedPieceLength);

        Piece piece = game.getCurrentTeam().getDiedPieces().get(randomIndex);
        game.getCurrentTeam().getTeamPieces().add(piece);
        game.getCurrentTeam().getDiedPieces().remove(piece);
        revivedPieceSpace.setPiece(piece);
        game.getCurrentTeam().setPreviousPiece(game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece());
    }
}
