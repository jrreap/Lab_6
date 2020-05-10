package cisc181.Lab4.java181;

import java.util.ArrayList;

public class Team {
    private String name;
    private String color;

    private ArrayList<Piece> pieces;
    private ArrayList<Piece> diedPieces;

    private FortressBoardSpace Fortress;
    private BoardSpace CurrentTerminatorBoardSpace;

    public Team(String name, String color, ArrayList<Piece> pieces){
        this.name = name;
        this.color = color;
        this.pieces = pieces;
        this.diedPieces = null;
    }

    public void setCurrentTerminatorBoardSpace(BoardSpace currentTerminatorBoardSpace) {
        CurrentTerminatorBoardSpace = currentTerminatorBoardSpace;
    }

    public FortressBoardSpace getFortress() {
        return Fortress;
    }

    public void setFortress(FortressBoardSpace fortress) {
        Fortress = fortress;
    }

    public String getTeamName() {
        return name;
    }

    public String getTeamColor() {
        return color;
    }

    public ArrayList<Piece> getTeamPieces() {
        return pieces;
    }

    public ArrayList<Piece> getDiedPieces() {
        return diedPieces;
    }

    public void removePieceFromTeam(Piece piece){
        pieces.remove(piece);
        diedPieces.add(piece);
    }

    public void addPieceToTeam(Piece piece){
        piece.setColor(color);
        pieces.add(piece);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Team %s : %s", this.getTeamName(), this.getTeamColor()));
        sb.append("\n");
        sb.append("Pieces :");

        for (Piece p : pieces){
            sb.append(" " + p.toString());
        }

        return sb.toString();
    }
}
