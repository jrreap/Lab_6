package cisc181.Lab4.java181;

public class ActionReviver extends Action {
    public ActionReviver(Game181 game, int fromRow, int fromCol, int toRow, int toCol){
        super(game, fromRow, fromCol,toRow, toCol);
    }

    public boolean validAction() {
        Team currentTeam = game.getCurrentTeam();
        return false;
    }

    public void performAction(){}
}
