package cisc181.Lab4.java181;

public class ActionAttack extends Action {

    // constructor
    public ActionAttack(Game181 game, int fromSpaceRow, int fromSpaceCol, int toSpaceRow, int toSpaceCol) {
        super(game, fromSpaceRow, fromSpaceCol, toSpaceRow, toSpaceCol);
    }

    // Check to see if this is valid Attack Action
    public boolean validAction() {

        // check if from space valid
        if (fromSpaceValid() && (game.getPreviousPiece() != game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece() || (game.getCurrentTeam().getTeamPieces().size() == 1))) {
            // get the piece that is in the from BoardSpace
            Piece fromPiece = game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece();
            // check to see if this piece has implemented the Attacker interface
            if (Attacker.class.isAssignableFrom(fromPiece.getClass())) {
                // if to space is valid - should NOT be empty so pass false to the method
                if (toSpaceValid(false)) {
                    return validActionPath();
                }
            } else {
                System.out.println("The piece on first space can't attack.");
                return false;
            }
        }
        return false;
    }

    // this method calls the Piece's attack method

    private void attack() {
        // Get the piece that is in the fromSpace
        Piece attPiece = game.getBoard()
                .getSpaces()[fromSpaceRow][fromSpaceCol].getPiece();
        // check to see which type of Piece we have
        // we can't call the attack method on all pieces in the game
        // we can only call these methods on pieces that have this method - ie - Pieces that have implemented the Attacker Interface
        // so we will cast the Piece to its subclass type so we can call attack
        if (attPiece instanceof PieceBlueHen) {
            // cast and call BlueHen's attack method
            ((PieceBlueHen) attPiece)
                    .attack(fromSpaceRow, fromSpaceCol, toSpaceRow, toSpaceCol);
        } else if (attPiece instanceof PiecePenguin) {
            // cast and call Penguin's attack method
            ((PiecePenguin) attPiece)
                    .attack(fromSpaceRow, fromSpaceCol, toSpaceRow, toSpaceCol);
        } else if (attPiece instanceof PieceTerminator) {
            //cast and call Terminator's attack method
            ((PieceTerminator) attPiece)
                    .attack(fromSpaceRow, fromSpaceCol, toSpaceRow, toSpaceCol);
        }
    }

    public void HelperFunction(Piece piece){
        BoardSpace[][] spaces = game.getBoard().getSpaces();
        spaces[fromSpaceRow][fromSpaceCol].removePiece();
        spaces[toSpaceRow][toSpaceCol].removePiece();
        game.getOpponentTeam().getTeamPieces().remove(piece);
        game.getOpponentTeam().getDiedPieces().add(piece);
    }


    public void performAction() {
        attack();
        BoardSpace[][] spaces = game.getBoard().getSpaces();
        Piece piece = spaces[toSpaceRow][toSpaceCol].getPiece();
        Piece attackerPiece = spaces[fromSpaceRow][fromSpaceCol].getPiece();
        game.setPreviousPiece(attackerPiece);
        game.changeTurn();
        // if the destination is the opponents fortress
        if (spaces[toSpaceRow][toSpaceCol] == game.getOpponentTeam().getFortress().getFortress()) {
            // if the attacker is the a terminator
            if (attackerPiece instanceof PieceTerminator) {
                //this tests to see if the terminator is strong enough to smash trough the fortress and affect the piece inside
                if (game.getOpponentTeam().getFortress().getFortressHealth() == 1) {
                    if(!(spaces[toSpaceRow][toSpaceCol].getPiece() instanceof PieceTerminator)) {
                        System.out.println("The fortress fails to protect" + piece.getSymbol() + "and was killed by the Terminator");
                        game.getOpponentTeam().getFortress().attackFortress();
                        HelperFunction(piece);
                        spaces[toSpaceRow][toSpaceCol].setPiece(attackerPiece);
                        game.getCurrentTeam().setCurrentTerminatorBoardSpace(spaces[toSpaceRow][toSpaceCol]);
                    }
                    else{
                        ((PieceTerminator)piece).setHealth(((PieceTerminator)piece).getHealth()-1);
                        System.out.println("The fortress fails to protect " + game.getOpponentTeam().getTeamName() + "'s Terminator");
                        ((PieceTerminator)piece).PrintHealth();
                    }
                }
                else {
                    game.getOpponentTeam().getFortress().attackFortressTerminator();
                    game.getOpponentTeam().getFortress().PrintHealth();
                }
            } else {
                game.getOpponentTeam().getFortress().attackFortress();
                System.out.println("The fortress protects " + piece.getSymbol() + " from " + attackerPiece.getSymbol());
                game.getOpponentTeam().getFortress().PrintHealth();
            }
        }
        else if (piece instanceof PieceTerminator && (spaces[toSpaceRow][toSpaceCol] != game.getOpponentTeam().getFortress().getFortress())) {
            ((PieceTerminator) piece).setHealth(((PieceTerminator) piece).getHealth() - 1);
            if (((PieceTerminator) piece).getHealth() >= 1) {
                ((PieceTerminator)piece).PrintHealth();
            } else {
                HelperFunction(piece);
                spaces[toSpaceRow][toSpaceCol].setPiece(attackerPiece);
            }
        } else if (attackerPiece instanceof PieceTerminator) {
            HelperFunction(piece);
            spaces[toSpaceRow][toSpaceCol].setPiece(attackerPiece);
            game.getCurrentTeam().setCurrentTerminatorBoardSpace(spaces[toSpaceRow][toSpaceCol]);
        } else {
            HelperFunction(piece);
            spaces[toSpaceRow][toSpaceCol].setPiece(attackerPiece);
        }
    }
}
