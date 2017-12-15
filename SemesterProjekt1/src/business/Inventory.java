package business;
import acquaintance.IItem;
import java.util.ArrayList;
/**
 *<h1>Inventory class!</h1>
 * @author Gruppe 20
 */
public class Inventory {
    //Creating Arraylists for different Inventories/Storage units
    private ArrayList<IItem> inventoryPlayer;
    private ArrayList<IItem> inventoryHouse;
    private ArrayList<IItem> inventoryRoom;
    private ArrayList<IItem> inventoryComputer;
    private ArrayList<IItem> inventoryTotal;
    
    //Creating a string for our roomtype called rarity
    private String rarity;
    //Creating integers for maximum storage
    private int maxStorageComputer;
    private int maxStoragePlayer;
    private int maxStorageRoom;
    
    
    //Creating arg constructor for room, which defines the room type
    public Inventory(String rarity){
        inventoryComputer = new ArrayList<IItem>();
        inventoryHouse = new ArrayList<IItem>();
        inventoryPlayer = new ArrayList<IItem>();
        inventoryRoom = new ArrayList<IItem>();
        inventoryTotal = new ArrayList<IItem>();
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
                        this.maxStorageRoom = 0;
                        break;
                        
        }
        
    }
    
    
    /**
     * This method adds an item to the player inventory if there is space for it.
     * @param item Takes in an item.
     * @return String This returns a string used in the presentation layer to create output.
     */
    protected String addItem(IItem item){
        String output = "";
        //The item is only added if the inventory isnt full
        if (getInventoryPlayer().size()<getMaxStoragePlayer()){
            getInventoryPlayer().add(item);
        }
        else {
            output = "Your inventory is full";
        }
        return output;
    }
    
    /**
     * This method adds an item to the computer inventory from inventoryTotal.
     * @param item Takes in an item.
     * @return String This returns a string used in the presentation layer to create output.
     */
    protected String computerAddItem(IItem item){
        String output = "";
        if(inventoryTotal.contains(item)){
            if(inventoryComputer.size() < maxStorageComputer){
                inventoryComputer.add(inventoryTotal.get(inventoryTotal.indexOf(item)));
                getInventoryPlayer().remove(item);
                getInventoryHouse().remove(item);
                output = "Item added to computer";
            }
            else{
                output = "You need a larger motherboard";
            }
        }
        return output;
    }
    /**
     * This method removes an item from the computer inventory and places it in the house inventory
     * @param item Takes in an item to remove and add to the house inventory.
     * @return String This returns a string used in the presentation layer to create output.
     */
    protected String computerRemoveItem(IItem item){
        String output;
        inventoryHouse.add(inventoryComputer.get(inventoryComputer.indexOf(item)));
        getInventoryComputer().remove(item);
        output = "Item removed from computer and put back into your house storage";
        return output;
    }
    
    /**
     * This method removes an item from the player inventroy.
     * @param i takes in an int that drops an item from a specific index in the inventory.
     * @return boolean.
     */
    protected boolean dropItem(int i){
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
    /**
     * This method clears the inventory of the room. Used together with the rarity and add item method.
     * @see #roomAddItem(acquaintance.IItem) 
     */
    protected void emptyRoom(){
        inventoryRoom.clear();
    }
    
    /**
     * This method adds an item from the player inventory to the house storage
     * @param item Takes an item in its parameter
     * @return String This returns a string used in the presentation layer to create output.
     */
    protected String houseAddItem(IItem item){
        //The item is only added to the house storage if its contained within the player inventory, the stored item is removed from the player inventory
        String output = "";
        if (getInventoryPlayer().contains(item)){
            getInventoryHouse().add(getInventoryPlayer().get(getInventoryPlayer().indexOf(item)));
            getInventoryPlayer().remove(getInventoryPlayer().indexOf(item));
            output = "Item stored";
        }
        else{
            output = "This item is not in your inventory!";
        }
        return output;
    }
    /**
     * This method adds an item from the house to the player inventory
     * @param item Takes an item in its parameter
     * @return String This returns a string used in the presentation layer to create output.
     */
    protected String housePickItem(IItem item){
        String output = "";
        //The item is only added to the player inventory if its contained within the house storage, the recieved item is removed from the house storage
        if (getInventoryHouse().contains(item)){
            if (getInventoryPlayer().size() < getMaxStoragePlayer()){
                getInventoryPlayer().add(getInventoryHouse().get(getInventoryHouse().indexOf(item)));
                getInventoryHouse().remove(getInventoryHouse().indexOf(item));
                output = "Item picked up";
            }
            else{
                output = "Your inventory is full";
            }
        }
        else{
            output = "This item is not in your storage!";
        }
        return output;
    }
    
    //Method for adding an item to the room inventory from the randomizer
    /**
     * This method adds an item to the room as long there is space
     * @param item The specific item is determined by the random generator in the business facade
     */
    protected void roomAddItem(IItem item){
        if (inventoryRoom.size() < this.getMaxStorageRoom()){
            inventoryRoom.add(item);
        }
    }
    /**
     * 
     * @param item The item is the one to pick up. It is then checked to see if the room has that item, and then what index to add the item from.
     * @return String This returns a string used in the presentation layer to create output.
     */
    protected String roomPickItem(IItem item){
        String output = "";
        if (inventoryRoom.contains(item)){
            if (getInventoryPlayer().size() < maxStoragePlayer){
                getInventoryPlayer().add(inventoryRoom.get(inventoryRoom.indexOf(item)));
                inventoryRoom.remove(inventoryRoom.indexOf(item));
                output = "Item picked up";
            }
            else{
                output = "Your inventory is full";
            }
        }
        return output;
    }
    /**
     * This method changes the rarity of a room and the max storage that follows that rarity.
     * @param rarity This parameter will decide which changes the room should get depending on rarity.
     */
    protected void setRarity(String rarity){
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
    
    
    protected String getRarity(){
        return this.rarity;
    }
    /**
     * This method will use a random self made generator that ultimately will return a rarity depending on which randomNum that gets rolled.
     * @return String Returns a String that is used as a rarity indicator used in other methods.
     * @see #setRarity(java.lang.String) 
     */
    protected String roomRandomizer() {
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
    /**
     * This method shows the players inventory and returns it. This was used in the text based interface
     * @return String
     */
    protected String showPlayerInventory(){
        
        String contains = "";
        int count = 1;
        for(int i = 0; i < getInventoryPlayer().size();i++)
        {
            contains += count + ": " + getInventoryPlayer().get(i).getName() + "\n";
            count++;
        }
        return contains;
    }
    /**
     * This method shows the room inventory.
     * @return String
     */
    protected String showRoomInventory(){
        
        String contains = "";
        int count = 1;
        for(int i = 0; i < inventoryRoom.size();i++)
        {
            contains += count + ": " + inventoryRoom.get(i).getName() + "\n";
           count++;
        }
        return contains;
    }
    /**
     * This method shows the house inventory.
     * @return String
     */
    protected String showHouseInventory(){
        
        String contains = "";
        int count = 1;
        for(int i = 0; i < getInventoryHouse().size();i++){
            contains += count + ": " + getInventoryHouse().get(i).getName() + "\n";
            count++;
        }
        return contains;
    }
    /**
     * This method shows the total inventory which is house + player combined.
     * @return String.
     */
    protected String showInventoryTotal(){
        String contains = "";
        int count = 1;
        for(int i = 0; i < inventoryTotal.size();i++){
            contains += count + ": " + inventoryTotal.get(i).getName() + "\n";
            count++;
        
        }
        return contains;
    }    
    

    protected int getInventoryComputerSize(){
        return inventoryComputer.size();
    }
    
    protected int getInventoryPlayerSize(){
        return getInventoryPlayer().size();
    }
    
    protected int getInventoryTotalSize(){
        return inventoryTotal.size();
    }
    /**
     * @return the maxStorageRoom
     */
    protected int getMaxStorageRoom() {
        return maxStorageRoom;
    }

    /**
     * @return the maxStoragePlayer
     */
    protected int getMaxStoragePlayer() {
        return maxStoragePlayer;
    }

    
    protected IItem getComputerItem(int i){
        return inventoryComputer.get(i);
    }
    
    protected IItem getHouseitem(int i){
        return getInventoryHouse().get(i);
    }
    protected IItem getInventoryTotalItem(int i){
        return inventoryTotal.get(i);
    }
    
    protected IItem getPlayerItem(int i){
        return getInventoryPlayer().get(i);
    }
    
    protected IItem getRoomItem(int i) {
        return inventoryRoom.get(i);
    }

    /**
     * @return the inventoryPlayer
     */
    protected ArrayList<IItem> getInventoryPlayer() {
        return inventoryPlayer;
    }
    
    protected ArrayList<IItem> getInventoryRoom(){
        return inventoryRoom;
    }
    protected ArrayList<IItem> getInventoryTotal(){
        inventoryTotal.clear();
        inventoryTotal.addAll(inventoryPlayer);
        inventoryTotal.addAll(getInventoryHouse());
        return inventoryTotal;
    }
    
    protected ArrayList<IItem> getInventoryComputer(){
        return inventoryComputer;
    }

    /**
     * @return the inventoryHouse
     */
    protected ArrayList<IItem> getInventoryHouse() {
        return inventoryHouse;
    }
    
    protected void loadInventoryRoom(ArrayList c){
        if (!inventoryRoom.isEmpty()){
            inventoryRoom.clear();
        }
        inventoryRoom.addAll(c);
    }
    
    protected void loadInventoryPlayer(ArrayList c){
        if (!inventoryPlayer.isEmpty()){
            inventoryPlayer.clear();
        }
        inventoryPlayer.addAll(c);
    }
    
    protected void loadInventoryHouse(ArrayList c){
        if (!inventoryHouse.isEmpty()){
            inventoryHouse.clear();
        }
        inventoryHouse.addAll(c);
    }
    
    protected void loadInventoryComputer(ArrayList c){
        if (!inventoryComputer.isEmpty()){
            inventoryComputer.clear();
        }
        inventoryComputer.addAll(c);
    }
    
}