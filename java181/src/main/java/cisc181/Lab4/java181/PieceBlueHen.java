package cisc181.Lab4.java181;

public class PieceBlueHen extends PieceEggLaying implements Attacker{

    private boolean fly;
    private int numAttacked;

    public PieceBlueHen(String symbol, String color, int numEggs, int numAttacked){
        super(symbol, color, numEggs);
        this.numAttacked = numAttacked;
        this.hidden = false;
        updateFly();
    }

    // constructor for when color information not available yet
    // and brand new piece that hasn’t laid eggs and hasn’t attacked
    public PieceBlueHen(String symbol){
        this(symbol,"",0,0);
    }

    // Method that prints a string to the console to have the piece "speak"
    public void speak(){
        System.out.println("Go UD!");
    }

    // Returns the number of pieces this piece has attacked
    public int getNumAttacked()  {
        return this.numAttacked;
    }

    // Returns if this BlueHen can fly
    public boolean canFly ()  {
        return this.fly;
    }

    @Override
    // Override of the incrementNumEggs method from the PieceEggLaying class
    public void incrementNumEggs( ){
        this.numEggs++;
        updateFly();
    }

    // Increments the number of attacked pieces and updates the fly flag
    public void incrementNumAttacked( ){
        this.numAttacked++;
        updateFly();
    }

    // Returns what a valid movement path can be for this piece
    public boolean validPath(int curRow, int curCol, int movRow, int movCol) {
        if (canFly()){
            return true;
        }
        else {
            if (curRow + 1 == movRow && curCol == movCol){
                return true;
            }
            else if (curRow - 1 == movRow && curCol == movCol){
                return true;
            }
            else if (curCol + 1 == movCol && movRow == curRow){
                return true;
            }
            else if (curCol - 1 == movCol && movRow == curRow){
                return true;
            }
            else {
                return false;
            }
        }
    }

    // Attacks the piece and increments the number of pieces attacked
    public void attack(int fromRow, int fromCol, int toRow, int toCol){
        this.incrementNumAttacked();
        this.speak();
        System.out.println("Uses Blue Hen powers!");
    }

    // Lays an egg that contains a copy of this piece. Assuming it is less than the MAX_EGGS constant.
    public PieceBlueHen layEgg(){
        // if this piece hasn't laid max eggs yet - allow it create new piece
        if( this.numEggs < MAX_EGGS){
            this.incrementNumEggs();
            // creates a new piece that has the same number of eggs laid and attacked pieces
            // as this piece
            return new PieceBlueHen(this.symbol,this.color,this.numEggs,this.numAttacked);
        }
        else{
            return null;
        }
    }

    // Updates the fly flag for this piece
    private void updateFly( ) {
        if (this.numEggs < MAX_EGGS) {
            this.fly = true;
        } else if (this.numAttacked == 0) {
            this.fly = true;
        } else {
            this.fly = false;
        }
    }

}

