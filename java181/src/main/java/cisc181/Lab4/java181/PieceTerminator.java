package cisc181.Lab4.java181;

public class PieceTerminator extends Piece implements Attacker {
    // new piece that i copied the blue hen but extends the piece rather than the piece PieceEgglaying
    private int health;
    private int conviction;
    private int numAttacked;

    public PieceTerminator(String symbol, String color, int numAttacked){
        super(symbol, color);
        health = 2;
        conviction = 2;
        this.numAttacked = numAttacked;
        this.hidden = false;
    }

    public PieceTerminator(String symbol){
        this(symbol,"",0);
    }

    public int getConviction() {
        return conviction;
    }

    public void setConviction(int conviction) {
        this.conviction = conviction;
    }

    public void printConviction(){
        if(getConviction() == 1){
            System.out.println(" The Terminator's conviction is weakened and only gets 1 more recruit");
        }
        else {
            System.out.println(" The Terminator was recruited");
        }
    }

    public void printHealth(){
        if(getHealth() == 1){
            System.out.println("The Terminator is weakened an only needs one more attack to kill it");
        }
        else{
            System.out.println(" The Terminator falls");
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void speak(){
        System.out.println("I will be back");
    }

    public boolean validPath(int curRow, int curCol, int movRow, int movCol){
        return true;
    }

    public void attack(int curRow, int curCol, int movRow, int movCol) {
        this.numAttacked++;
        this.speak();
        System.out.println("Are you Sarah Connor?!");
    }

    public int getNumAttacked() {
        return numAttacked;
    }

    public void incrementNumAttacked(){
        this.numAttacked++;
    }
}
