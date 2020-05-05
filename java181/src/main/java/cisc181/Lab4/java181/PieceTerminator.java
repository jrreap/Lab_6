package cisc181.Lab4.java181;

public class PieceTerminator extends Piece implements Attacker {
    private int health;
    private int numAttacked;

    public PieceTerminator(String symbol, String color, int numAttacked){
        super(symbol, color);
        health = 2;
        this.numAttacked = numAttacked;
        this.hidden = false;
    }

    public PieceTerminator(String symbol){
        this(symbol,"",0);
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
