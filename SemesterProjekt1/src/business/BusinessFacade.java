package business;
import acquaintance.IItem;
import acquaintance.IBusiness;
import acquaintance.IData;
import java.util.ArrayList;
import java.util.Locale; //I need help with using this.
import javafx.scene.chart.Chart;
import javafx.scene.control.PopupControl;
import java.util.Scanner;
// Creating public "game" class 
public class BusinessFacade implements IBusiness {
    private IData data;
    @Override
    public void injectData(IData dataLayer) {
        data = dataLayer;
    }
    private Parser parser;
    private Room currentRoom;
    private Inventory inventoryRoom;
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
    private int scoreToBeat = 9499;
    private Scanner nameInputTest = new Scanner(System.in);

    
    public BusinessFacade() {
        createRooms();
        createNPCs();
        nameInputTest.locale();
        createPlayerName();
        createPlayer();
        createInventories();
        createItemList();
        createItems();
        parser = new Parser();
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

    private void createInventories() {

        inventoryRoom = new Inventory("nothing"); //Why do we set a default value here?? It broke the game because no rarity room = junk = 3 storage

    }

    //Creating a conctructor called "createRoom" where we name all the rooms and give them a description
    private void createRooms() {
        home = new Room("at your home");
        downtown = new Room("at downtown");
        gamestop = new Room("at gamestop");
        merchant = new Room("at the merchant");
        scrapyardentrance = new Room("at the entrance to the scrapyard");
        scrapyardmiddle = new Room("at the center of the scrapyard", true);
        scrapyardwest = new Room("at the west part of the scrapyard");
        scrapyardeast = new Room("at the east part of the scrapyard");
        scrapyardsouth = new Room("at the south part of the scrapyard");
        scrapyardsoutheast = new Room("at the southeast part of the scrapyard");
        scrapyardsouthwest = new Room("at the southwest part of the scrapyard");

//      Setting all the available exits from each of the rooms above
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

    private void createPlayerName(){
        System.out.println("Please enter your name");
        Playername = nameInputTest.next();
    }
    
    private void createPlayer(){
         player1 = new Player(Playername);
         System.out.println(player1.getName());
    }
//  Creating a constructor for the end message using boolean when game is finished
    @Override
    public void play() {
        printWelcome();
        boolean finished = false;
        System.out.println("Thanks for playing the game");
    }

    
//  Creating a method for a welcome message when starting the game and adding in a commands
    public void printWelcome() {
        System.out.println("THIS IS THE SCRAPYARD GAME");
        System.out.println("A WORLD OF SCRAP, FUN, AND ADVENTURES");
        System.out.println("TYPE '" + CommandWord.HELP + "' IF YOU DON'T KNOW WHAT TO DO");
        System.out.println("For an optional tutorial, please buy a game magazine found in a store\n");
        System.out.println(getCurrentRoom().getLongDescription());
    }
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
    
    
//  Creating a boolean that prints a message when an unknown command occurs
//    @Override
//    private boolean processCommand(Command command) {
//        boolean wantToQuit = false;
//
//        CommandWord commandWord = command.getCommandWord();
//
//        if (commandWord == CommandWord.UNKNOWN) {
//            System.out.println("YOU CANT DO THAT \nTRY: ");
//            parser.showCommands();
//            return false;
//        }
//
//        if (commandWord == CommandWord.HELP) {
//            printHelp();
//        } 
//        else if (commandWord == CommandWord.GO) {
//            goRoom(command);
//        } 
//        else if (commandWord == CommandWord.QUIT) {
//            wantToQuit = quit(command);
//        } 
//        else if (commandWord == CommandWord.DROP) {
//            dropItem(command);
//        } 
//        else if (commandWord == CommandWord.PICKUP) {
//            addItem(command);
//        } 
//        else if (commandWord == CommandWord.INSPECT) {
//            inspectRoom(command);
//        } 
//        else if (commandWord == CommandWord.STORE) {
//            storeItems(command);
//        } 
//        else if (commandWord == CommandWord.BUILD) {
//            wantToQuit = buildComputer(command);
//        } 
//        else if (commandWord == CommandWord.BUY) {
//            buyItem(command);
//        } 
//        else if (commandWord == CommandWord.SELL){
//            sellItem(command);
//        }
//        else if (commandWord == commandWord.USE){
//            use(command);
//        }
//        else if (commandWord == commandWord.WALLET){
//            wallet(command);
//        }
//        else if (commandWord == commandWord.SLEEP){
//            sleep(command);
//        }
//          
//        
//        return wantToQuit;
//
//    }

    @Override
    public void addItem(int itemNumber) {
        if(getCurrentRoom().getShortDescription()=="at your home"){
            int i = itemNumber;
            inventoryRoom.housePickItem(inventoryRoom.getHouseitem(i));
        }
        else{
            int i = itemNumber;
            if(getCurrentRoom()!=rat.getCurrentRoom()){
                if (i >= 0 && i <= inventoryRoom.getMaxStorageRoom()) {
                    if(inventoryRoom.getRoomItem(i).isTooHeavy()!=true){
                        inventoryRoom.roomPickItem(inventoryRoom.getRoomItem(i));
                    }
                    else {
                        System.out.println("Item is too heavy to pickup");
                    }
                }
            }
            else if (getCurrentRoom()==rat.getCurrentRoom() && rat.getIsDead()){
                if (i > 0 && i <= inventoryRoom.getMaxStorageRoom()) {
                    if(inventoryRoom.getRoomItem(i).isTooHeavy()!=true){
                        inventoryRoom.roomPickItem(inventoryRoom.getRoomItem(i));
                    }
                    else {
                        System.out.println("Item is too heavy to pickup");
                    }
                }
            }
            else{
                System.out.println("Kill the rats to pickup items!");
            }
        }      
    }
    
    @Override
    public void buyItem(int itemNumber) {
        if (getCurrentRoom().getShortDescription() == "at the merchant") {
            if (inventoryRoom.getInventoryPlayerSize() < 3){
                if(player1.getScore() >= merchantShop.getItemMerchant(itemNumber).getBuyPrice()){
                    inventoryRoom.addItem(merchantShop.getItemMerchant(itemNumber));
                    player1.setScore(player1.getScore()-merchantShop.getItemMerchant(itemNumber).getBuyPrice());
                    System.out.println("Item bought");
                    }
                else{
                    System.out.println("Need more money");
                    }
                }
            else{
                System.out.println("You do not have enough space in your inventory");
                }
            }
        else if (getCurrentRoom().getShortDescription() == "at gamestop") {
            if (inventoryRoom.getInventoryPlayerSize() < 3){
                if(player1.getScore() >= merchantGamestop.getItemMerchant(itemNumber).getBuyPrice()){
                    inventoryRoom.addItem(merchantGamestop.getItemMerchant(itemNumber));
                    player1.setScore(player1.getScore()-merchantGamestop.getItemMerchant(itemNumber).getBuyPrice());
                    System.out.println("Item bought");
                }
                else{
                    System.out.println("Need more money");
                }
            }
            else{
                System.out.println("You do not have enough space in your inventory");
            }
        }
    }
    @Override
    public void dropItem(int itemNumber) {
        inventoryRoom.dropItem(itemNumber); 
        System.out.println("Item dropped");
    }
        
    
    
    //Creating a method goRoom along with a Command variable named command
    @Override
    public void goRoom(String direction2) {
        
        //creating a string named direction which is then used to define nextRoom with the getExit method
        String direction = direction2;
        Room nextRoom = getCurrentRoom().getExit(direction);

        //If there isnt an exit defined for the given direction he program will let you know
        if (nextRoom == null) {
            System.out.println("CANT GO THAT WAY");
        } //If there is an exit in that given directionn set the CurrentRoom as nextRoom and print out room description
        else {
            if(nextRoom.getIsLocked()){
                System.out.println("This room is locked, you need to break the lock first");
            }
            else{
                if (player1.getTimeToken() <= 0){
                    System.out.println("you have no moves left today");
                    setCurrentRoom(home);
                    player1.setTimeToken(20);
                    System.out.println("You wake up at home but you've been robbed half your money");
                    player1.setDayToken(player1.getDayToken()-1);
                    player1.setScore(player1.getScore()/2);
                    if(rat.getIsDead()){
                        rat.setIsDead(false);
                    }
                }
                else{
                    if(rat.getCurrentRoom()==getCurrentRoom() && rat.getIsDead()!=true){
                        System.out.println("The rat attacked you!");
                        player1.setTimeToken(player1.getTimeToken()-2);
                    }
                    setCurrentRoom(nextRoom);
                    player1.setTimeToken(player1.getTimeToken()-1);
                    if(player1.getDayToken() == 7){
                        valutaMan.setIsActive(true);
                        if(getCurrentRoom() == valutaMan.getCurrentRoom()){
                          System.out.println("Valutaman approaches you and gives you the following question");
                          if (valutaMan.getQuestion(player1.getDayToken(), parser)){
                              System.out.println("Ludoman is proud of you and doubles your money");
                              player1.setScore(player1.getScore()*2);
                          }
                          else{
                              System.out.println("Ludoman is dissapointed and steals half your money");
                              player1.setScore(player1.getScore()/2);
                          }
                          
                        }
                    }
                    else{
                        valutaMan.setIsActive(false);
                    }
                    System.out.println(player1.getTimeToken());
                    if (rat.getIsDead()!=true){
                        ratMove();
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
                        System.out.println("Ali: Welcome to my store, I have special prize just for you my friend take a look ");
                        System.out.println("Ali shows you the following items");
                        System.out.println(merchantShop.showMerchantInventory());
                    } 
                    else if (getCurrentRoom().getShortDescription() == "at gamestop") {
                        System.out.println("Mr. MountainDew: Hey, hows your pc doing? Oh wait... nvm. I broke it");
                        System.out.println("Mr. MountainDew shows you the following items");
                        System.out.println(merchantGamestop.showMerchantInventory());
                    } 
                    else {
                        inventoryRoom.emptyRoom();
                        inventoryRoom.setRarity("nothing");
                    }
                }
            }
        }
    }
    @Override
    public void inspectRoom() {
        inventoryRoom.showRoomInventory();
    }
    
    //Making a method that prints our help messages when using the command "printHelp"
    public void printHelp() {
        System.out.println("Please use the following commands:");
        parser.showCommands();
    }

    public void ratMove(){
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
        System.out.println("The rat is at " + rat.getCurrentRoom().getShortDescription());
        if(rat.getCurrentRoom()==getCurrentRoom()){
            System.out.println("The rat is in this room");
        }
    }
    
    @Override
    public void sellItem(int itemNumber){
        
        if(getCurrentRoom().getShortDescription() == "at gamestop" || getCurrentRoom().getShortDescription() == "at the merchant"){
            
                    if(inventoryRoom.getInventoryPlayerSize() >= itemNumber){
                        player1.setScore(player1.getScore()+ inventoryRoom.getPlayerItem(itemNumber).getSellPrice());
                        System.out.println("Item" + inventoryRoom.getPlayerItem(itemNumber).getName() + "sold");
                        inventoryRoom.dropItem(itemNumber);
                    }
                    else{
                        System.out.println("You do not have that item");
                    }
                
            
        }
        else{
            System.out.println("Can't sell here");
        }
    }
    @Override
    public void sleep(){
        if(getCurrentRoom().getShortDescription()=="at your home"){
            player1.setDayToken(player1.getDayToken()-1);
            player1.setTimeToken(30);
            if(rat.getIsDead()){
                rat.setIsDead(false);
            }
        }
        else{
            System.out.println("you can only sleep at home");
        }
    }
    @Override
    public void storeItems(int itemNumber) {
        if (getCurrentRoom().getShortDescription() == "at your home") {
            int i = itemNumber;
            inventoryRoom.houseAddItem(inventoryRoom.getPlayerItem(i));
        } 
        else {
            System.out.println("You need to be at home.... to store an item in your home");
        }
    }
    @Override
    public void use(int itemNumber){
        int i = itemNumber;

            IItem useableitem = inventoryRoom.getPlayerItem(i);
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
            else if (useableitem==ratPoison){
                if(getCurrentRoom()==rat.getCurrentRoom() && rat.getIsDead()==false){
                    if(player1.getTimeToken() <= 0 ){
                        System.out.println("you have no moves left");
                        setCurrentRoom(home);
                        System.out.println("You wake up at home but you've been robbed half your money");
                        player1.setScore(player1.getScore()/2);
                        player1.setTimeToken(20);
                        player1.setDayToken(player1.getDayToken()-1);
                        if(rat.getIsDead()){
                            rat.setIsDead(false);
                        }
                    }
                    else{
                        rat.setIsDead(true);
                        System.out.println("You used all your ratpoison and killed the rat!");
                        inventoryRoom.dropItem(i);
                        player1.setTimeToken(player1.getTimeToken()-1);
                    }
                }
                else{
                    System.out.println("There is no rat in this room");
                }
            }
            else if (useableitem==crowBar){
                if(getCurrentRoom().getShortDescription() == "at the entrance to the scrapyard"){
                    if(player1.getTimeToken() <= 0){
                        System.out.println("you have no moves left");
                        setCurrentRoom(home);
                        System.out.println("You wake up at home but you've been robbed half your money");
                        player1.setScore(player1.getScore()/2);
                        player1.setTimeToken(20);
                        player1.setDayToken(player1.getDayToken()-1);
                        if(rat.getIsDead()){
                            rat.setIsDead(false);
                        }
                    }
                    else{
                        System.out.println("You used crowbar and smashed the lock");
                        getCurrentRoom().getExit("south").setIsLocked(false);
                        inventoryRoom.dropItem(i);
                        System.out.println("Your crowbar broke");
                        player1.setTimeToken(player1.getTimeToken()-1);
                    }
                }
            }
            else if (useableitem==monsterBullBooster){
                System.out.println("You drank a MonsterBullBooster and gained more moves!");
                player1.setTimeToken(player1.getTimeToken()+4);
                inventoryRoom.dropItem(i);

        }
    }
    @Override
    public int wallet(){
        return this.player1.getScore();
    }
    
    @Override
    public void addParts(int itemNumber) {
        int i = itemNumber;
        if(inventoryRoom.getInventoryComputerSize()==0){
            System.out.println("Please insert a CPU for the first slot" + "\n" + inventoryRoom.showInventoryTotal());
            if(CPU.contains(inventoryRoom.getInventoryTotalItem(i))){
                inventoryRoom.computerAddItem(inventoryRoom.getInventoryTotalItem(i));
            }
            else{
                System.out.println("Please add a CPU in this slot");
            }
        }
        else if(inventoryRoom.getInventoryComputerSize()==1){
            System.out.println("Please insert a GPU for the second slot" + "\n" + inventoryRoom.showInventoryTotal());
            if(GPU.contains(inventoryRoom.getInventoryTotalItem(i))){
                inventoryRoom.computerAddItem(inventoryRoom.getInventoryTotalItem(i));
            }
            else{
                System.out.println("Please add a GPU in this slot");
            }
        }
        else if(inventoryRoom.getInventoryComputerSize()==2){
            System.out.println("Please insert a RAM for the third slot" + "\n" + inventoryRoom.showInventoryTotal());
            if(RAM.contains(inventoryRoom.getInventoryTotalItem(i))){
                inventoryRoom.computerAddItem(inventoryRoom.getInventoryTotalItem(i));
                    }
        else{
            System.out.println("Please add RAM in this slot");
        }
    } 
}
    @Override
    public void removeparts(int itemNumber){
        int i = itemNumber;
        inventoryRoom.computerRemoveItem(inventoryRoom.getComputerItem(i));
    }
    @Override
    public boolean buildComputer(){
        if(inventoryRoom.getInventoryComputerSize()==3){
            player1.setScore(0);
            for (int j = 0; j < inventoryRoom.getInventoryComputerSize(); j++) {
                player1.setScore(player1.getScore() + inventoryRoom.getComputerItem(j).getBuyPrice());
                System.out.println("Your added item is " + inventoryRoom.getComputerItem(j).getName() + " with the value of " + inventoryRoom.getComputerItem(j).getBuyPrice());
            }
            System.out.println("Your total score is " + player1.getScore());
            if(player1.getScore()>scoreToBeat){
                System.out.println("You won the game!");
            }
            else{
                System.out.println("Your computer is not better than Mr.MountainDew's pc");
                System.out.println("You lose!");
            }
        }
        else{
            return false;
        }
        return  true;
    }
    

    
    //Creating a method that return a boolean for quitting the game, the method makes use of a Command variable named command
    @Override
    public boolean quit() {
        return true;
    }

    /**
     * @return the currentRoom
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }
    @Override
    public ArrayList<IItem> getItemMerchant(){
        return merchantShop.getInventoryMerchant();
    }

    /**
     * @param currentRoom the currentRoom to set
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
}
