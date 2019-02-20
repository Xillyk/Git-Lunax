public class Novice {
    int playerHp;
    int playerMaxHp;
    int playerExp;
    int playerMaxExpPerLv;
    int playerLevel;
    int playerSkill;
    public Bag bag;
    public Skill skill;

    public Novice() {
        // set new character
        playerLevel = 1;
        playerMaxHp = 300;
        playerHp = playerMaxHp;
        playerExp = 0;
        playerMaxExpPerLv = 100;
        playerSkill = 1;

        bag = new Bag(50);
        skill = new Skill();
        
    }
    public void showStart(String playerName){
        System.out.println("====================================================");
        System.out.println(">>" + playerName + "<<");
        System.out.println("Level:" + playerLevel);
        System.out.println("HP:" + playerHp);
        System.out.println("EXP:" + playerExp);
        System.out.println("====================================================");
    }
    

    //Action 
    public void earnExp(int exp) {
        playerExp += exp;
    }

    public void gotDamage(int monsDmg) {
        playerHp -= monsDmg;

    }

    public void healHp(int heal){
        if(heal == 0)
            setHpToMax();
        else if(heal > 0)
            playerHp += heal;
    }



    public void useSkill() {
        int healPointFromSkill = -1;
        healPointFromSkill = skill.showSkill(playerHp,playerMaxHp);
        healHp(healPointFromSkill);
    }


    //Check Player Status

    public boolean isdied(int HP) {
        if(HP > 0)
            return false;
        return true; 

    }

    // PLAYER Level Up !!!
        //make it better
    public int isMaxExp(){
        
        if (playerExp >= playerMaxExpPerLv) 
        {
            playerLevel++;
            int extra = 0;
            extra = playerExp - playerMaxExpPerLv;
            setPlayerExpToZero();
            earnExp(extra);
            playerMaxExpPerLv =  (int)(playerMaxExpPerLv * playerLevel *0.5);
            playerMaxHp = (int)(playerMaxHp * playerLevel * 0.5);

            System.out.println("++++ Level Up ++++");
            return 1;
        }
        return 0;
    }

    public void setPlayerExpToZero() {
        playerExp = 0;
    }

    public void setHpToMax() {
        playerHp = playerMaxHp;
    }


}