package cisc181.Lab4.java181;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void gameTests() throws Exception {

        System.out.println("Testing Game");

        // Create 3 pieces for team A
        Piece nemoA = new PieceSharkBait("Nemo","Red");
        Piece blueHenA = new PieceBlueHen("Hen ","Red",0,0);
        Piece penguinA = new PiecePenguin("Peng","Red",0,0);

        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(nemoA);
        piecesTeamA.add(blueHenA);
        piecesTeamA.add(penguinA);

        // Create 3 pieces for team B
        Piece nemoB = new PieceSharkBait("Nemo","Green");
        Piece blueHenB = new PieceBlueHen("Hen ","Green",0,0);
        Piece penguinB = new PiecePenguin("Peng","Green",0,0);

        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(nemoB);
        piecesTeamB.add(blueHenB);
        piecesTeamB.add(penguinB);

        Team teamA = new Team("UD", "Red",piecesTeamA);
        Team teamB = new Team("PJ",  "Green",piecesTeamB);

        Game181 ourGame = new Game181(4, 4,teamA, teamB);
        System.out.println(ourGame.toString());
    }
}