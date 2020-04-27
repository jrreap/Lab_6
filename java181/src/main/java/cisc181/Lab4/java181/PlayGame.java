package cisc181.Lab4.java181;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayGame {
    private Game181 game;

    public PlayGame(Game181 game) {
        this.game = game;
    }

    public static void main(String args[]) {
        // Create 3 pieces for Team A
        Piece nemoA = new PieceSharkBait("Nemo","Red");
        Piece blueHenA = new PieceBlueHen("Hen ","Red",0,0);
        Piece penguinA = new PiecePenguin("Peng","Red",0,0);

        // Create an array list to hold Team A's pieces
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(nemoA);
        piecesTeamA.add(blueHenA);
        piecesTeamA.add(penguinA);

        // Create 3 pieces for Team B
        Piece nemoB = new PieceSharkBait("Nemo","Green");
        Piece blueHenB = new PieceBlueHen("Hen ","Green",0,0);
        Piece penguinB = new PiecePenguin("Peng","Green",0,0);

        // Create an array list to hold Team B's pieces
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(nemoB);

        piecesTeamB.add(blueHenB);
        piecesTeamB.add(penguinB);

        // Create TeamA and TeamB objects and pass them the array lists of pieces
        Team teamA = new Team("A", "Red",piecesTeamA);
        Team teamB = new Team("B",  "Green",piecesTeamB);

        // Create an instance of the game
        Game181 ourGame = new Game181(4, 4,teamA, teamB);

        // Print Board at start of game
        System.out.println(ourGame.getBoard().toString());
        // Create PlayGame object and play the game
        PlayGame play = new PlayGame(ourGame);
        play.playOurGame();
    }

    private char getValidActionType(Scanner scanner) {
        char returnValue = ' ';
        String character = "";

        System.out.println("M:move A:attack R:recruit");
        character = scanner.nextLine();
        returnValue = character.charAt(0);

        return returnValue;
    }

    private void nextPlayersAction() {
        Scanner scanner = new Scanner(System.in);

        char action = ' ';

        while(action != 'M' && action != 'A' && action != 'R') {
            action = getValidActionType(scanner);
        }

        boolean notValidturn = true;

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
        while(!game.isGameEnded()) {
            nextPlayersAction();
            System.out.print(game.toString());
        }

        String output = String.format("The game has ended and team %s won!", game.getWinner());
        System.out.println(output);
    }
}
