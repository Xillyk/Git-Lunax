import java.util.*;

public class Lunax {

    public static void main(String[] args) {
        Novice novice = new Novice();
        Monster monster = new Monster();


        int number;

        Scanner sc = new Scanner(System.in);
        try{Thread.sleep(500);}catch(Exception e){}
        System.out.println("Lunax Online is loading . . .");
        try{Thread.sleep(750);}catch(Exception e){}
        System.out.println(">>Hi! New Player !! Let Start !!<<");
        try{Thread.sleep(750);}catch(Exception e){}

        System.out.print("Enter Name : ");
        String playerName = sc.nextLine();
        try{Thread.sleep(500);}catch(Exception e){}
        novice.showStart(playerName);

        System.out.println("Press Enter key to continue . . .");
        sc.nextLine();
        try{Thread.sleep(750);}catch(Exception e){}

        System.out.println("====================== Select ======================");
        System.out.println("Enter Number ::");
        System.out.println("[1] To Attack Monters");
        System.out.println("[2] To Heal with Items");
        System.out.println("[3] To Open Inventory");
        System.out.println("[4] To Open Shop");
        // System.out.println("[5] To Open Status");
        System.out.println("[0] To End");
        System.out.println("====================================================");



        do {
            System.out.print("Enter number : ");
            number = 0;
            number = sc.nextInt();
            try{Thread.sleep(750);}catch(Exception e){}

            if (number == 1) {
                System.out.println("----------------------- Attack ----------------------");
                System.out.println("Monster Level       : " + monster.monsLv);
                System.out.println("Damage              : " + monster.monsDmg);
                novice.gotDamage(monster.monsDmg);
                //check hp status
                if (!novice.isdied(novice.playerHp))
                    System.out.println("Your HP             : " + novice.playerHp + " / " + novice.playerMaxHp);
                else {
                    System.out.println("You Have Died!!");
                    System.out.println("Continue [press 10] , Exit [press 2]");
                    do {
                        number = sc.nextInt();
                        if (number == 10) {
                            System.out.println("Not Available HAHA !! You Have Died!!");
                            break;
                            /*
                             * use extra life card
                             * 
                             */
                        } else if (number == 2)
                            break;
                        else if (number != 10 && number != 2) {
                            System.out.println("You have entered wrong number !! Try Agian !!");
                        }
                    } while (number != 10 || number != 2);
                }
                if (number == 2 || number == 10)
                    break;
                novice.earnExp(monster.monsExp);
                //mons status up
                if(novice.isMaxExp() == 1)
                    monster.monsStatusUp();
                System.out.println("Your Get            : " + monster.monsExp + " EXP ");
                System.out.println("Your Current Exp    : " + novice.playerExp + " / " + novice.playerMaxExpPerLv);
                System.out.println("Your Level          : " + novice.playerLevel);
                novice.bag.addDropItemFromMons();
                System.out.println("Your Level          : " + novice.playerLevel);

                System.out.println("-----------------------------------------------------");
                // try{Thread.sleep(1000);}catch(Exception e){}

            

            } else if (number == 2) {
                novice.useSkill();
                try{Thread.sleep(500);}catch(Exception e){}

            } else if (number == 3) {
                novice.healHp(novice.bag.openBag());
                try{Thread.sleep(500);}catch(Exception e){}
            }
        } while (number != 0);
        System.out.println("Game is Shutting Down , See you next time !!");
    }
}