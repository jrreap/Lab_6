package cisc181.Lab4.java181;
import java.util.Random;

public class ActionReviver extends Action {
    public ActionReviver(Game181 game, int fromRow, int fromCol, int toRow, int toCol){
        super(game, fromRow, fromCol,toRow, toCol);
    }

    public boolean validAction() {
        Team currentTeam = game.getCurrentTeam();
        int teamSize = currentTeam.getDiedPieces().size();
        if(!(teamSize <=1)){
            return true;
        }
        return false;
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
    }
}
