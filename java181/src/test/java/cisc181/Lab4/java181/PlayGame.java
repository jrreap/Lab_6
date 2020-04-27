package cisc181.Lab4.java181;
import java.util.Scanner;

public class PlayGame {
    Game181 game;

    public PlayGame (Game181 game){
        this.game = game;
    }

    private char getValidActionType() {
        char returnValue = ' ';
        String character = "";
        Scanner scanner = new Scanner(System.in);
        while ((character != "m") && (character != "r") && (character != "a")) {
            System.out.println("Please enter either a m, r , or a key value");
            character = scanner.next();
        }
        if (character == "m") {
            System.out.println("player moves piece from from space selected to the to space selected");
            System.out.println("from space must contain a piece belonging to team making the move");
            System.out.println("to space must by empty");
            returnValue = 'm';
        } else if (character == "r") {
            System.out.println("player selects piece from from space selected to recruit the piece in the to space selected");
            System.out.println("from space must contain a piece belonging to team whose turn it is -this piece must have the ability to recruit");
            System.out.println("to space must contain a piece belonging to the other team");
            returnValue = 'r';
        } else if (character == "a") {
            System.out.println("player selects piece from from space selected to attack the piece in the to space selected");
            System.out.println("from space must contain a piece belonging to team whose turn it is -this piece must have the ability to attack");
            System.out.println("to space must contain a piece belonging to the other team");
            returnValue = 'a';
        }
        return returnValue;
    }

    private void nextPlayersAction(){
        char action = getValidActionType();
        boolean notValidturn = true;
        Scanner scanner = new Scanner(System.in);
        while(notValidturn) {
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
            }
            else if (action == 'r') {
                ActionRecruit recruiting = new ActionRecruit(game, fromRow, fromColumn, toRow, toCol);
                if (recruiting.validAction()) {
                    recruiting.performAction();
                    notValidturn = false;
                }
            }
            else if (action == 'a') {
                ActionAttack attacking = new ActionAttack(game, fromRow, fromColumn, toRow, toCol);
                if (attacking.validAction()) {
                    attacking.performAction();
                    notValidturn = false;
                }
            }
        }
    }
    public void playOurGame(){
        nextPlayersAction();
    }
}