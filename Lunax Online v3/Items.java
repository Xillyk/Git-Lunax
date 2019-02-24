
public class Items{
    String itemName;
    int itemAmount;


    public Items randomItem(int indexOfItem) {
        Items addItems = new Items();
        if(indexOfItem == 1)
        {
            addItems.itemName = "Potion";
            addItems.itemAmount = 1;
        }
        else if (indexOfItem == 2)
        {
            addItems.itemName = "Sword";
            addItems.itemAmount = 1;
        }
        else if (indexOfItem == 3)
        {
            addItems.itemName = "Armor";
            addItems.itemAmount = 1;
        }
        return addItems;
    }

}