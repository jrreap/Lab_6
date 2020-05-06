package cisc181.Lab4.java181;

public abstract class Piece {
    protected int coolDownTimer = 0;
    // Set them to protected since we want child classes to have access to these fields.
    protected String symbol;
    protected String color;
    protected boolean hidden; // represents whether this piece is visible or hidden

    // Main constructor that initializes the properties for this class
    public Piece (String symbol, String color) {
        this.symbol = symbol;
        this.color = color;
    }

    // Method that will return a string value of the piece "speaking"
    public abstract void speak();

    // Returns the path that this piece can move
    public abstract boolean validPath(int curRow, int curCol, int movRow, int movCol);

    // Returns the symbol this particular piece has
    public String getSymbol() {
        return symbol;
    }

    // Returns the color of this particular piece
    public String getColor() {
        return color;
    }

    // Sets the color of this piece to the passed in parameter. Takes in a string.
    public void setColor(String color){
        this.color = color;
    }

    // Returns if this piece has the hidden flag set or not
    public boolean isHidden() {
        return hidden;
    }

    // Sets the hidden flag based on the passed in parameter
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    // Override that returns the first character of the color string with a dash and the symbol
    // appended into one single string.
    public String toString(){
        return color.charAt(0) + "-" + symbol;
    }

}
