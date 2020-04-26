package cisc181.Lab4.java181;

public class Board {
    private int rows;
    private int columns;

    private BoardSpace[][] spaces;

    // Main constructor that initializes this instance of the Board. Also setups up the spaces with
    // BoardSpaces
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        spaces = new BoardSpace[rows][columns];
        setUpEmptyBoard();
    }

    // Returns the number of rows on this board
    public int getNumRows() {
        return rows;
    }

    // Returns the number of columns on this board
    public int getNumColumns() {
        return columns;
    }

    // Returns the board's spaces in a 2D array
    public BoardSpace[][] getSpaces() {
        return spaces;
    }

    // Takes a coordinate (row, col) and checks to see if that is within the bounds of this board
    public boolean inBounds(int row, int col){
        if(row < rows && col < columns && row >= 0 && col >= 0){
            return true;
        }
        else {
            return false;
        }
    }

    // Loops through the board and fills every slot in the array with a BoardSpace
    public void setUpEmptyBoard() {
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < columns; col++){
                spaces[row][col] = new BoardSpace(row, col, "purple");
            }
        }
    }

    // Finds a random empty space and returns it. Continues to loop until it finds one.
    public BoardSpace findRandomEmptySpace() {
        BoardSpace space = null;
        while(space == null){
            int row = (int)(Math.random() * getNumRows());
            int col = (int)(Math.random() * getNumColumns());

            if (spaces[row][col].isEmpty()){
                space = spaces[row][col];
            }
        }

        return space;
    }

    // Override of the toString method that takes all the pieces and formats them into a text board.
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :     ");

        for(int col = 0; col < spaces[0].length; col++){
            boardString.append(col + "       ");
        }
        boardString.append("\n");
        for(int row = 0; row < spaces.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < spaces[row].length; col++){
                boardString.append(spaces[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
