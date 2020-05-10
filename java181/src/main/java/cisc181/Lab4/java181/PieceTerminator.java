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

    public void PrintHealth(){
        if( getHealth() == 2){
            System.out.println("The terminator is at full health needing " + getHealth() + " attacks to be taken down");
        }
        else{System.out.println("The terminator is weaken only taking 1 attack to be taken down");}
    }

    public void PrintConviction(){
        if(getConviction() == 2){
            System.out.println("The terminator is at full conviction needing " + getConviction() + " attacks to be taken down");
        }
        else{System.out.println("The terminator is weaken only taking 1 recruit to be taken down");}
    }

    public int getNumAttacked() {
        return numAttacked;
    }

    public void incrementNumAttacked(){
        this.numAttacked++;
    }
}
