package cisc181.Lab4.java181;

import java.util.ArrayList;

public class ActionMove extends Action {

    public ActionMove(Game181 game, int fromSpaceRow, int fromSpaceColumn,
                      int toSpaceRow, int toSpaceColumn) {
        super(game, fromSpaceRow, fromSpaceColumn, toSpaceRow, toSpaceColumn);
    }

    @Override
    public boolean validAction() {
        if(fromSpaceVaild() && toSpaceValid(true)) {
            BoardSpace[][] spaces = game.getBoard().getSpaces();
            return spaces[fromSpaceRow][fromSpaceCol.getPiece().validPath(
                    fromSpaceRow, fromSpaceColumn, toSpaceRow, toSpaceColumn
            );
        }
        else {
            return false;
        }
    }

    @Override
    public boolean performAction;
}
