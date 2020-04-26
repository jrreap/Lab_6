package cisc181.Lab4.java181;


public class PieceSharkBait extends Piece implements Recruiter {

    // Constructor that sets the symbol and color for this piece. Also sets the default hidden flag.
    public PieceSharkBait(String symbol, String color){
        super(symbol, color);
        this.hidden = false;
    }

    // constructor for when color information is not available yet
    public PieceSharkBait(String symbol){
        this(symbol,"");
    }

    // Method that prints a string to the console to have the piece "speak"
    public void speak(){
        System.out.println("Shark bait oooh ha haa!");
    }

    // Returns what a valid movement path can be for this piece
    public boolean validPath(int curRow, int curCol, int movRow, int movCol) {
        if (curRow + 2 == movRow || curRow - 2 == movRow){
            if (curCol + 2 == movCol || curCol - 2 == movCol){
                return true;
            }
        }
        return false;
    }

    // Recruits a piece and switches it to the current player's team. Moves them to a different row and col.
    public void recruit(int fromRow, int fromCol, int toRow, int toCol){
        this.speak();
        System.out.println("Come to our side... we have cookies!");
    }
}

