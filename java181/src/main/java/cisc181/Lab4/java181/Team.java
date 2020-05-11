package cisc181.Lab4.java181;

import java.util.ArrayList;

public class Team {
    private String name;
    private String color;
    private FortressBoardSpace Fortress;
    private BoardSpace currentTerminator;

    private ArrayList<Piece> pieces;
    private ArrayList<Piece> diedPieces;
    private Piece previousPiece;


    public Team(String name, String color, ArrayList<Piece> pieces){
        this.name = name;
        this.color = color;
        this.pieces = pieces;
        this.diedPieces = new ArrayList<>();
        this.previousPiece = null;
        this.Fortress = new FortressBoardSpace();
    }

    public String getTeamName() {
        return name;
    }

    public FortressBoardSpace getFortress() {
        return Fortress;
    }

    public void setFortress(FortressBoardSpace fortress) {
        Fortress = fortress;
    }

    public BoardSpace getCurrentTerminator() {
        return currentTerminator;
    }

    public void setCurrentTerminator(BoardSpace currentTerminator1) {
        this.currentTerminator = currentTerminator1;
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

    public void setPreviousPiece(Piece previousPiece) {
        this.previousPiece = previousPiece;
    }

    public Piece getPreviousPiece() {
        return previousPiece;
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
