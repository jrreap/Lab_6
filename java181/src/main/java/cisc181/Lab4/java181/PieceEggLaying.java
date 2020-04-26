package cisc181.Lab4.java181;

public abstract class PieceEggLaying extends Piece {

    protected int numEggs;
    final public static int MAX_EGGS = 2;

    // Constructor that calls the Piece super constructor and sets the number of eggs.
    public PieceEggLaying(String symbol, String color, int numEggs){
        super(symbol, color);
        this.numEggs = numEggs;
    }

    // Returns the total number of eggs this piece has laid
    public int getNumEggs()  {
        return this.numEggs;
    }

    // Increments the number of eggs this piece has laid
    public void incrementNumEggs( ){
        this.numEggs++;
    }

    // Abstract method that handles functionality for the piece to lay an egg
    public abstract PieceEggLaying layEgg();

}
