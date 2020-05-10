package cisc181.Lab4.java181;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayGame {
    private Game181 game;
    // new variables for the project so that there is only one revive available and set the fortress strength to two
    private boolean reviveAvailable = true;
    private int FortressStrength = 2;

    public PlayGame(Game181 game) {
        this.game = game;
    }

    public static void main(String args[]) {
        // Create 3 pieces for Team A
        Piece nemoA = new PieceSharkBait("Nemo","Red");
        Piece blueHenA = new PieceBlueHen("Hen ","Red",0,0);
        Piece penguinA = new PiecePenguin("Peng","Red",0,0);
        // new project code that creates the Terminator and SaraConnor Pieces
        Piece TerminatorA = new PieceTerminator("Term","Red",0);
        Piece SaraConnorA = new PieceSaraConnor("Sara", "Red", 0);

        // Create an array list to hold Team A's pieces
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(nemoA);
        piecesTeamA.add(blueHenA);
        piecesTeamA.add(penguinA);
        // new project code that adds the pieces Terminator and SaraConnor to the teams
        piecesTeamA.add(TerminatorA);
        piecesTeamA.add(SaraConnorA);

        // Create 3 pieces for Team B
        Piece nemoB = new PieceSharkBait("Nemo","Green");
        Piece blueHenB = new PieceBlueHen("Hen ","Green",0,0);
        Piece penguinB = new PiecePenguin("Peng","Green",0,0);
        // new project code that adds pieces Terminator and SaraConor to the teams
        Piece TerminatorB = new PieceTerminator("Term", "Green",0);
        Piece SaraConnorB = new PieceSaraConnor("Sara", "Green", 0);

        // Create an array list to hold Team B's pieces
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(nemoB);
        piecesTeamB.add(blueHenB);
        piecesTeamB.add(penguinB);
        //new project doe that adds pieces Terminator and SaraConnor to the team
        piecesTeamB.add(TerminatorB);
        piecesTeamB.add(SaraConnorB);

        // Create TeamA and TeamB objects and pass them the array lists of pieces
        Team teamA = new Team("A", "Red",piecesTeamA);
        Team teamB = new Team("B",  "Green",piecesTeamB);

        // Create an instance of the game
        Game181 ourGame = new Game181(4, 4,teamA, teamB);

        // Print Board at start of game
        System.out.println(ourGame.toString());
        // Create PlayGame object and play the game
        PlayGame play = new PlayGame(ourGame);
        play.playOurGame();
    }

    private char getValidActionType(Scanner scanner) {
        char returnValue = ' ';
        String character = "";

        System.out.println("M:move A:attack R:recruit E:Revive");
        character = scanner.next();
        returnValue = character.charAt(0);

        return returnValue;
    }

    private void nextPlayersAction() {
        Scanner scanner = new Scanner(System.in);

        char action = ' ';

        while(action != 'M' && action != 'A' && action != 'R'&& action != 'E') {
            action = getValidActionType(scanner);
        }

        boolean notValidturn = true;

        while (notValidturn) {
            int fromRow;
            int fromColumn;
            int toRow;
            int toCol;
            if (action == 'M') {

                System.out.println("Enter in the from row");
                fromRow = scanner.nextInt();
                System.out.println("Enter in the from column");
                fromColumn = scanner.nextInt();
                System.out.println("Enter in the to row");
                toRow = scanner.nextInt();
                System.out.println("Enter in the to column");
                toCol = scanner.nextInt();

                ActionMove moving = new ActionMove(game, fromRow, fromColumn, toRow, toCol);
                if (moving.validAction()) {
                    moving.performAction();
                    notValidturn = false;
                }
                else {
                    System.out.println("Not valid movement!");
                    notValidturn = false;
                }
            }
            else if (action == 'R') {

                System.out.println("Enter in the from row");
                fromRow = scanner.nextInt();
                System.out.println("Enter in the from column");
                fromColumn = scanner.nextInt();
                System.out.println("Enter in the to row");
                toRow = scanner.nextInt();
                System.out.println("Enter in the to column");
                toCol = scanner.nextInt();

                ActionRecruit recruiting = new ActionRecruit(game, fromRow, fromColumn, toRow, toCol);
                if (recruiting.validAction()) {
                    recruiting.performAction();
                    notValidturn = false;
                }
                else {
                    System.out.println("Not valid movement!");
                    notValidturn = false;
                }
            } else if (action == 'A') {

                System.out.println("Enter in the from row");
                fromRow = scanner.nextInt();
                System.out.println("Enter in the from column");
                fromColumn = scanner.nextInt();
                System.out.println("Enter in the to row");
                toRow = scanner.nextInt();
                System.out.println("Enter in the to column");
                toCol = scanner.nextInt();

                ActionAttack attacking = new ActionAttack(game, fromRow, fromColumn, toRow, toCol);
                if (attacking.validAction()) {
                    //new code project code that handles if the toBoardSpace is the fortress
                    attacking.performAction();
                    notValidturn = false;
                }
                else {
                    System.out.println("Not valid movement!");
                    notValidturn = false;
                }
            }
            // new code that creates a new action for SaraConor Piece
            else if (action == 'E'){

                System.out.println("Enter in the from row");
                fromRow = scanner.nextInt();
                System.out.println("Enter in the from column");
                fromColumn = scanner.nextInt();

                ActionReviver reviving = new ActionReviver(game, fromRow, fromColumn,0, 0);
                if(reviving.validAction() && reviveAvailable){
                    reviving.performAction();
                    notValidturn = false;
                    reviveAvailable = false;
                }
                else if (!reviveAvailable){
                    System.out.println("You have no more revives left!");
                    notValidturn = false;
                }
                else{
                    System.out.println("Not valid movement");
                    notValidturn = false;
                }
            }
            else {
                System.out.println("That was not a valid action! Please input one of the below action commands!");
                notValidturn = false;
            }
        }
    }

    public void playOurGame() {
        while(!game.isGameEnded()) {
            nextPlayersAction();
            System.out.println(game.toString());
        }

        String output = String.format("The game has ended and team %s won!", game.getWinner());
        System.out.println(output);
    }
}
