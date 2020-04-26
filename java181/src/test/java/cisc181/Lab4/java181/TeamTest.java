package cisc181.Lab4.java181;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class TeamTest {
    @Test
    public void getTeamName() throws Exception {

        System.out.println("Testing Team class");
        Piece nemoA = new PieceSharkBait("Nemo","Red");
        Piece blueHenA = new PieceBlueHen("Hen ","Red",0,0);
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(nemoA);
        piecesTeamA.add(blueHenA);

        Piece nemoB = new PieceSharkBait("Nemo","Green");
        Piece penguinB = new PiecePenguin("Peng","Green",0,0);
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(nemoB);
        piecesTeamB.add(penguinB);

        Team teamA = new Team("CISC", "Red",piecesTeamA);
        Team teamB = new Team("181",  "Green",piecesTeamB);

        // check teamA
        assertEquals("CISC",teamA.getTeamName());
        assertEquals("Red",teamA.getTeamColor());
        assertEquals(2,teamA.getTeamPieces().size());
        assertTrue(teamA.getTeamPieces().contains(nemoA));
        assertTrue(teamA.getTeamPieces().contains(blueHenA));
        assertFalse(teamA.getTeamPieces().contains(nemoB));
        assertFalse(teamA.getTeamPieces().contains(penguinB));

        // check teamB
        assertEquals("181",teamB.getTeamName());
        assertEquals("Green",teamB.getTeamColor());
        assertEquals(2,teamB.getTeamPieces().size());
        assertTrue(teamB.getTeamPieces().contains(nemoB));
        assertTrue(teamB.getTeamPieces().contains(penguinB));
        assertFalse(teamB.getTeamPieces().contains(nemoA));
        assertFalse(teamB.getTeamPieces().contains(blueHenA));

        // remove a Piece from teamA and put on Team B
        teamA.removePieceFromTeam(nemoA);
        teamB.addPieceToTeam(nemoA);
        // check team B pieces
        assertEquals(3,teamB.getTeamPieces().size());
        assertTrue(teamB.getTeamPieces().contains(nemoA));
        assertTrue(teamB.getTeamPieces().contains(nemoB));
        assertTrue(teamB.getTeamPieces().contains(penguinB));
        assertFalse(teamB.getTeamPieces().contains(blueHenA));
        //check that nemoA color was changed
        assertEquals(teamB.getTeamColor(),nemoA.getColor());

        // check team A pieces
        assertEquals(1,teamA.getTeamPieces().size());
        assertTrue(teamA.getTeamPieces().contains(blueHenA));
        assertFalse(teamA.getTeamPieces().contains(nemoA));
        assertFalse(teamA.getTeamPieces().contains(nemoB));
        assertFalse(teamA.getTeamPieces().contains(penguinB));

        System.out.println(teamA.toString());
        System.out.println(teamB.toString());
    }
}