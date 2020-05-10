package cisc181.Lab4.java181;

public class FortressBoardSpace{
        private int FortressHealth = 2;
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

    public boolean isOnce() {
        return Once;
    }

    public void reconstruct(){
            if(Once) {
                setFortressHealth(getFortressHealth() + 2);
                Once = false;
            }
        }

        public void PrintHealth(){
            if(getFortressHealth() >=2){
                System.out.println("The fortress is still strong needing" + getFortressHealth() + "attacks to take it down");
            }
            else if(getFortressHealth() == 1){
                System.out.println("the fortress is greatly weakened and will only defend against anything other than the Terminator");
            }
            else{
                System.out.println("the fortress falls");
            }
        }
    }
