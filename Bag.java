import java.util.*;
import java.io.*;

public class Bag {
    int fullSlot;
    int useSlot;
    public ArrayList<Items> items;
    Scanner sc = new Scanner(System.in);
    int count;
    int potion;
    int sword;
    int armor;

    public Bag(int _slot) {
        fullSlot = _slot;
        useSlot = 0;
        items = new ArrayList<Items>();
        count = 0;
        potion = 0;
        sword = 0;
        armor = 0;
    }

    public int openBag() {
        int HP;
        int select = 0;
        System.out.println("------------------- Open Inventory ------------------");
        System.out.println("Your Items ::");
        showItems();
        System.out.println("Use Items [1] : Exit Inventory [2]");

        do {
            System.out.print("Enter Number : ");
            select = sc.nextInt();
            if (select == 1) {
                System.out.println("You selected 'USE ITEMS' ");
                do {
                    int selectItem = 0;
                    System.out.print("Press [1] to use potion : ");
                    selectItem = sc.nextInt();

                    if (selectItem == 1)
                        {
                        return usePotion();
                        } 
                    else if (selectItem == 0)
                        break;

                } while (true);

            }  
            else if(select == 2)
                break;
            
        } while (true);

        System.out.println("-----------------------------------------------------");
        return 0;
    }

    public int usePotion() {
        if (potion > 0) {
            potion--;
            return 100;
        }
        return -1;
    }



    public void showItems() {
        if (useSlot == 0)
            System.out.println("You don't have item in bag!");
        else if (useSlot > 0) {
            int index = 0;
            for (Items item : items) {

                if (item.itemName.equals("Potion"))
                    potion++;
                else if (item.itemName.equals("Sword"))
                    sword++;
                else if (item.itemName.equals("Armor"))
                    armor++;
                index++;
                System.out.println(index + " " + item.itemName);
            }
            System.out.println("------------");
            System.out.println("Potion = " + potion);
            System.out.println("Sword  = " + sword);
            System.out.println("Armor  = " + armor);
            System.out.println("------------");
        }
    }

    public void addDropItemFromMons() {
        int randomIndex = (int) (Math.random() * 3 + 1);
        Items itemDrop = new Items();

        itemDrop = itemDrop.randomItem(randomIndex);
        // check for empty slot

        if (useSlot < fullSlot) {
            items.add(itemDrop);
            useSlot++;
            count++;
        }
        System.out.println("You get :" + items.get(count - 1).itemName);
    }
}
