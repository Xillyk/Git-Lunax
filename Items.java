
public class Items{
    String itemName;
    int itemAmount;


    public Items randomItem(int indexOfItem) {
        Items randomItems = new Items();
        if(indexOfItem == 1)
        {
            randomItems.itemName = "Potion";
            randomItems.itemAmount = 1;
        }
        else if (indexOfItem == 2)
        {
            randomItems.itemName = "Sword";
            randomItems.itemAmount = 1;
        }
        else if (indexOfItem == 3)
        {
            randomItems.itemName = "Armor";
            randomItems.itemAmount = 1;
        }
        return randomItems;
    }

}