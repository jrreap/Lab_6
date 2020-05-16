package cisc181.Lab4.java181;

    public class FortressBoardSpace {
        private int FortressHealth;
        private BoardSpace Fortress;
        private boolean Once;

        public FortressBoardSpace(){
            this.FortressHealth = 2;
            this.Fortress = new BoardSpace(0,0, "");
            this.Once = true;
        }

        public int getFortressHealth() {
            return FortressHealth;
        }

        public void setFortressHealth(int fortressHealth) {
            FortressHealth = fortressHealth;
        }

        public void helperAttackFortress(){
            setFortressHealth(getFortressHealth()-1);
        }

        public void setFortress(BoardSpace fortress) {
            this.Fortress = fortress;
        }

        public BoardSpace getFortress() {
            return Fortress;
        }

        public void attackFortress(Piece piece){
            if( piece instanceof PieceTerminator){
                helperAttackFortress();
                helperAttackFortress();
            }
            else{
                helperAttackFortress();
            }
        }

        public void printFortressHealth(){
            if(getFortressHealth()>=2){
                System.out.println("The Fortress is very strong and needs " + getFortressHealth() + " attacks to take it down");
            }
            else{
                System.out.println("The fortress is weakened and only needs 1 attack to take it down");
            }
        }

        public void reconstruct(){
            if(Once) {
                setFortressHealth(getFortressHealth() + 2);
                Once = false;
            }
        }
    }
