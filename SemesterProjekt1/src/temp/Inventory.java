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
    //Creating a string for our roomtype called rarity
    private String rarity;
    //Creating integer for maximum storage
    private int maxStoragePlayer;
    //Max Storage will be determined later
    //private int maxStorageHouse; //unlimted
    private int maxStorageRoom;
    
    //No-args contructor for player inventory
    public Inventory() {
//    maxStoragePlayer = 3;
//    inventoryPlayer = new ArrayList<Item>();
    
    }
    //Creating a rarity randomizer
    public String roomRamdomizer() {
        int randomNum = (int)(1+Math.random()*1000);
        String rarity;
        //junk
        if (randomNum >= 1 && randomNum <= 500) {
            rarity = "junk"; 
        }
        //normal
        else if (randomNum >= 501 && randomNum <= 800) {
            rarity = "normal";
        }
        //rare
        else if (randomNum >= 801 && randomNum <= 930) {
            rarity = "rare";
        }
        //epic
        else if (randomNum >= 931 && randomNum <= 995) {
            rarity = "epic";
        }
        //legendary
        else{
             rarity = "legendary";
        }
        return rarity;
    }
    //Creating arg constructor for room, which defines the room type
    
    public Inventory(String rarity){
        inventoryRoom = new ArrayList<Item>();
        inventoryHouse = new ArrayList<Item>();
        maxStoragePlayer = 3;
        inventoryPlayer = new ArrayList<Item>();
        switch (rarity.toLowerCase()){
                    case "junk":
                        this.rarity = rarity;
                        this.maxStorageRoom = 3;
                        break;
                    case "normal":
                        this.rarity = rarity;
                        this.maxStorageRoom = 2;
                        break;
                    case "rare":
                        this.rarity = rarity;
                        this.maxStorageRoom = 2;
                        break;
                    case "epic":
                        this.rarity = rarity;
                        this.maxStorageRoom = 1;
                        break;
                    case "legendary":
                        this.rarity = rarity;
                        this.maxStorageRoom = 1;
                        break;
                    default:
                        this.rarity = "junk";
                        this.maxStorageRoom = 3;
                        break;
                        
        }
        
    }
    public void setRarity(String rarity){
        switch (rarity.toLowerCase()){
                    case "junk":
                        this.rarity = rarity;
                        this.maxStorageRoom = 3;
                        break;
                    case "normal":
                        this.rarity = rarity;
                        this.maxStorageRoom = 2;
                        break;
                    case "rare":
                        this.rarity = rarity;
                        this.maxStorageRoom = 2;
                        break;
                    case "epic":
                        this.rarity = rarity;
                        this.maxStorageRoom = 1;
                        break;
                    case "legendary":
                        this.rarity = rarity;
                        this.maxStorageRoom = 1;
                        break;
                    default:
                        this.rarity = "junk";
                        this.maxStorageRoom = 3;
                        break;
        }
    }
    public String getRarity(){
        return this.rarity;
    }
    //Creates a method for adding items to the player inventory
    public void addItem(Item item){
        //The item is only added if the inventory isnt full
        if (inventoryPlayer.size()<getMaxStoragePlayer()){
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
            inventoryPlayer.remove(i-1);
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
            if (inventoryPlayer.size() < getMaxStoragePlayer()){
                inventoryPlayer.add(inventoryHouse.get(inventoryHouse.indexOf(item)));
                inventoryHouse.remove(inventoryHouse.indexOf(item));
                System.out.println("Item picked up");
            }
            else{
                System.out.println("Your inventory is full");
            }
        }
        else{
            System.out.println("This item is not in your storage!");
        }
    }
    //Method for adding an item to the room inventory from the randomizer
    public void roomAddItem(Item item){
        if (inventoryRoom.size() < this.getMaxStorageRoom()){
            inventoryRoom.add(item);
        }
    }
    public void roomPickItem(Item item){
        if (inventoryRoom.contains(item)==true){
            if (inventoryPlayer.size() < maxStoragePlayer){
                inventoryPlayer.add(inventoryRoom.get(inventoryRoom.indexOf(item)));
                inventoryRoom.remove(inventoryRoom.indexOf(item));
                System.out.println("Item picked up");
            }
            else{
                System.out.println("Your inventory is full");
            }
        }
    }
    
    public String showPlayerInventory(){
        
        String contains = "";
        int count = 1;
        for(int i = 0; i < inventoryPlayer.size();i++)
        {
            contains += count + ": " + inventoryPlayer.get(i).getName() + "\n";
            count++;
        }
        return contains;
    }
    
    public String showRoomInventory(){
        
        String contains = "";
        int count = 1;
        for(int i = 0; i < inventoryRoom.size();i++)
        {
            contains += count + ": " + inventoryRoom.get(i).getName() + "\n";
           count++;
        }
        return contains;
    }
    
    public void emptyRoom(){
        inventoryRoom.clear();
    }

    /**
     * @return the maxStorageRoom
     */
    public int getMaxStorageRoom() {
        return maxStorageRoom;
    }

    /**
     * @return the maxStoragePlayer
     */
    public int getMaxStoragePlayer() {
        return maxStoragePlayer;
    }
    public Item getRoomItem(int i) {
        return inventoryRoom.get(i);
    }
}
