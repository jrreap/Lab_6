package cisc181.Lab4.java181;
import java.util.Scanner;

public class PlayGame {
    Game181 game;

    public PlayGame(Game181 game) {
        this.game = game;
    }

    private char getValidActionType() {
        char returnValue = ' ';
        String character = "";
        Scanner scanner = new Scanner(System.in);
        while ((character != "m") && (character != "r") && (character != "a")) {
            System.out.println("M:move A:attack R:recruit");
            character = scanner.next();
        }
        returnValue = character.charAt(0);
        return returnValue;
    }

    private void nextPlayersAction() {
        char action = getValidActionType();
        boolean notValidturn = true;
        Scanner scanner = new Scanner(System.in);
        while (notValidturn) {
            System.out.println("Enter in the from row");
            int fromRow = scanner.nextInt();
            System.out.println("Enter in the from column");
            int fromColumn = scanner.nextInt();
            System.out.println("Enter in the to row");
            int toRow = scanner.nextInt();
            System.out.println("Enter in the to column");
            int toCol = scanner.nextInt();
            if (action == 'm') {
                ActionMove moving = new ActionMove(game, fromRow, fromColumn, toRow, toCol);
                if (moving.validAction()) {
                    moving.performAction();
                    notValidturn = false;
                }
            } else if (action == 'r') {
                ActionRecruit recruiting = new ActionRecruit(game, fromRow, fromColumn, toRow, toCol);
                if (recruiting.validAction()) {
                    recruiting.performAction();
                    notValidturn = false;
                }
            } else if (action == 'a') {
                ActionAttack attacking = new ActionAttack(game, fromRow, fromColumn, toRow, toCol);
                if (attacking.validAction()) {
                    attacking.performAction();
                    notValidturn = false;
                }
            }
        }
    }

    public void playOurGame() {
        nextPlayersAction();
        BoardSpace[][] space = game.getBoard().getSpaces();
        Piece piece =
    }
}
