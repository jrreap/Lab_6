package cisc181.Lab4.java181;

    public class ActionRecruit extends Action {

        // constructor

        public ActionRecruit(Game181 game, int fromSpaceRow, int fromSpaceCol, int toSpaceRow, int toSpaceCol) {
            super(game, fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
        }

        // Check to see if this is valid Recruit Action
        public boolean validAction() {
            // check if from space valid
            if(fromSpaceValid() &&((game.getPreviousPiece() != game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece())|| (game.getCurrentTeam().getTeamPieces().size() ==1))) {
                // get the piece that is in the from BoardSpace
                Piece fromPiece = game.getBoard().getSpaces()
                        [fromSpaceRow][fromSpaceCol].getPiece();
                // check to see if this piece has implemented the Recruiter interface
                if (Recruiter.class.isAssignableFrom(fromPiece.getClass())) {
                    // if to space valid - should NOT be empty so pass a value of false to the toSpaceValid method
                    if (toSpaceValid(false)) {
                        return validActionPath();
                    }
                } else {
                    System.out.println("The piece on first space can't recruit.");
                    return false;
                }
            }
            return false;
        }
        // this method calls the Piece's recruit method
        private void recruit(){
            // Get the piece that is in the fromSpace
            Piece recPiece = game.getBoard()
                    .getSpaces()[fromSpaceRow][fromSpaceCol].getPiece();
            // check to see which type of Piece we have
            // we can't call the recruit method on all pieces in the game
            // we can only call these methods on pieces that have this method - ie - Pieces that have implemented the Recruiter Interface
            // so we will cast the Piece to its subclass type so we can call recruit
            if(recPiece instanceof PieceSharkBait){
                // cast and call SharkBait's recruit method
                ((PieceSharkBait) recPiece).recruit(fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
            }
            else if(recPiece instanceof PiecePenguin){
                // cast and call Penguin's recruit method
                ((PiecePenguin) recPiece).recruit(fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
            }
            else if(recPiece instanceof PieceSaraConnor){
                // cast and call SaraConnor method
                ((PieceSaraConnor) recPiece).recruit(fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
            }
        }

        public void performAction() {
            recruit();
            BoardSpace[][] spaces = game.getBoard().getSpaces();
            //this changes the piece that is held in the previous piece slot to change the cooldowns
            Piece reruitPiece = spaces[fromSpaceRow][fromSpaceCol].getPiece();
            Piece piece = spaces[toSpaceRow][toSpaceCol].getPiece();
            game.setPreviousPiece(reruitPiece);
            game.changeTurn();
            // this is handles if the piece is the Terminator
            if(spaces[toSpaceRow][toSpaceCol] == game.getFortress().getFortress()){
                if(reruitPiece instanceof PieceTerminator){
                    if(game.getFortress().getFortressHealth() >=2) {
                        if (game.getFortress().getFortressHealth() == 2) {
                            System.out.println("The fortress falls");
                            game.getFortress().attackFortressTerminator();
                        } else {
                            game.getFortress().attackFortressTerminator();
                            System.out.println("The fortress is weakened, " + game.getFortress().getFortressHealth() + " will cause it to fall");
                        }
                    }
                    else if (game.getFortress().getFortressHealth() == 1){
                        System.out.println("Fortress fails to protect" + piece.getSymbol() + "and is siding with the Terminator");
                        game.getFortress().attackFortress();
                        game.getOpponentTeam().getTeamPieces().remove(piece);
                        game.getCurrentTeam().getTeamPieces().add(piece);
                    }
                }
                else{game.getFortress().attackFortress();}
            }
            else if(piece instanceof PieceTerminator && spaces[toSpaceRow][toSpaceCol] != game.getFortress().getFortress()) {
                ((PieceTerminator) piece).setConviction(((PieceTerminator) piece).getConviction() - 1);
                if (((PieceTerminator) piece).getConviction() == 0) {
                    game.getOpponentTeam().getTeamPieces().remove(piece);
                    game.getCurrentTeam().getTeamPieces().add(piece);
                }
            }
            else{
                game.getOpponentTeam().getTeamPieces().remove(piece);
                game.getCurrentTeam().getTeamPieces().add(piece);
            }

        }
    }
