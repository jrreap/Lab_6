package cisc181.Lab4.java181;

public class ActionMove extends Action {

    public ActionMove(Game181 game, int fromSpaceRow, int fromSpaceColumn,
                      int toSpaceRow, int toSpaceColumn) {
        super(game, fromSpaceRow, fromSpaceColumn, toSpaceRow, toSpaceColumn);
    }

    @Override
    public boolean validAction() {
        if(fromSpaceValid() && toSpaceValid(true)) {
            BoardSpace[][] spaces = game.getBoard().getSpaces();
            return spaces[fromSpaceRow][fromSpaceColumn].getPiece().validPath(
                    fromSpaceRow, fromSpaceColumn, toSpaceRow, toSpaceColumn
            );
        }
        else {
            return false;
        }
    }

    @Override
    public void performAction() {
        BoardSpace[][] spaces = game.getBoard().getSpaces();

        Piece piece = spaces[fromSpaceRow][fromSpaceColumn].removePiece();
        spaces[toSpaceRow][toSpaceColumn].setPiece(piece);

        game.changeTurn();
    }
}
