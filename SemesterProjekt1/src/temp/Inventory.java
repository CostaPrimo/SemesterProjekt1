package temp;
import java.util.ArrayList;
/**
 *
 * @author Gruppe 20
 */
public class Inventory {
    //Creating Arraylists for different Inventories/Storage units
    private ArrayList<Item> inventoryPlayer;
    private ArrayList<Item> inventoryHouse;
    private ArrayList<Item> inventoryRoom;
    //Creating integer for maximum storage
    private int maxStorage;
    
    //No-args contructor for player inventory
    public Inventory() {
    maxStorage = 3;
    inventoryPlayer = new ArrayList<Item>();
    
    }
    //Creates a method for adding items to the player inventory.
    public void addItem(Item item){
        //The item is only added if the inventory isnt full
        if (inventoryPlayer.size()<maxStorage){
            inventoryPlayer.add(item);
            System.out.println("Item added");
        }
        else {
            System.out.println("Your inventory is full");
        }
    }
    //Method for removing an item from the player inventory
    public void dropItem(int i){
        //The method only accepts numbers within the size of the inventory
        if(inventoryPlayer.size()>=i){
            inventoryPlayer.remove(i);
        }
        else{
            System.out.println("Cant drop item thats not in your inventory");
        }
    }
    //Method for adding an item from the player inventory to the house storage
    public void houseAddItem(Item item){
        //The item is only added to the house storage if its contained within the player inventory, the stored item is removed from the player inventory
        if (inventoryPlayer.contains(item)==true){
            inventoryHouse.add(inventoryPlayer.get(inventoryPlayer.indexOf(item)));
            inventoryPlayer.remove(inventoryPlayer.indexOf(item));
            System.out.println("Item stored");
        }
        else{
            System.out.println("This item is not in your inventory!");
        }
    }
    //Method for adding an item from the house storage to the player inventory
    public void housePickItem(Item item){
        //The item is only added to the player inventory if its contained within the house storage, the recieved item is removed from the house storage
        if (inventoryHouse.contains(item)==true){
            inventoryPlayer.add(inventoryHouse.get(inventoryHouse.indexOf(item)));
            inventoryHouse.remove(inventoryHouse.indexOf(item));
            System.out.println("Item picked up");
        }
        else{
            System.out.println("This item is not in your storage!");
        }
    }
    
}
