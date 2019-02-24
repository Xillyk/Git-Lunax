import java.util.*;

public class Novice {
    protected int playerHp;
    protected int playerMaxHp;
    protected int playerExp;
    protected int playerMaxExpPerLv;
    protected int playerLevel;
    protected int playerDmg;
    protected String playerName;
    protected String playerJob;
    protected final int playerBaseHp;

    protected int monsDmg = 20;
    protected int monsLv = 1;
    protected int monsExp = 10;
    protected int monsHp = 20;
    protected int monsBaseHp = 20;
    protected int monsBaseDmg = 20;
    protected int monsCurrHp;
    protected int monsMaxHp;

    public Bag bag;

    public Novice(String name, String job, int _hp, int _dmg) {
        // set new character
        playerName = name;
        playerJob = job;
        playerLevel = 1;
        playerDmg = _dmg; /** set damage */
        playerMaxHp = _hp;
        playerHp = playerMaxHp;
        playerBaseHp = playerHp;
        playerExp = 0;
        playerMaxExpPerLv = 50;
    
        monsMaxHp = monsHp;
        monsCurrHp = monsBaseHp;
        bag = new Bag(50);
    }

    public void showStart(String playerName) {
        System.out.println("====================================================");
        System.out.println(">>" + playerName + "<<");
        System.out.println("Job  : " + playerJob);
        System.out.println("Level: " + playerLevel);
        System.out.println("HP   : " + playerHp);
        System.out.println("EXP  : " + playerExp);
        System.out.println("====================================================");
    }

    public int attack() {
        int number, hurt;
        int round = 0;
        Scanner sc = new Scanner(System.in);

        monsHp = monsCurrHp;


        do{
            round++;
            hurt = monsDmg;
            getDmg(hurt);
            monsGetDmg(playerDmg);

            System.out.println("===================Attack Round ["+round+"]==================");
            System.out.println("Monster Level           : " + monsLv);
            System.out.println("Damage                  : -" + hurt);
            System.out.println("Mons HP                 : "+ monsHp+ " / " +monsMaxHp);
        
            if (hurt == 0)
                System.out.println("_________MISS__________");
            // check hp status
            if (!isdied(playerHp))
                System.out.println("Your HP             : " + playerHp + " / " + playerMaxHp);
            else {
                System.out.println("You Have Died!!");
                break;
                // System.out.println("Continue [press 10] , Exit [press 2]");
                // do {
                //     number = sc.nextInt();
                //     if (number == 10) {
                //         System.out.println("Not Available HAHA !! You Have Died!!");
                //         break;
                //         /*
                //          * use extra life card
                //          * 
                //          */
                //     } else if (number == 2)
                //         return 0;
                //     else if (number != 10 && number != 2) {
                //         System.out.println("You have entered wrong number !! Try Agian !!");
                //     }
                // } while (number != 10 || number != 2);
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            if(isMonsDied()){
                System.out.println("Monster Died!!");
                break;
            }
        }while(true);
        if(playerHp == 0)
            return 0;


        earnExp(monsExp);
        // mons status up
        if (isMaxExp() == 1){
            monsStatusUp();   
            System.out.println(">>> Current Player HP     => "+playerHp);
            System.out.println(">>> Current Player Damage => "+playerDmg);        
        }

        System.out.println("Your Get            : " + monsExp + " EXP ");
        System.out.println("Your Current Exp    : " + playerExp + " / " + playerMaxExpPerLv);
        System.out.println("Your Level          : " + playerLevel);
        bag.addDropItemFromMons();
        System.out.println("-----------------------------------------------------");
        System.out.println(">>> Current Monster HP     => "+monsCurrHp);
        System.out.println(">>> Current Monster Damage => "+monsDmg);
        // try{Thread.sleep(1000);}catch(Exception e){}
        return 1;
    }

    // Action
    public void earnExp(int exp) {
        playerExp += exp;
    }

    public void getDmg(int monsDmg) {
        playerHp -= monsDmg;
    }

    public void healHp(int heal) {
        if (heal == 0)
            setHpToMax();
        else if (heal > 0)
            playerHp += heal;
    }

    // Check Player Status

    public boolean isdied(int HP) {
        if (HP > 0)
            return false;
        return true;

    }

    // PLAYER Level Up !!!
    // make it better
    public int isMaxExp() {

        if (playerExp >= playerMaxExpPerLv) {
            playerLevel++;
            int extra = 0;
            extra = playerExp - playerMaxExpPerLv;
            setPlayerExpToZero();
            earnExp(extra);
            playerDmg = (int)(playerDmg*(playerLevel+1)*0.5);
            playerHp = (int)(playerBaseHp*(playerLevel+1)*0.5);
            playerMaxHp = playerHp;
            playerMaxExpPerLv = (int) (playerMaxExpPerLv * playerLevel * 0.5);
            System.out.println("+#+#+#+#+#+#+#+#+#+#+#+#+ Level Up +#+#+#+#+#+#+#+#+#+#+#+#+");
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

    //---------------------------------------------------------------------------------------------------------------------

    public void monsStatusUp() {
        monsLv++;
        monsHp = monsBaseHp*(monsLv+1);
        monsDmg = monsBaseDmg*(monsLv+1);
        monsCurrHp = monsHp;
        monsMaxHp = monsHp;
        monsExp = monsExp * monsLv;
    }

    public int monsDmg() {
        return monsDmg*(int)(Math.random() * monsLv + 1);
    }

    public void monsGetDmg(int playerDmg){
        monsHp -= playerDmg;
    }
    public boolean isMonsDied(){
        if(monsHp > 0)
            return false;
        else 
            return true;
    }
}