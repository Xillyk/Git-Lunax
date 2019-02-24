import java.util.*;

public class Lunax {

    public static void main(String[] args) {
        Lunax lunax = new Lunax();
        int number, check;
        String playerName;

        Scanner sc = new Scanner(System.in);
        // try {
        //     Thread.sleep(500);
        // } catch (Exception e) {
        // }
        // System.out.println("Lunax Online is loading . . .");
        // try {
        //     Thread.sleep(750);
        // } catch (Exception e) {
        // }
        // System.out.println(">>Hi! New Player !! Let Start !!<<");
        // try {
        //     Thread.sleep(750);
        // } catch (Exception e) {
        // }
        // System.out.print("Press Enter key to continue . . .");
        // sc.nextLine();
        // try {
        //     Thread.sleep(750);
        // } catch (Exception e) {
        // }

        System.out.println("==================== Select Job ====================");
        System.out.println("[1] To Swordman");
        System.out.println("[2] To Archer");
        System.out.println("====================================================");
        System.out.print("Enter Number : ");
        number = sc.nextInt();
        sc.nextLine();


        if (number == 1) {
            System.out.print("Enter Name : ");
            playerName = sc.nextLine();

            Swordman sw = new Swordman(playerName, "Swordman", 300, 20);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
            sw.showStart(playerName);
            try {
                Thread.sleep(750);
            } catch (Exception e) {
            }
            lunax.showOption();
            do {
                System.out.print("Enter number : ");
                number = 0;
                number = sc.nextInt();
                try {
                    Thread.sleep(750);
                } catch (Exception e) {
                }

                if (number == 1) {
                    check = sw.attack();
                    if (check == 2)
                        break;
                } else if (number == 2) {
                    sw.healHp(sw.bag.openBag());
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                }

            } while (number != 0);
            System.out.println("Game is Shutting Down , See you next time !!");

        }

        else if (number == 2) {
            System.out.print("Enter Name : ");
            playerName = sc.nextLine();

            Archer ac = new Archer(playerName, "Archer", 200, 40);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
            ac.showStart(playerName);
            try {
                Thread.sleep(750);
            } catch (Exception e) {
            }
            lunax.showOption();
            do {
                System.out.print("Enter number : ");
                number = 0;
                number = sc.nextInt();
                try {
                    Thread.sleep(750);
                } catch (Exception e) {
                }

                if (number == 1) {
                    check = ac.attack();
                    if (check == 2)
                        break;
                } else if (number == 2) {
                    ac.healHp(ac.bag.openBag());
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                }

            } while (number != 0);
            System.out.println("Game is Shutting Down , See you next time !!");

        }
    }

    void showOption() {
        System.out.println("====================== Option ======================");
        System.out.println("Enter Number ::");
        System.out.println("[1] To Attack Monters");
        System.out.println("[2] To Open Inventory");
        System.out.println("[5] To Show  Status");
        System.out.println("[0] To End");
        System.out.println("====================================================");
    }

}