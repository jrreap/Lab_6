package cisc181.Lab4.java181;

public class Game181 extends Game {
    public Game181(int rows, int cols, Team team1, Team team2){
        super(rows, cols, team1, team2);
    }

    @Override
    public boolean isAWinner() {
        if (isGameEnded()) {
            if(team1.getTeamPieces().size() > 0 && team2.getTeamPieces().size() == 0) {
                return true;
            }
            else if (team2.getTeamPieces().size() > 0 && team1.getTeamPieces().size() == 0) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    @Override
    public Team getWinner() {
        if (isAWinner()){
            if (team1.getTeamPieces().size() > 0){
                return team1;
            }
            else {
                return team2;
            }
        }
        else {
            return null;
        }
    }

    @Override
    public boolean isGameEnded() {
        Piece terminator1 = currentTerminator1.getPiece();
        Piece terminator2 = currentTerminator2.getPiece();
        if((!team1.getTeamPieces().contains(terminator1))||(team2.getTeamPieces().contains(terminator2))){
                return true;
        }
        else {
            return false;
        }
    }
}
