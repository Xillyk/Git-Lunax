import java.util.*;

public class Skill {

    public Skill() {

    }

    // public int useSkill(int hp, int maxHp) {



    //     return getSkill(hp, maxHp);
    // }

    public int showSkill(int hp, int maxHp) {
        int healHp = -1;
        System.out.println("----------------------- Skill -----------------------");
        Scanner sc = new Scanner(System.in);
        int number = 0;
        System.out.println("Select Skill");
        System.out.println("[1] : Attack Skill");
        System.out.println("[2] : Heal Skill");
        System.out.println("Enter Number : ");
        number = sc.nextInt();


        if (number == 1)
            System.out.println("Not available!!");

        else if (number == 2){
            healHp = healSkill(hp, maxHp);       
        }
        
        System.out.println("-----------------------------------------------------");
        return healHp;
    }
    
    // Skill [1]
    // public int attackSkill() {

    // }

    // Skill [2]
    public int healSkill(int hp, int maxHp) {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        System.out.println("------------------------");
        System.out.println("    [1] : heal 50 HP    ");
        System.out.println("    [2] : heal 100 HP   ");
        System.out.println("    [3] : heal 200 HP   ");
        System.out.println("------------------------");

        System.out.println("Enter Number : ");
        number = sc.nextInt();

        if (number == 1) {
            System.out.println("Your have use skill H1:");
            if ((hp+50) < maxHp)
            {
                return 50;
            }
            
            return 0;
        } else if (number == 2) {
            System.out.println("Your have use skill H2:");
            if ((hp+100) < maxHp)
                return 100;
            return 0;
        } else if (number == 3) {
            System.out.println("Your have use skill H3:");
            if ((hp+200) < maxHp) 
                return 200;
            return 0;
        }
        return -1;

        //return -1 --> not work , return 0 --> setHpToMax() 
    }
}