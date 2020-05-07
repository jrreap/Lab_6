package cisc181.Lab4.java181;

import java.util.Collections;

public abstract class Game {
    protected Board board;
    protected Team team1;
    protected Team team2;
    protected String turn;
    protected BoardSpace currentTerminator1;
    protected BoardSpace currentTerminator2;
    protected BoardSpace Fortress;

    public Game(int rows, int columns, Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
        this.turn = team1.getTeamName();

        initializeGameBoard(rows, columns);
    }

    private void initializeGameBoard(int numRows, int numCols) {
        this.board = new Board(numRows, numCols);
        Fortress = this.board.findRandomEmptySpace();

        for (Piece p : team1.getTeamPieces()){
            BoardSpace space = board.findRandomEmptySpace();
            space.setPiece(p);
            if(p.getSymbol() == "Terminator"){
                currentTerminator1 = space;
            }
        }

        for (Piece p : team2.getTeamPieces()){
            BoardSpace space = board.findRandomEmptySpace();
            space.setPiece(p);
            if(p.getSymbol() == "Terminator"){
                currentTerminator2 = space;
            }
        }
    }

    public Board getBoard() {
        return board;
    }

    public Team getCurrentTeam(){
        if (team1.getTeamName().equals(turn)){
            return team1;
        }
        else {
            return team2;
        }
    }

    public Team getOpponentTeam(){
        if (!(team1.getTeamName().equals(turn))){
            return team1;
        }
        else {
            return team2;
        }
    }

    public boolean isTurn(Team team){
        return team.getTeamName().equals(turn);
    }

    public void changeTurn(){
        if (team1.getTeamName().equals(turn)){
            turn = team2.getTeamName();
        }
        else {
            turn = team1.getTeamName();
        }
    }

    // Abstract methods

    public abstract boolean isAWinner();

    public abstract Team getWinner();

    public abstract boolean isGameEnded();

    // Overrides

    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\n" + getBoard().toString())
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamName() + "'s turn\n");
        return retString.toString();
    }

}
