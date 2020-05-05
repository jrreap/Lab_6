package cisc181.Lab4.java181;

public class PieceSaraConnor extends Piece implements Recruiter {
    boolean hidden;

    public PieceSaraConnor(String symbol, String color, int numAttack){
        super(symbol,color);
        hidden = false;
    }

    public PieceSaraConnor (String symbol){
        this(symbol,"",0);
    }

    public void speak(){
        System.out.println("Come with me if you want to live");
    }

    public boolean validPath(int fromRow, int fromCol, int toRow, int toCol) {
        boolean returnValue = false;
        if (fromRow == toRow) {
            if (fromCol != toCol) {
                returnValue = true;
            }
        }
        if (fromCol == toCol) {
            if (fromCol != toCol) {
                returnValue = true;
            }
        }
        return returnValue;
    }

    public void recruit(int fromRow, int FromCol, int toRow, int toCol){
        this.speak();
        System.out.println("Join the human resistance against the terminators");
    }
}
