package cisc181.Lab4.java181;

public class PiecePenguin extends PieceEggLaying implements Recruiter, Attacker {

    private int numAttacked;


    public PiecePenguin(String symbol, String color, int numEggs, int numAttacked){
        super(symbol, color, numEggs);
        this.numAttacked = numAttacked;
        this.hidden = false;
    }

    // constructor for when color information not available yet
    public PiecePenguin(String symbol){
        this(symbol,"",0,0);
    }

    // Method that prints a string to the console to have the piece "speak"
    public void speak(){
        System.out.println("Smile and wave boys. Smile and wave.");
    }

    // Returns what a valid movement path can be for this piece
    public boolean validPath(int curRow, int curCol, int movRow, int movCol) {

        if(movCol > curCol && curRow == movRow || movCol < curCol && curRow == movRow){
            return true;
        }

        if(curRow + 1 == movRow && movCol == curCol || curRow - 1 == movRow && movCol == curCol){
            return true;
        }

        return false;
    }

    // Attacks the piece and increments the number of pieces attacked
    public void attack(int fromRow, int fromCol, int toRow, int toCol){
        this.numAttacked++;
        this.speak();
        System.out.println("Attack with lasers – other piece removed from game.");
    }

    // Recruits a piece and switches it to the current player's team. Moves them to a different row and col.
    public void recruit(int fromRow, int fromCol, int toRow, int toCol){
        this.speak();
        System.out.println("Skipper! We have a new friend!");
    }

    // Lays an egg that contains a copy of this piece. Assuming it is less than the MAX_EGGS constant.
    public PiecePenguin layEgg(){
        // if this piece hasn't laid max eggs yet - allow it create new piece
        if( this.numEggs < MAX_EGGS){
            this.incrementNumEggs();
            // this creates a new piece that has not laid any eggs
            // and has not attacked any pieces yet it will belong to this team so pass in Color
            return new PiecePenguin(this.symbol, this.color,0,0);
        }
        else{
            return null;
        }
    }

    // Returns the number of pieces this piece has attacked
    public int getNumAttacked()  {
        return this.numAttacked;
    }

    // Increments the number of attacked pieces
    public void incrementNumAttacked( ){
        this.numAttacked++;
    }
}

