package business;
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
    private ArrayList<Item> inventoryComputer;
    private ArrayList<Item> inventoryTotal;
    
    //Creating a string for our roomtype called rarity
    private String rarity;
    //Creating integers for maximum storage
    private int maxStorageComputer;
    private int maxStoragePlayer;
    private int maxStorageRoom;
    
    
    //Creating arg constructor for room, which defines the room type
    public Inventory(String rarity){
        inventoryComputer = new ArrayList<Item>();
        inventoryHouse = new ArrayList<Item>();
        inventoryPlayer = new ArrayList<Item>();
        inventoryRoom = new ArrayList<Item>();
        inventoryTotal = new ArrayList<Item>();
        maxStorageComputer = 3;
        maxStoragePlayer = 3;
        
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
                        this.rarity = "nothing";
                        this.maxStorageRoom = 0; //Show the new one I created and how/why it worked. - REMOVE AFTER
                        break;
                        
        }
        
    }
    
    
    //Creates a method for adding items to the player inventory
    public void addItem(Item item){
        //The item is only added if the inventory isnt full
        if (getInventoryPlayer().size()<getMaxStoragePlayer()){
            getInventoryPlayer().add(item);
        }
        else {
            System.out.println("Your inventory is full");
        }
    }
    
    public void buildInventoryTotal(){
        inventoryTotal.addAll(getInventoryPlayer());
        inventoryTotal.addAll(inventoryHouse);
    }
    
    public void computerAddItem(Item item){
        if(inventoryTotal.contains(item)){
            if(inventoryComputer.size() < maxStorageComputer){
                inventoryComputer.add(inventoryTotal.get(inventoryTotal.indexOf(item)));
                System.out.println("Item added to computer");
            }
            else{
                System.out.println("Stop being a pleb and get a larger motherboard");
            }
        }
    }
    
    //Method for removing an item from the player inventory
    public boolean dropItem(int i){
        //The method only accepts numbers within the size of the inventory
        if(getInventoryPlayer().size()>=i){
            getInventoryPlayer().remove(i);
            return true;
        }
        else{
            System.out.println("Cant drop item thats not in your inventory");
            return false;
        }
    }
    
    public void emptyRoom(){
        inventoryRoom.clear();
    }
    
    //Method for adding an item from the player inventory to the house storage
    public void houseAddItem(Item item){
        //The item is only added to the house storage if its contained within the player inventory, the stored item is removed from the player inventory
        if (getInventoryPlayer().contains(item)){
            inventoryHouse.add(getInventoryPlayer().get(getInventoryPlayer().indexOf(item)));
            getInventoryPlayer().remove(getInventoryPlayer().indexOf(item));
            System.out.println("Item stored");
        }
        else{
            System.out.println("This item is not in your inventory!");
        }
    }
    
    //Method for adding an item from the house storage to the player inventory
    public void housePickItem(Item item){
        //The item is only added to the player inventory if its contained within the house storage, the recieved item is removed from the house storage
        if (inventoryHouse.contains(item)){
            if (getInventoryPlayer().size() < getMaxStoragePlayer()){
                getInventoryPlayer().add(inventoryHouse.get(inventoryHouse.indexOf(item)));
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
        if (inventoryRoom.contains(item)){
            if (getInventoryPlayer().size() < maxStoragePlayer){
                getInventoryPlayer().add(inventoryRoom.get(inventoryRoom.indexOf(item)));
                inventoryRoom.remove(inventoryRoom.indexOf(item));
                System.out.println("Item picked up");
            }
            else{
                System.out.println("Your inventory is full");
            }
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
                        this.rarity = "nothing"; 
                        this.maxStorageRoom = 0;
                        break;
        }
    }
    
    
    public String getRarity(){
        return this.rarity;
    }
    
    //Creating a rarity randomizer
    public String roomRandomizer() {
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
    
    public String showPlayerInventory(){
        
        String contains = "";
        int count = 1;
        for(int i = 0; i < getInventoryPlayer().size();i++)
        {
            contains += count + ": " + getInventoryPlayer().get(i).getName() + "\n";
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
    
    public String showHouseInventory(){
        
        String contains = "";
        int count = 1;
        for(int i = 0; i < inventoryHouse.size();i++){
            contains += count + ": " + inventoryHouse.get(i).getName() + "\n";
            count++;
        }
        return contains;
    }
    
    public String showInventoryTotal(){
        String contains = "";
        int count = 1;
        for(int i = 0; i < inventoryTotal.size();i++){
            contains += count + ": " + inventoryTotal.get(i).getName() + "\n";
            count++;
        
        }
        return contains;
    }    
    

    public int getInventoryComputerSize(){
        return inventoryComputer.size();
    }
    
    public int getInventoryPlayerSize(){
        return getInventoryPlayer().size();
    }
    
    public int getInventoryTotalSize(){
        return inventoryTotal.size();
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

    
    public Item getComputerItem(int i){
        return inventoryComputer.get(i);
    }
    
    public Item getHouseitem(int i){
        return inventoryHouse.get(i);
    }
    public Item getInventoryTotalItem(int i){
        return inventoryTotal.get(i);
    }
    
    public Item getPlayerItem(int i){
        return getInventoryPlayer().get(i);
    }
    
    public Item getRoomItem(int i) {
        return inventoryRoom.get(i);
    }

    /**
     * @return the inventoryPlayer
     */
    public ArrayList<Item> getInventoryPlayer() {
        return inventoryPlayer;
    }
}