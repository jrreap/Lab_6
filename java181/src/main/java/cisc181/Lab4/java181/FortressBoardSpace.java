package cisc181.Lab4.java181;

    public class FortressBoardSpace {
        private int FortressHealth;
        private BoardSpace Fortress;
        private boolean Once = true;

        public int getFortressHealth() {
            return FortressHealth;
        }

        public void setFortressHealth(int fortressHealth) {
            FortressHealth = fortressHealth;
        }

        public void attackFortress(){
            setFortressHealth(getFortressHealth()-1);
        }

        public void setFortress(BoardSpace fortress) {
            this.Fortress = fortress;
        }

        public BoardSpace getFortress() {
            return Fortress;
        }

        public void attackFortressTerminator(){
            attackFortress();
            attackFortress();
        }

        public void reconstruct(){
            if(Once) {
                setFortressHealth(getFortressHealth() + 2);
                Once = false;
            }
        }
    }
