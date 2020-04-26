package cisc181.Lab4.java181;

import java.util.ArrayList;

public class Team {
    private String name;
    private String color;

    private ArrayList<Piece> pieces;

    public Team(String name, String color, ArrayList<Piece> pieces){
        this.name = name;
        this.color = color;
        this.pieces = pieces;
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

    public void removePieceFromTeam(Piece piece){
        pieces.remove(piece);
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