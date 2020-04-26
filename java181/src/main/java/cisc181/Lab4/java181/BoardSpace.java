package cisc181.Lab4.java181;

public class BoardSpace {
    private int row;
    private int column;

    private String color;
    private boolean empty;

    private Piece piece;

    // Constructor that sets all the properties of this BoardSpace
    public BoardSpace(int row, int column, String color) {
        this.row = row;
        this.column = column;
        this.color = color;
        this.empty = true;
    }

    // Returns the row position of this space
    public int getRow() {
        return row;
    }

    // Returns the column position of this space
    public int getColumn() {
        return column;
    }

    // Returns the piece on this space
    public Piece getPiece() {
        return piece;
    }

    // Returns the color of this space
    public String getSpaceColor() {
        return color;
    }

    // Returns if there is a piece stationed on this space
    public boolean isEmpty() {
        return empty;
    }

    // Sets the passed in piece to being stationed on this space. Also updates the empty flag
    public void setPiece(Piece piece) {
        this.empty = false;
        this.piece = piece;
    }

    // Removes the piece stationed on this space. Also updates the empty flag and returns the piece
    public Piece removePiece() {
        Piece removed = piece;
        this.piece = null;
        this.empty = true;
        return removed;
    }

    @Override
    // Override of the toString method that returns a different respond depending on if this space
    // is taken and has a piece stationed here
    public String toString() {
        if(isEmpty()){
            return "------";
        }
        else {
            return piece.toString();
        }
    }
}
