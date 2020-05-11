package cisc181.Lab4.java181;

import java.util.Collections;

public abstract class Game {
    // since only one piece can move at a time, this is the cool down function
    protected Board board;
    protected Team team1;
    protected Team team2;
    protected String turn;

    public Game(int rows, int columns, Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
        this.turn = team1.getTeamName();

        initializeGameBoard(rows, columns);
    }

    public Team getTeam2() {
        return team2;
    }

    public Team getTeam1() {
        return team1;
    }

    //this handles the fortress

    private void initializeGameBoard(int numRows, int numCols) {
        this.board = new Board(numRows, numCols);
        //this creates a fortress from a random boardSpace

        for (Piece p : team1.getTeamPieces()){
            getTeam1().getFortress().setFortress(board.findRandomEmptySpace());
            BoardSpace space = board.findRandomEmptySpace();
            space.setPiece(p);
            //this handles if the piece PieceTerminator
            if(p instanceof PieceTerminator){
                getTeam1().setCurrentTerminator(space);
            }
        }

        for (Piece p : team2.getTeamPieces()){
            getTeam2().getFortress().setFortress(board.findRandomEmptySpace());
            BoardSpace space = board.findRandomEmptySpace();
            space.setPiece(p);
            //this handles if the piece is PieceTerminator
            if(p instanceof PieceTerminator){
                getTeam2().setCurrentTerminator(space);
            }
        }
    }

    public Board getBoard() {
        return board;
    }

    public Team getCurrentTeam(){
        if (team1.getTeamName().equals(turn)){
            return team1;
        } else { return team2; }
    }


    public Team getOpponentTeam(){
        if (!(team1.getTeamName().equals(turn))){
            return team1;
        } else{return team2;}
    }

    public boolean isTurn(Team team){
        return team.getTeamName().equals(turn);
    }

    public void changeTurn(){
        if (team1.getTeamName().equals(turn)){
            turn = team2.getTeamName();
        }
        else {turn = team1.getTeamName();}
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
