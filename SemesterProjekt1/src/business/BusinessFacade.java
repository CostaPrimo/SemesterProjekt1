package business;
import acquaintance.IItem;
import acquaintance.IBusiness;
import acquaintance.IData;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;
/**
* <h1>Business Facade!</h1>
* @author Gruppe 20
*/

public class BusinessFacade implements IBusiness {
    private IData data;
    @Override
    /**
    * @param dataLayer This is the parameter used in the method.
    * Injecting our datalayer so it can be used in this class to communicate with the datalayer.
    */
    public void injectData(IData dataLayer) {
        data = dataLayer;
    }
    /**
    * Declaration of variables used in the businessfacade aswell as a single initialization. 
    */
    private Parser parser;
    private Room currentRoom;
    private Inventory inventoryRoom;
    private JSONObject saveState;
    private String Playername;
    private Player player1;
    private Merchant merchantGamestop, merchantShop;
    private Rat rat;
    private ChallengeNPC valutaMan;
    Item JGPU, NGPU, RGPU, EGPU, LGPU;
    Item JRAM, NRAM, RRAM, ERAM, LRAM;
    Item JCPU, NCPU, RCPU, ECPU, LCPU;
    Item gameMagazine, ratPoison, crowBar, monsterBullBooster;
    Item burntCar, BFS, scrap, container, washingMachine, blockbuster, IBMserver, scooter;
    Room home, downtown, gamestop, merchant, scrapyardentrance, scrapyardmiddle, scrapyardwest, scrapyardeast, scrapyardsouth, scrapyardsoutheast, scrapyardsouthwest;
    ArrayList<Item> junk, normal, rare, epic, legendary, CPU, GPU, RAM;
    private int scoreToBeat = 7499;
    private char choice;

    /**
    * Constructing the BusinessFacade which initializes each code in the methods.
    */
    public BusinessFacade() {
        createRooms();
        createNPCs();
        createPlayer();
        createInventories();
        createItemList();
        createItems();
        saveState = new JSONObject();
    }

    private void createNPCs() {
        merchantGamestop = new Merchant("Mr. MountainDew", "Your nemisis who works at GameStop");
        merchantShop = new Merchant("Ali", "Illegal immigrant from Afghanistan");
        rat = new Rat("Svend", "Dank", scrapyardsouth);
        valutaMan = new ChallengeNPC("Ludoman", "Former gambling addict(totally still a gambling addict), now trying to make others gamble",scrapyardsoutheast);
    }

    private void createItemList() {
        junk = new ArrayList<>();
        normal = new ArrayList<>();
        rare = new ArrayList<>();
        epic = new ArrayList<>();
        legendary = new ArrayList<>();
        CPU = new ArrayList<>();
        GPU = new ArrayList<>();
        RAM = new ArrayList<>();
    }

    private void createItems() {
        JGPU = new Item("GTX 550ti", "junk", 600, 200);
        NGPU = new Item("GTX 760", "normal", 900, 300);
        RGPU = new Item("GTX 960", "rare", 1500, 500);
        EGPU = new Item("GTX 1070", "epic", 3500, 1200);
        LGPU = new Item("GTX Titan XP", "legendary", 8000, 2500);
        JRAM = new Item("DDR 512 MB", "junk", 50, 20);
        NRAM = new Item("DDR2 2 GB", "normal", 100, 30);
        RRAM = new Item("DDR3 4 GB", "rare", 300, 100);
        ERAM = new Item("DDR3 8 GB", "epic", 1000, 300);
        LRAM = new Item("DDR4 16 GB", "legendary", 2000, 650);
        JCPU = new Item("i3 1.8 GHz", "junk", 600, 200);
        NCPU = new Item("i5 2.5 GHz", "normal", 1200, 400);
        RCPU = new Item("i7 3.7 GHz", "rare", 3000, 1000);
        ECPU = new Item("Threadripper 4 GHz", "epic", 5000, 1800);
        LCPU = new Item("i9 6 GHz", "legendary", 7000, 2300);
        gameMagazine = new Item("GameMagazine", "normal", 150, 10);
        BFS = new Item("BIG FUCKING STONE!");
        scooter = new Item("an old scooter");
        container = new Item("an empty container");
        blockbuster = new Item("an old abandoned Blockbuster?");
        washingMachine = new Item("a Siemens washing machine");
        IBMserver = new Item("a fried IBM server (it's still burning)");
        scrap = new Item("a pile of scrap");
        burntCar = new Item("a burnt car");
        ratPoison = new Item("ratpoison", "normal", 500, 100);
        crowBar = new Item("crowbar", "normal", 450, 100);
        monsterBullBooster = new Item("MonsterBullBooster", "normal", 400, 120);
        
    /**
    * Adding the different items to each rarity-tier ArrayList.
    */
        junk.add(JGPU);
        junk.add(JRAM);
        junk.add(JCPU);
        junk.add(BFS);
        junk.add(scrap);
        junk.add(container);
        normal.add(NGPU);
        normal.add(NRAM);
        normal.add(NCPU);
        normal.add(washingMachine);
        normal.add(scooter);
        rare.add(RGPU);
        rare.add(RRAM);
        rare.add(RCPU);
        rare.add(IBMserver);
        rare.add(burntCar);
        epic.add(EGPU);
        epic.add(ERAM);
        epic.add(ECPU);
        epic.add(blockbuster);
        legendary.add(LGPU);
        legendary.add(LRAM);
        legendary.add(LCPU);
        merchantShop.addItem(gameMagazine);
        merchantShop.addItem(crowBar);
        merchantShop.addItem(ratPoison);
        merchantShop.addItem(monsterBullBooster);
        merchantGamestop.addItem(JGPU);
        merchantGamestop.addItem(JRAM);
        merchantGamestop.addItem(JCPU);
        merchantGamestop.addItem(NGPU);
        merchantGamestop.addItem(NRAM);
        merchantGamestop.addItem(NCPU);
        merchantGamestop.addItem(RGPU);
        merchantGamestop.addItem(RRAM);
        merchantGamestop.addItem(RCPU);
        merchantGamestop.addItem(EGPU);
        merchantGamestop.addItem(ERAM);
        merchantGamestop.addItem(ECPU);
        CPU.add(JCPU);
        CPU.add(NCPU);
        CPU.add(RCPU);
        CPU.add(ECPU);
        CPU.add(LCPU);
        GPU.add(JGPU);
        GPU.add(NGPU);
        GPU.add(RGPU);
        GPU.add(EGPU);
        GPU.add(LGPU);
        RAM.add(JRAM);
        RAM.add(NRAM);
        RAM.add(RRAM);
        RAM.add(ERAM);
        RAM.add(LRAM);
    }
    /**
    * Creating an inventory object to allow access to inventory methods in this class.
    */
    private void createInventories() {
        inventoryRoom = new Inventory("nothing");
    }
    
    /**
    * Name all the rooms and give them a description aswell as locked status if that constructor is used.
    */
    private void createRooms() {
        home = new Room("home", "at your home");
        downtown = new Room("downtown", "at downtown");
        gamestop = new Room("gamestop", "at gamestop");
        merchant = new Room("merchant", "at the merchant");
        scrapyardentrance = new Room("scrapyardentrance", "at the entrance to the scrapyard");
        scrapyardmiddle = new Room("at the center of the scrapyard", true);
        scrapyardwest = new Room("scrapyardwest", "at the west part of the scrapyard");
        scrapyardeast = new Room("scrapyardeast", "at the east part of the scrapyard");
        scrapyardsouth = new Room("scrapyardsouth", "at the south part of the scrapyard");
        scrapyardsoutheast = new Room("scrapyardsoutheast", "at the southeast part of the scrapyard");
        scrapyardsouthwest = new Room("scrapyardsouthwest", "at the southwest part of the scrapyard");

    /**
    * Setting the exits for each room.
    */
        home.setExit("south", downtown);
        downtown.setExit("north", home);
        downtown.setExit("east", merchant);
        downtown.setExit("west", gamestop);
        downtown.setExit("south", scrapyardentrance);
        merchant.setExit("west", downtown);
        gamestop.setExit("east", downtown);
        scrapyardentrance.setExit("north", downtown);
        scrapyardentrance.setExit("south", scrapyardmiddle);
        scrapyardeast.setExit("west", scrapyardmiddle);
        scrapyardeast.setExit("south", scrapyardsoutheast);
        scrapyardwest.setExit("south", scrapyardsouthwest);
        scrapyardwest.setExit("east", scrapyardmiddle);
        scrapyardsouth.setExit("north", scrapyardmiddle);
        scrapyardsouth.setExit("east", scrapyardsoutheast);
        scrapyardsouth.setExit("west", scrapyardsouthwest);
        scrapyardsoutheast.setExit("north", scrapyardeast);
        scrapyardsoutheast.setExit("west", scrapyardsouth);
        scrapyardsouthwest.setExit("north", scrapyardwest);
        scrapyardsouthwest.setExit("east", scrapyardsouth);
        scrapyardmiddle.setExit("north", scrapyardentrance);
        scrapyardmiddle.setExit("south", scrapyardsouth);
        scrapyardmiddle.setExit("east", scrapyardeast);
        scrapyardmiddle.setExit("west", scrapyardwest);
        setCurrentRoom(home);
    }

    /**
    * Creating an object of player to be used in this class.
    */   
    private void createPlayer(){
         player1 = new Player(Playername);
    }
    /**
    * Creating a method for a welcome message when starting the game.
    */
    @Override
    public String printWelcome() {
        String output;
        output = "THIS IS THE SCRAPYARD GAME\nA WORLD OF SCRAP, FUN, AND ADVENTURES\n Click the help button if you don't know what to do\n"
                + "For an optional tutorial, please buy a game magazine found in a store\n";
        output += (getCurrentRoom().getLongDescription());
        return output;
    }
    /**
    * 
    * @param command This is the input from the user after a command, for instance GO "north".
    * @return boolean This returns true or false and is used in the text-based interface during phase 1.
    */    
    private boolean catchUserInput(Command command){
        char[] charArray = command.getSecondWord().toCharArray();
            
        if (charArray.length>2){
            System.out.println("Please only enter at most 2 characters");
            return false;
        }
        else if (!Character.isDigit(charArray[0])){
            System.out.println("Please only enter numbers");
            return false;
        }
        else if(charArray.length == 2 && !Character.isDigit(charArray[1])){
            System.out.println("Please only enter numbers");
            return false;
        }
        else if (charArray[0] == '0'){
            System.out.println("No zeroes please");
            return false;
        }
        else{
            return true;
        }
    }
    /**
     * This method takes in an inventory for a room, and adds the correct amount and types of items.
     * @param inventory This parameter is the inventory the method receives and manipulates.
     */
    private void setRoomRarity(Inventory inventory){
        if (inventory.getRarity() == "junk") {
            for (int i = 0; i < inventory.getMaxStorageRoom(); i++) {
                int random = (int) (Math.random() * junk.size());
                inventory.roomAddItem(junk.get(random));
            }
        } 
        else if (inventory.getRarity() == "normal") {
            for (int i = 0; i < inventory.getMaxStorageRoom(); i++) {
                int random = (int) (Math.random() * normal.size());
                inventory.roomAddItem(normal.get(random));
            }
        } 
        else if (inventory.getRarity() == "rare") {
            for (int i = 0; i < inventory.getMaxStorageRoom(); i++) {
                int random = (int) (Math.random() * rare.size());
                inventory.roomAddItem(rare.get(random));
            }
        } 
        else if (inventory.getRarity() == "epic") {
            for (int i = 0; i < inventory.getMaxStorageRoom(); i++) {
                int random = (int) (Math.random() * epic.size());
                inventory.roomAddItem(epic.get(random));
            }
        } 
        else if (inventory.getRarity() == "legendary") {
            for (int i = 0; i < inventory.getMaxStorageRoom(); i++) {
                int random = (int) (Math.random() * legendary.size());
                inventory.roomAddItem(legendary.get(random));
            }
        }
    }
    /**
     * This method makes the player able to pick up an item if certain conditions are met.
     * @param itemNumber This parameter is called itemNumber and is an int. This is used in the presentation layer and works together with listviews.
     * @return String This returns a string used in the presentation layer to create output.
     */
    @Override
    public String addItem(int itemNumber) {
        String output = "";
        if(getCurrentRoom().getShortDescription()=="at your home"){
            int i = itemNumber;
            output = inventoryRoom.housePickItem(inventoryRoom.getHouseitem(i));
        }
        else{
            int i = itemNumber;
            if(getCurrentRoom()!=rat.getCurrentRoom()){
                if (i >= 0 && i <= inventoryRoom.getMaxStorageRoom()) {
                    if(inventoryRoom.getRoomItem(i).isTooHeavy()!=true){
                        output = inventoryRoom.roomPickItem(inventoryRoom.getRoomItem(i));
                    }
                    else {
                        output = "Item is too heavy to pickup";
                    }
                }
            }
            else if (getCurrentRoom()==rat.getCurrentRoom() && rat.getIsDead()){
                if (i >= 0 && i <= inventoryRoom.getMaxStorageRoom()) {
                    if(inventoryRoom.getRoomItem(i).isTooHeavy()!=true){
                        output = inventoryRoom.roomPickItem(inventoryRoom.getRoomItem(i));
                    }
                    else {
                        output = "Item is too heavy to pickup";
                    }
                }
            }
            else{
                output = "Kill the rats to pickup items!";
            }
        }
        return output;
    }
    /**
     * This method makes it possible to buy an item from different shops.
     * @param itemNumber This parameter is called itemNumber and is an int. This is used in the presentation layer and works together with listviews.
     * @return String This returns a string used in the presentation layer to create output. 
     */
    @Override
    public String buyItem(int itemNumber) {
        String output = "";
        if (getCurrentRoom().getShortDescription() == "at the merchant") {
            if (inventoryRoom.getInventoryPlayerSize() < 3){
                if(player1.getScore() >= merchantShop.getItemMerchant(itemNumber).getBuyPrice()){
                    inventoryRoom.addItem(merchantShop.getItemMerchant(itemNumber));
                    player1.setScore(player1.getScore()-merchantShop.getItemMerchant(itemNumber).getBuyPrice());
                    output = merchantShop.getItemMerchant(itemNumber).getName() + " Bought";
                    }
                else{
                    output = "Need more money";
                    }
                }
            else{
                output = "You do not have enough space in your inventory";
                }
            }
        else if (getCurrentRoom().getShortDescription() == "at gamestop") {
            if (inventoryRoom.getInventoryPlayerSize() < 3){
                if(player1.getScore() >= merchantGamestop.getItemMerchant(itemNumber).getBuyPrice()){
                    inventoryRoom.addItem(merchantGamestop.getItemMerchant(itemNumber));
                    player1.setScore(player1.getScore()-merchantGamestop.getItemMerchant(itemNumber).getBuyPrice());
                    output = merchantGamestop.getItemMerchant(itemNumber).getName() + " bought";
                }
                else{
                    output = "Need more money";
                }
            }
            else{
                output = "You do not have enough space in your inventory";
            }
        }
        return output;
    }
    /**
     * This method drops an item.
     * @param itemNumber This parameter is called itemNumber and is an int. This is used in the presentation layer and works together with listviews.
     * @return String This returns a string used in the presentation layer to create output.
     */
    @Override
    public String dropItem(int itemNumber) {
        String output;
        output = inventoryRoom.getInventoryPlayer().get(itemNumber).getName() + " dropped";
        inventoryRoom.dropItem(itemNumber); 
        return output;
    }
        
    
    
    /**
     * This method enables the player to walk around in the game. This method also keeps track of various events in the game.
     * This method also spawns items in the various room each time the player walks from room to room.
     * This method subtracts one time token each time the player walks.
     * @param direction2 This parameter decides which direction to go. 
     * @return String This returns a string used in the presentation layer to create output.
     */
    @Override
    public String goRoom(String direction2) {
        
        String direction = direction2;
        String output = "";
        String [] questionOutput;
        Room nextRoom = getCurrentRoom().getExit(direction);

        /**
         * Check is the next room exists. If not it will output that.
         */
        if (nextRoom == null) {
            output = "CANT GO THAT WAY";
        } 
        /**
         * Checks whether the room is locked. If it is, the player cannot go there.
         */
        else {
            if(nextRoom.getIsLocked()){
                output = "This room is locked, you need to break the lock first";
            }
            else{
                /**
                 * Checks if the player has run out of time. If true, it will give a punishment.
                 */
                if (player1.getTimeToken() <= 0 && timeToBuild()== false){
                    output = "you have no moves left today\nYou wake up at home but you've been robbed half your money ";
                    setCurrentRoom(home);
                    player1.setTimeToken(20);
                    player1.setDayToken(player1.getDayToken()-1);
                    player1.setScore(player1.getScore()/2);
                    if(rat.getIsDead()){
                        rat.setIsDead(false);
                    }
                }
                else{
                    /**
                     * If the condition below is met. The rat will attack.
                     */
                    if(rat.getCurrentRoom()==getCurrentRoom() && rat.getIsDead()!=true){
                        output = "The rat attacked you!\n";
                        if(player1.getTimeToken() == 1){
                            player1.setTimeToken(player1.getTimeToken()-1);
                        }
                        player1.setTimeToken(player1.getTimeToken()-2);
                    }
                    setCurrentRoom(nextRoom);
                    if(direction2 == "north"){
                        output += "You went north\n";
                    }
                    else if(direction2 == "south"){
                        output += "You went south\n";
                    }
                    else if (direction2 == "east"){
                        output += "You went east\n";
                    }
                    else if (direction2 == "west"){
                        output += "You went west\n";
                    }
                    if(timeToBuild() == false){
                    player1.setTimeToken(player1.getTimeToken()-1);
                    }
                    if(getCurrentRoom() == valutaMan.getCurrentRoom() && questionTime()){
                          output += valutaMan.encounterMessage();
                    }
                    
                    System.out.println(player1.getTimeToken());
                    if (rat.getIsDead()!=true){
                        output += ratMove();
                    }
                    System.out.println(getCurrentRoom().getLongDescription());
                    if (getCurrentRoom().getShortDescription() == "at the center of the scrapyard") {
                        inventoryRoom.emptyRoom();
                        inventoryRoom.setRarity(inventoryRoom.roomRandomizer());
                        setRoomRarity(inventoryRoom);               
                    }
                    else if (getCurrentRoom().getShortDescription() == "at the east part of the scrapyard") {
                        inventoryRoom.emptyRoom();
                        inventoryRoom.setRarity(inventoryRoom.roomRandomizer());
                        setRoomRarity(inventoryRoom);
                    }
                    else if (getCurrentRoom().getShortDescription() == "at the south part of the scrapyard") {
                        inventoryRoom.emptyRoom();
                        inventoryRoom.setRarity(inventoryRoom.roomRandomizer());
                        setRoomRarity(inventoryRoom);
                    }
                    else if (getCurrentRoom().getShortDescription() == "at the southeast part of the scrapyard") {
                        inventoryRoom.emptyRoom();
                        inventoryRoom.setRarity(inventoryRoom.roomRandomizer());
                        setRoomRarity(inventoryRoom);
                    }
                    else if (getCurrentRoom().getShortDescription() == "at the southwest part of the scrapyard") {
                        inventoryRoom.emptyRoom();
                        inventoryRoom.setRarity(inventoryRoom.roomRandomizer());
                        setRoomRarity(inventoryRoom);
                    }
                    else if (getCurrentRoom().getShortDescription() == "at the west part of the scrapyard") {
                        inventoryRoom.emptyRoom();
                        inventoryRoom.setRarity(inventoryRoom.roomRandomizer());
                        setRoomRarity(inventoryRoom);
                    }
                    else if (getCurrentRoom().getShortDescription() == "at the merchant") {
                        output+= merchantShop.encounterMessage();
                        output+= "Ali shows you the following items";
                    } 
                    else if (getCurrentRoom().getShortDescription() == "at gamestop") {
                        output+= merchantShop.encounterMessage();
                        output+= "Mr. MountainDew: Hey, hows your pc doing? Oh wait... nvm. I broke it\n";
                        output+= "Mr. MountainDew shows you the following items";
                    } 
                    else {
                        inventoryRoom.emptyRoom();
                        inventoryRoom.setRarity("nothing");
                    }
                }
            }
        }
        return output;
    }
    /**
     * This method shows the rooms currently stored items.
     */
    @Override
    public void inspectRoom() {
        inventoryRoom.showRoomInventory();
    }
    
    /**
     * Making a method that prints out the help message.
     */
    public void printHelp() {
        
    }
    /**
     * This method makes sure the rat moves around and won't leave the scrapyard. 
     * @return String This returns a string used in the presentation layer to create output.
     */
    public String ratMove(){
        String output = "";
        String[] temp;
        double random;
        temp = rat.getCurrentRoom().getExitString().split(" ");
        random = (Math.random()*temp.length);
        if ((int)random == 0){
            random++;
        }
        rat.setCurrentRoom(rat.getCurrentRoom().getExit(temp[(int)random]));
        if(rat.getCurrentRoom().getShortDescription() == "at the entrance to the scrapyard"){
            rat.setCurrentRoom(scrapyardmiddle);
            
        }
        if(rat.getCurrentRoom()==getCurrentRoom()){
            output = "The rat is in this room";
            output+= rat.encounterMessage();
        }
        return output;
    }
    /**
     * This method enables the player to sell an item in the shops only.
     * @param itemNumber This parameter is called itemNumber and is an int. This is used in the presentation layer and works together with listviews.
     * @return String This returns a string used in the presentation layer to create output.
     */
    @Override
    public String sellItem(int itemNumber){
        String output = "";
        if(getCurrentRoom().getShortDescription() == "at gamestop" || getCurrentRoom().getShortDescription() == "at the merchant"){
            if(inventoryRoom.getInventoryPlayerSize() >= itemNumber){
                player1.setScore(player1.getScore()+ inventoryRoom.getPlayerItem(itemNumber).getSellPrice());
                output = inventoryRoom.getPlayerItem(itemNumber).getName() + " sold";
                inventoryRoom.dropItem(itemNumber);
            }
            else{
                System.out.println("You do not have that item");
            }
        }
        else{
            output = "Can't sell here";
        }
        return output;
    }
    /**
     * This method allows the player to sleep if at home. One day will pass and the player will get 30 moves.
     * This method also revives the rat.
     * @return String This returns a string used in the presentation layer to create output.
     */
    @Override
    public String sleep(){
        String output = "";
        if(getCurrentRoom().getShortDescription()=="at your home"){
            if(player1.getDayToken() !=0){
            player1.setDayToken(player1.getDayToken()-1);
            player1.setTimeToken(30);
            output = "You slept and woke up feeling refreshed";
            if(rat.getIsDead()){
                rat.setIsDead(false);
            }
            }
            else{
                output = "This is your last day. You cannot sleep";
            }
        }
        else{
            System.out.println("you can only sleep at home");
        }
        return output;
    }
    /**
     * This method allows the player to use his/her house to store all the items he/she want.
     * @param itemNumber This parameter is called itemNumber and is an int. This is used in the presentation layer and works together with listviews.
     * @return String This returns a string used in the presentation layer to create output.
     */
    @Override
    public String storeItems(int itemNumber) {
        String output = "";
        if (getCurrentRoom().getShortDescription() == "at your home") {
            int i = itemNumber;
            output = inventoryRoom.houseAddItem(inventoryRoom.getPlayerItem(i));
        } 
        else {
            System.out.println("You need to be at home.... to store an item in your home");
        }
        return output;
    }
    /**
     * This method allows the player to use specified items. Each item has its own action and conditions.
     * This method subtracts one time token per use. It also punishes the player if he/she ran out of moves.
     * @param itemNumber This parameter is called itemNumber and is an int. This is used in the presentation layer and works together with listviews.
     * @return String This returns a string used in the presentation layer to create output.
     */
    @Override
    public String use(int itemNumber){
        String output = "";
        int i = itemNumber;

            IItem useableitem = inventoryRoom.getPlayerItem(i);
            /**
             * Reads the magazine.
             */
            if (useableitem==gameMagazine){
                System.out.println("Opening the Magazine you read the following:\n");
                System.out.println("GameMagazine 13.37th. edition ’17. 150 kr.");
                System.out.println("Rumors of people rushing to the local scrapyard, you won’t believe what they found!!!\n");
                System.out.println("Reportings of people rushing toward the scrapyard in order to find valuable items, has just been confirmed."
                        + "\nOld aswell as new computer parts are scattered all over the huge scrapyard just a few minutes away from downtown.\n");
                System.out.println("According to the people we interviewed, there seems to be a difference in the quality aswell as year produced of the parts."
                        + "\nSome parts date back to as early as the start of the 90’ies. And some look brand new."
                        + "\nThe rare part however, as way more rare to find, which means only those who really look well might have a chance of finding a very valuable part.\n");
                System.out.println("One of the people we interviewed said the following:\n");
                System.out.println("“Yeah, I just got back from the scrapyard, and oh gees, look at these shiny parts."
                        + "\nI hit the jackpot, the two new GPU’s should easily be able to run Crysis on the highest settings, and if not, I can just go to the local GameStop and sell the parts I found."
                        + "\nBeware of the mutant rats though, I noticed a couple of them guarding some of the parts I wanted to pick and saw a poor guy get his WHOLE arm bit off. “\n");
                System.out.println("We recommend that everyone who thinks about going scavenging for parts equip themselves with rat poison which can be bought in Ali’s shop.");
                System.out.println("However, reportings say that the police has locked the scrapyard to keep scavengers away. Proceed with caution");
            }
            /**
             * Uses ratpoison if the rat is in the same room as the player. The rat can be killed multiple times.
             */
            else if (useableitem==ratPoison){
                if(getCurrentRoom()==rat.getCurrentRoom() && rat.getIsDead()==false){
                    if(player1.getTimeToken() <= 0 ){
                        output = "you have no moves left";
                        setCurrentRoom(home);
                        output += "You wake up at home but you've been robbed half your money";
                        player1.setScore(player1.getScore()/2);
                        player1.setTimeToken(20);
                        player1.setDayToken(player1.getDayToken()-1);
                        if(rat.getIsDead()){
                            rat.setIsDead(false);
                        }
                    }
                    else{
                        rat.setIsDead(true);
                        output = "You used all your ratpoison and killed the rat!";
                        inventoryRoom.dropItem(i);
                        player1.setTimeToken(player1.getTimeToken()-1);
                    }
                }
                else{
                    output = "There is no rat in this room";
                }
            }
            /**
             * Uses the crowbar if the current room is at the entrance to the scrapyard.
             * Upon use it unlocks scrapyard middle since it is south from the entrance.
             */
            else if (useableitem==crowBar){
                if(getCurrentRoom().getShortDescription() == "at the entrance to the scrapyard"){
                    if(player1.getTimeToken() <= 0){
                        output = "you have no moves left";
                        setCurrentRoom(home);
                        output += "You wake up at home but you've been robbed half your money";
                        player1.setScore(player1.getScore()/2);
                        player1.setTimeToken(20);
                        player1.setDayToken(player1.getDayToken()-1);
                        if(rat.getIsDead()){
                            rat.setIsDead(false);
                        }
                    }
                    else{
                        output = "You used crowbar and smashed the lock";
                        getCurrentRoom().getExit("south").setIsLocked(false);
                        inventoryRoom.dropItem(i);
                        output += "Your crowbar broke";
                        player1.setTimeToken(player1.getTimeToken()-1);
                    }
                }
            }
            /**
             * Upon use gives the player 4 extra moves.
             */
            else if (useableitem==monsterBullBooster){
                output = "You drank a MonsterBullBooster and gained more moves!";
                player1.setTimeToken(player1.getTimeToken()+4);
                inventoryRoom.dropItem(i);
        }
            else{
                output = "This item is not usable";
            }
            return output;
    }
    /**
     * Wallet method.
     * @return int This returns the players current score.
     */
    @Override
    public int wallet(){
        return this.player1.getScore();
    }
    /**
     * This method allows the player to add a part to the computer when building it.
     * This method demands the items in a specific order.
     * @param itemNumber This parameter is called itemNumber and is an int. This is used in the presentation layer and works together with listviews.
     * @return String This returns a string used in the presentation layer to create output.
     */ 
    @Override
    public String addParts(int itemNumber) {
        int i = itemNumber;
        String output = "";
        if(inventoryRoom.getInventoryComputerSize()==0){
            output = "Please insert a CPU for the first slot" + "\n" + inventoryRoom.showInventoryTotal();
            if(CPU.contains(inventoryRoom.getInventoryTotalItem(i))){
                output = inventoryRoom.computerAddItem(inventoryRoom.getInventoryTotalItem(i));
            }
            else{
                output = "Please add a CPU in this slot";
            }
        }
        else if(inventoryRoom.getInventoryComputerSize()==1){
            output = "Please insert a GPU for the second slot" + "\n" + inventoryRoom.showInventoryTotal();
            if(GPU.contains(inventoryRoom.getInventoryTotalItem(i))){
                inventoryRoom.computerAddItem(inventoryRoom.getInventoryTotalItem(i));
            }
            else{
                output = "Please add a GPU in this slot";
            }
        }
        else if(inventoryRoom.getInventoryComputerSize()==2){
            output = "Please insert a RAM for the third slot" + "\n" + inventoryRoom.showInventoryTotal();
            if(RAM.contains(inventoryRoom.getInventoryTotalItem(i))){
                inventoryRoom.computerAddItem(inventoryRoom.getInventoryTotalItem(i));
                    }
        else{
            output = "Please add RAM in this slot";
        }
    }
        return output;
}
    /**
     * This method allows the player to remove parts from the computer. It likewise has to be done in a specific order. 
     * @param itemNumber This parameter is called itemNumber and is an int. This is used in the presentation layer and works together with listviews.
     * @return String This returns a string used in the presentation layer to create output.
     */
    @Override
    public String removeparts(int itemNumber){
        String output = "";
        int i = itemNumber;
        if(inventoryRoom.getInventoryComputerSize() == 3){
            if(RAM.contains(inventoryRoom.getComputerItem(i))){
                output = inventoryRoom.computerRemoveItem(inventoryRoom.getComputerItem(i));
            }
            else{
                output = "Please remove your RAM first";
            }
        }
        else if(inventoryRoom.getInventoryComputerSize() == 2){
            if(GPU.contains(inventoryRoom.getComputerItem(i))){
                output = inventoryRoom.computerRemoveItem(inventoryRoom.getComputerItem(i));
            }
            else{
                output = "Please remove your GPU first";
            }
        }
        else if(inventoryRoom.getInventoryComputerSize() == 1){
                output = inventoryRoom.computerRemoveItem(inventoryRoom.getComputerItem(i));
        }
        return output;
    }
    /**
     * This method will loop through all the items in the computerInventory and add the together to a score.
     * This method then evaluates whether thhe player has won or not.
     * @return String[] This returns a stringarray used for labels in the presentation layer to present score.
     */
    @Override
    public String[] buildComputer(){
        String[] output = new String[6];
        if(inventoryRoom.getInventoryComputerSize()==3){
            player1.setScore(0);
            for (int j = 0; j < inventoryRoom.getInventoryComputerSize(); j++) {
                player1.setScore(player1.getScore() + inventoryRoom.getComputerItem(j).getBuyPrice());
                output[j] = "Your added item is " + inventoryRoom.getComputerItem(j).getName() + " with the value of " + inventoryRoom.getComputerItem(j).getBuyPrice();
            }
            output[3] = ("Your total score is " + player1.getScore());
            if(player1.getScore()>scoreToBeat){
                output[4] = ("Your computer is better than Mr.MountainDew's PC");
                output[5] = ("You won the game!");
            }
            else{
                output[4] = ("Your computer is not better than Mr.MountainDew's pc");
                output[5] = ("You lose!");
            }
            saveHighscore();
        }
        
        else{
        output[0] = "You could not build your PC because you missed some components.\n You had no computer to bring to the LAN, and you lose";
        }
        return output;
    }
    @Override
    /**
     * This method is used to make sure the player when forced to build actually can build.
     @return boolean
     */
    public boolean requiredPartsChecker(){
        if(inventoryRoom.getInventoryTotal().contains(RAM) && inventoryRoom.getInventoryTotal().contains(GPU) && inventoryRoom.getInventoryTotal().contains(CPU) ){
            return true;
        }
        else{
            return false;
        }
    }
   /**
    * This method checks if it is time to build. If that is the case, the player will get teleported to his/her home.
    * @return 
    */
    @Override
    public boolean timeToBuild(){
        if(player1.getDayToken() == 0 && player1.getTimeToken() == 0){
            setCurrentRoom(home);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @return The currentRoom
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }
    /**
     * @return Arraylist This returns the ArrayList for the merchant.
     */
    @Override
    public ArrayList<IItem> getItemMerchant(){
        return merchantShop.getInventoryMerchant();
    }

    /**
     * @param currentRoom The currentRoom to set
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    @Override
    public ArrayList<IItem> getItemPlayer(){
        return inventoryRoom.getInventoryPlayer();
    }
    @Override
    public ArrayList<IItem> getItemGamestop(){
        return merchantGamestop.getInventoryMerchant();
    }
    @Override
    public ArrayList<IItem> getItemRoom(){
        return inventoryRoom.getInventoryRoom();
    }
    @Override
    public ArrayList<IItem> getInventoryTotal(){
        return inventoryRoom.getInventoryTotal();
    }
    @Override
    public ArrayList<IItem> getInventoryComputer(){
        return inventoryRoom.getInventoryComputer();
    }
    @Override
    public ArrayList<IItem> getInventoryHouse(){
        return inventoryRoom.getInventoryHouse();
    }
    @Override
    public Room getRatCurrentRoom(){
        return rat.getCurrentRoom();
    }
    @Override
    public int getDayToken(){
        return this.player1.getDayToken();
    }
    /**
     * 
     * @return int This retur
     */
    @Override
    public int getTimeToken(){
        return this.player1.getTimeToken();
    }
    
    @Override
    public void setPlayerName(String playerName){
        this.player1.setName(playerName);
    }
    
    /**
     * This method sort the entries on the highscore list in descending order
     * @param player The entry to be added to the highscore list
     * @return a string containing the sorted highscores with the new entry added.
     */
    private String sortScores(Player player){
        String newEntry = player.getName() + " " + player.getScore();
        String currentScores = data.loadHighscore() + newEntry;
        String newScores = "";
        
        String[]scoreEntries = currentScores.split("\n");
        ArrayList<String> entryNames = new ArrayList<>();
        int[]entryPoints = new int[scoreEntries.length];
        String[]tempArray;
        String[]tempArray2;
        
        for(int i = 0; i<scoreEntries.length;i++){
            tempArray = scoreEntries[i].split(" ");
            entryNames.add(tempArray[0]);
            entryPoints[i]= Integer.parseInt(tempArray[1]);
        }
        
        Arrays.sort(entryPoints, 0, entryPoints.length);
        
        int k = scoreEntries.length-1;
        while(k>=0){
            System.out.println(k);
            for(int j = 0; j<scoreEntries.length;j++){
                if(k<0){
                    break;
                }
                tempArray2 = scoreEntries[j].split(" ");
                System.out.println("checked value "+tempArray2[1]+"\nrequired value "+entryPoints[k]);
                if(Integer.parseInt(tempArray2[1])== entryPoints[k]){
                    if(entryNames.contains(tempArray2[0])){
                        newScores += scoreEntries[j]+"\n";
                        entryNames.remove(tempArray2[0]);
                        k--;
                        j=-1;
                    }
                }
            }
        }
        
        return newScores;
    }
    
    /**
     * Creates a JSONObject that represents the current state of the game
     * @return the created JSONObject
     */
    private JSONObject createSaveState(){
    this.saveState
        .put("playerName", player1.getName())
        .put("playerScore", player1.getScore())
        .put("timeToken", player1.getTimeToken())
        .put("dayToken", player1.getDayToken())
        .put("currentRoom", currentRoom.getName())
        .put("RatRoom", rat.getCurrentRoom().getName())
        .put("ratIsDead", rat.getIsDead())
        .put("isLocked", scrapyardmiddle.getIsLocked())
        .put("inventoryHouse", inventoryRoom.getInventoryHouse())
        .put("inventoryRoom", inventoryRoom.getInventoryRoom())
        .put("inventoryPlayer", inventoryRoom.getInventoryPlayer())
    .put("inventoryComputer", inventoryRoom.getInventoryComputer());
    return saveState;
    }
    
    /**
     * Saves a JSONObject created from the createSaveState method
     * @see createSaveState
     */
    @Override
    public void saveGame(){
        data.saveGame(createSaveState());
    }
    
    /**
     * Converts a room name into a Room object
     * @param roomName name of room to be converted
     * @return Room object
     */
    private Room filterRoom(String roomName){
        switch(roomName){
            case "home":
                return home;
            case "downtown":
                return downtown;
            case "merchant":
                return merchant;
            case "gamestop":
                return gamestop;
            case "scrapyardentrance":
                return scrapyardentrance;
            case "scrapyardmiddle":
                return scrapyardmiddle;
            case "scrapyardeast":
                return scrapyardeast;
            case "scrapyardwest":
                return scrapyardwest;
            case "scrapyardsouth":
                return scrapyardsouth;
            case "scrapyardsoutheast":
                return scrapyardsoutheast;
            case "scrapyardsouthwest":
                return scrapyardsouthwest;
            default:
                return home;
        }
    }
    
    /**
     * Converts an item name to an Item object
     * @param itemName name of item to be converted
     * @return Item object
     */
    private Item filterItem(String itemName){
        switch(itemName){
            case "\"GTX 550ti\"":
                return JGPU;
            case "\"GTX 760\"":
                return NGPU;
            case "\"GTX 960\"":
                return RGPU;
            case "\"GTX 1070\"":
                return EGPU;
            case "\"GTX Titan XP\"":
                return LGPU;
            case "\"DDR 512 MB\"":
                return JRAM;
            case "\"DDR2 2 GB\"":
                return NRAM;
            case "\"DDR3 4 GB\"":
                return RRAM;
            case "\"DDR3 8 GB\"":
                return ERAM;
            case "\"DDR4 16 GB\"":
                return LRAM;
            case "\"i3 1.8 GHz\"":
                return JCPU;
            case "\"i5 2.5 GHz\"":
                return NCPU;
            case "\"i7 3.7 GHz\"":
                return RCPU;
            case "\"Threadripper 4 GHz\"":
                return ECPU;
            case "\"i9 6 GHz\"":
                return LCPU;
            case "\"GameMagazine\"":
                return gameMagazine;
            case "\"BIG FUCKING STONE!\"":
                return BFS;
            case "\"an old scooter\"":
                return scooter;
            case "\"an empty container\"":
                return container;
            case "\"an old abandoned Blockbuster?\"":
                return blockbuster;
            case "\"a Siemens washing machine\"":
                return washingMachine;
            case "\"a fried IBM server (it's still burning)\"":
                return IBMserver;
            case "\"a pile of scrap\"":
                return scrap;
            case "\"a burnt car\"":
                return burntCar;
            case "\"ratpoison\"":
                return ratPoison;
            case "\"crowbar\"":
                return crowBar;
            case "\"MonsterBullBooster\"":
                return monsterBullBooster;
            default:
                return JRAM;
        }
    }
    
    /**
     * Takes the JSONObject loaded from the gamesave.json file and updates gamerelated variables to the loaded variables
     * Use set methods for the different variables to place the loaded data
     * Place loaded items into the correct inventories
     * @see filterItem for convertion of item name to Item object
     * @see filterRoom for convertion of room name to Room object
     */
    @Override
    public void loadGame(){
        saveState = (JSONObject)data.loadGame().get("savestate");
        ArrayList<Item> placeHolder = new ArrayList<Item>();
        rat.setIsDead(saveState.getBoolean("ratIsDead"));
        rat.setCurrentRoom(filterRoom(saveState.getString("RatRoom")));
        player1.setName(saveState.getString("playerName"));
        player1.setScore(saveState.getInt("playerScore"));
        player1.setDayToken(saveState.getInt("dayToken"));
        player1.setTimeToken(saveState.getInt("timeToken"));
        currentRoom = filterRoom(saveState.getString("currentRoom"));
        scrapyardmiddle.setIsLocked(saveState.getBoolean("isLocked"));
        placeHolder.clear();
        for(int i =0; i<saveState.getJSONArray("inventoryPlayer").length();i++){
            String[]cuts = saveState.getJSONArray("inventoryPlayer").get(i).toString().split(",");
            String[]name = cuts[1].split(":");
            System.out.println(name[1]);
            placeHolder.add(filterItem(name[1]));
        }
        inventoryRoom.loadInventoryPlayer(placeHolder);
        placeHolder.clear();
        for(int i =0; i<saveState.getJSONArray("inventoryRoom").length();i++){
            String[]cuts = saveState.getJSONArray("inventoryRoom").get(i).toString().split(",");
            String[]name = cuts[1].split(":");
            System.out.println(name[1]);
            placeHolder.add(filterItem(name[1]));
        }
        inventoryRoom.loadInventoryRoom(placeHolder);
        placeHolder.clear();
        for(int i =0; i<saveState.getJSONArray("inventoryHouse").length();i++){
            String[]cuts = saveState.getJSONArray("inventoryHouse").get(i).toString().split(",");
            String[]name = cuts[1].split(":");
            System.out.println(name[1]);
            placeHolder.add(filterItem(name[1]));
        }
        inventoryRoom.loadInventoryHouse(placeHolder);
        placeHolder.clear();
        for(int i =0; i<saveState.getJSONArray("inventoryComputer").length();i++){
            String[]cuts = saveState.getJSONArray("inventoryComputer").get(i).toString().split(",");
            String[]name = cuts[1].split(":");
            System.out.println(name[1]);
            placeHolder.add(filterItem(name[1]));
        }
        inventoryRoom.loadInventoryComputer(placeHolder);
    }
    
    /**
     * Saves the highscore for the player using the sortScores method
     * @see sortScores
     */
    @Override
    public void saveHighscore(){
        data.saveHighscore(sortScores(player1));
    }
    
    /**
     * Takes the loaded highscores and turn it into a string Array
     * @return all saved highscores in form of a string array
     */
    @Override
    public String[] loadHighscore(){
        return data.loadHighscore().split("\n");
    }

    /**
     * @return the choice
     */
    @Override
    public char getChoice() {
        return choice;
    }

    /**
     * @param choice the choice to set
     */
    @Override
    public void setChoice(char choice) {
        this.choice = choice;
    }
    @Override
    public boolean getIsActive(){
        return valutaMan.getIsActive();
    }
    @Override
    public String[] printQuestion(){
        return valutaMan.printQuestion(getDayToken());
    }
    @Override
    public char questionChoice(char qChoice){
        return qChoice;
    }
    /**
     * @return boolean This returns true or false depending on whether conditions are met.
     */
    @Override
    public boolean questionTime(){
        if (valutaMan.getIsActive() && (getDayToken() == 5 && valutaMan.getEncountered() == 0)){
            return true;
        }
        
        if (valutaMan.getIsActive() && (getDayToken() == 2 && (valutaMan.getEncountered() == 0 || valutaMan.getEncountered() == 1))){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * This method evaluates whether the player answered correctly or not. And punishes or rewards the player accordingly.
     * This method also keeps track of how many times the player has encountered a specific NPC to balance the game.
     * @param choice This parameter is the answer the player gave from the presentation layer.
     * @return String This returns a string used in the presentation layer to create output.
     */
    @Override
    public String answerQuestion(char choice){
        String output = "";
        if(player1.getDayToken() == 5 && valutaMan.getEncountered() == 0){
            valutaMan.setIsActive(true);
            if(getCurrentRoom() == valutaMan.getCurrentRoom()){
                if (valutaMan.getQuestion(player1.getDayToken(), choice)){
                    output += "Ludoman is proud of you and doubles your money";
                    player1.setScore(player1.getScore()*2);
                }
                    else{
                        output += "Ludoman is dissapointed and steals half your money";
                        player1.setScore(player1.getScore()/2);
                    }
            valutaMan.setEncountered(1);
            }
         }
                    
                    if(player1.getDayToken() == 2 && (valutaMan.getEncountered() == 1 || valutaMan.getEncountered() == 0)){
                        valutaMan.setIsActive(true);
                        if(getCurrentRoom() == valutaMan.getCurrentRoom()){
                          if (valutaMan.getQuestion(player1.getDayToken(), choice)){
                              output += "Ludoman is proud of you and doubles your money";
                              player1.setScore(player1.getScore()*2);
                          }
                          else{
                              output += "Ludoman is dissapointed and steals half your money";
                              player1.setScore(player1.getScore()/2);
                          }
                            valutaMan.setEncountered(2);
                        }
                    }
                    return output;
    }
}
