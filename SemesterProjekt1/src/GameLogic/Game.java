package GameLogic;

import java.util.ArrayList;
import javafx.scene.chart.Chart;
import javafx.scene.control.PopupControl;
import java.util.Scanner;
// Creating public "game" class 
public class Game {

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
    

    
    public Game() {
        createRooms();
        createNPCs();
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

        currentRoom = home;
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
    public void play() {
        
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("FINALLY DONE");
    }

    
//  Creating a method for a welcome message when starting the game and adding in a commandS
    private void printWelcome() {
        System.out.println();
        System.out.println("THIS IS THE SCRAPYARD GAME");
        System.out.println("A WORLD OF SCRAP, FUN, AND ADVENTURES");
        System.out.println("TYPE '" + CommandWord.HELP + "' IF YOU DONT KNOW WHAT TO DO");
        System.out.println("For an optional tutorial, please buy a game magazine found in a store");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }
    
    private boolean catchUserInput(Command command){
        char[] charArray = command.getSecondWord().toCharArray();
            
        if (charArray.length>1){
            System.out.println("Please only enter 1 character");
            return false;
        }
        else if (!Character.isDigit(charArray[0])){
            System.out.println("Please only enter numbers");
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
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("YOU CANT DO THAT \nTRY: ");
            parser.showCommands();
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        } 
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        } 
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        } 
        else if (commandWord == CommandWord.DROP) {
            dropItem(command);
        } 
        else if (commandWord == CommandWord.PICKUP) {
            addItem(command);
        } 
        else if (commandWord == CommandWord.INSPECT) {
            inspectRoom(command);
        } 
        else if (commandWord == CommandWord.STORE) {
            storeItems(command);
        } 
        else if (commandWord == CommandWord.BUILD) {
            wantToQuit = buildComputer(command);
        } 
        else if (commandWord == CommandWord.BUY) {
            buyItem(command);
        } 
        else if (commandWord == CommandWord.SELL){
            sellItem(command);
        }
        else if (commandWord == commandWord.USE){
            use(command);
        }
        else if (commandWord == commandWord.WALLET){
            wallet(command);
        }
        else if (commandWord == commandWord.SLEEP){
            sleep(command);
        }
          
        
        return wantToQuit;

    }

    
    private void addItem(Command command) {
        if(currentRoom.getShortDescription()=="at your home"){
            if(!command.hasSecondWord()){
                System.out.println("Which item do you want to pick up");
                System.out.println(inventoryRoom.showHouseInventory());
            }
            else{
                if(catchUserInput(command)){
                    int i = Integer.parseInt(command.getSecondWord());
                    inventoryRoom.housePickItem(inventoryRoom.getHouseitem(i));
                }
            }
        }
        else{
            if (!command.hasSecondWord()) {
                System.out.println("Which item do you want to add?" + "\n" + inventoryRoom.showRoomInventory());
            } 
            else {
                if(catchUserInput(command)!=false){
                    int i = Integer.parseInt(command.getSecondWord());
                    if(currentRoom!=rat.getCurrentRoom()){
                        if (i > 0 && i <= inventoryRoom.getMaxStorageRoom()) {
                            if(inventoryRoom.getRoomItem(i-1).isTooHeavy()!=true){
                                inventoryRoom.roomPickItem(inventoryRoom.getRoomItem(i - 1));
                                System.out.println("Item picked up");
                            }
                            else {
                                System.out.println("Item is too heavy to pickup");
                            }
                        }
                        else {
                            System.out.println("There's no items there"); 
                        }
                    }
                    else if (currentRoom==rat.getCurrentRoom() && rat.getIsDead()==true){


                        if (i > 0 && i <= inventoryRoom.getMaxStorageRoom()) {
                            if(inventoryRoom.getRoomItem(i-1).isTooHeavy()!=true){
                                inventoryRoom.roomPickItem(inventoryRoom.getRoomItem(i - 1));
                                System.out.println("Item picked up");
                            }
                            else {
                                System.out.println("Item is too heavy to pickup");
                            }
                        }
                        else {
                            System.out.println("There's no items there"); 
                        }

                    }
                    else{
                        System.out.println("Kill the rats to pickup items!");
                    }
                }      
            }
        }
    }
    private void buyItem(Command command) {
        if (currentRoom.getShortDescription() == "at the merchant") {
            if (!command.hasSecondWord()) {
                System.out.println("Which item would you like to buy? Specifiy number please " + merchantShop.showMerchantInventory());
            }
            else{
                if(catchUserInput(command)!=false){
                    if (inventoryRoom.getInventoryPlayerSize() < 3){
                        if(player1.getScore() >= merchantShop.getItemMerchant(Integer.parseInt(command.getSecondWord())).getBuyPrice()){
                        inventoryRoom.addItem(merchantShop.getItemMerchant(Integer.parseInt(command.getSecondWord())));
                        player1.setScore(player1.getScore()-merchantShop.getItemMerchant(Integer.parseInt(command.getSecondWord())).getBuyPrice());
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
        }
        else if (currentRoom.getShortDescription() == "at gamestop") {
            if (!command.hasSecondWord()) {
                System.out.println("Which item would you like to buy? Specifiy number please " + merchantGamestop.showMerchantInventory());
            }
            else{
                if(catchUserInput(command)!=false){
                    if (inventoryRoom.getInventoryPlayerSize() < 3){
                        if(player1.getScore() >= merchantGamestop.getItemMerchant(Integer.parseInt(command.getSecondWord())).getBuyPrice()){
                            inventoryRoom.addItem(merchantGamestop.getItemMerchant(Integer.parseInt(command.getSecondWord())));
                            player1.setScore(player1.getScore()-merchantGamestop.getItemMerchant(Integer.parseInt(command.getSecondWord())).getBuyPrice());
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
        }
        else{
            System.out.println("There is nothing to buy here");
        }
            
        
    }
    
    private void dropItem(Command command) {

        if (!command.hasSecondWord()) {
            System.out.println("Which item do you want to drop?" + "\n" + inventoryRoom.showPlayerInventory());
        } 
        else {
            char[] charArray = command.getSecondWord().toCharArray();
            if (charArray.length > 1) {
                System.out.println("Please only enter 1 character");
            } 
            else if (!Character.isDigit(charArray[0])) {
                System.out.println("Please only enter numbers");
            } 
            else {
                inventoryRoom.dropItem(Integer.parseInt(command.getSecondWord()));
                System.out.println("Item dropped");
            }
        }
    }
    
    //Creating a method goRoom along with a Command variable named command
    private void goRoom(Command command) {
        //If the command doesnt have a second word it ask for more arguments
        if (!command.hasSecondWord()) {
            System.out.println("WHERE DU YOU WANT TO GO?");
            return;
        }

        //creating a string named direction which is then used to define nextRoom with the getExit method
        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);

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
                    currentRoom = home;
                    player1.setTimeToken(14);
                    System.out.println("You wake up at home but you've been robbed half your money");
                    player1.setDayToken(player1.getDayToken()-1);
                    player1.setScore(player1.getScore()/2);
                    if(rat.getIsDead()){
                        rat.setIsDead(false);
                    }
                }
                else{
                    if(rat.getCurrentRoom()==currentRoom && rat.getIsDead()!=true){
                        System.out.println("The rat attacked you!");
                        player1.setTimeToken(player1.getTimeToken()-2);
                    }
                    currentRoom = nextRoom;
                    player1.setTimeToken(player1.getTimeToken()-1);
                    if(player1.getDayToken() == 7){
                        valutaMan.setIsActive(true);
                        if(currentRoom == valutaMan.getCurrentRoom()){
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
                    System.out.println(currentRoom.getLongDescription());
                    if (currentRoom.getShortDescription() == "at the center of the scrapyard") {
                        inventoryRoom.emptyRoom();
                        inventoryRoom.setRarity(inventoryRoom.roomRandomizer());
                        setRoomRarity(inventoryRoom);               
                    }
                    else if (currentRoom.getShortDescription() == "at your home"){
                        player1.setTimeToken(14);
                    }
                    else if (currentRoom.getShortDescription() == "at the east part of the scrapyard") {
                        inventoryRoom.emptyRoom();
                        inventoryRoom.setRarity(inventoryRoom.roomRandomizer());
                        setRoomRarity(inventoryRoom);
                    }
                    else if (currentRoom.getShortDescription() == "at the south part of the scrapyard") {
                        inventoryRoom.emptyRoom();
                        inventoryRoom.setRarity(inventoryRoom.roomRandomizer());
                        setRoomRarity(inventoryRoom);
                    }
                    else if (currentRoom.getShortDescription() == "at the southeast part of the scrapyard") {
                        inventoryRoom.emptyRoom();
                        inventoryRoom.setRarity(inventoryRoom.roomRandomizer());
                        setRoomRarity(inventoryRoom);
                    }
                    else if (currentRoom.getShortDescription() == "at the southwest part of the scrapyard") {
                        inventoryRoom.emptyRoom();
                        inventoryRoom.setRarity(inventoryRoom.roomRandomizer());
                        setRoomRarity(inventoryRoom);
                    }
                    else if (currentRoom.getShortDescription() == "at the west part of the scrapyard") {
                        inventoryRoom.emptyRoom();
                        inventoryRoom.setRarity(inventoryRoom.roomRandomizer());
                        setRoomRarity(inventoryRoom);
                    }
                    else if (currentRoom.getShortDescription() == "at the merchant") {
                        System.out.println("Ali: Welcome to my store, I have special prize just for you my friend take a look ");
                        System.out.println("Ali shows you the following items");
                        System.out.println(merchantShop.showMerchantInventory());
                    } 
                    else if (currentRoom.getShortDescription() == "at gamestop") {
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
    
    private void inspectRoom(Command command) {

        if (command.hasSecondWord()) {
            System.out.println("You dont need a second word");
        } 
        else {

            System.out.println("The item(s) you found in the room are:" + "\n" + inventoryRoom.showRoomInventory());
        }
    }
    
    //Making a method that prints our help messages when using the command "printHelp"
    private void printHelp() {
        System.out.println("WHAT??!");
        System.out.println("DONT YOU UNDERSTAND\n");
        System.out.println("USE THE COMMANDS: ");
        parser.showCommands();
    }

    private void ratMove(){
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
        if(rat.getCurrentRoom()==currentRoom){
            System.out.println("The rat is in this room");
        }
    }
    
    
    public void sellItem(Command command){
        if(currentRoom.getShortDescription() == "at gamestop" || currentRoom.getShortDescription() == "at the merchant"){
            if(!command.hasSecondWord()){
                System.out.println("Which item would you like to sell?"+"\n" + inventoryRoom.showPlayerInventory());
            }
            else{
                char[] charArray = command.getSecondWord().toCharArray();
            
                if (charArray.length>1){
                    System.out.println("Please only enter 1 character");
                }
                else if (!Character.isDigit(charArray[0])){
                    System.out.println("Please only enter numbers");
                }
                else{
                    if(inventoryRoom.getInventoryPlayerSize() >= Integer.parseInt(command.getSecondWord()) && Integer.parseInt(command.getSecondWord()) > 0 ){
                        player1.setScore(player1.getScore()+ inventoryRoom.getPlayerItem(Integer.parseInt(command.getSecondWord())).getSellPrice());
                        inventoryRoom.dropItem(Integer.parseInt(command.getSecondWord()));
                    }
                }
            }
        }
        else{
            System.out.println("Can't sell here");
        }
    }

    private void sleep(Command command){
        if(currentRoom.getShortDescription()=="at your home"){
            if(command.hasSecondWord()){
                System.out.println("No second word please");
            }
            else{
                player1.setDayToken(player1.getDayToken()-1);
                player1.setTimeToken(14);
                if(rat.getIsDead()){
                    rat.setIsDead(false);
                }
            }
        }
        else{
            System.out.println("you can only sleep at home");
        }
    }
    private void storeItems(Command command) {
        if (currentRoom.getShortDescription() == "at your home") {
            if (!command.hasSecondWord()) {
                System.out.println("Which item do you wish to store?" + "\n" + inventoryRoom.showPlayerInventory());
            } 
            else {

                char[] charArray = command.getSecondWord().toCharArray();
                if (charArray.length > 1) {
                    System.out.println("Please only enter 1 character");
                } 
                else if (!Character.isDigit(charArray[0])) {
                    System.out.println("Please only enter numbers");
                } 
                else {
                    int i = Integer.parseInt(command.getSecondWord());
                    if (i > 0 && i <= inventoryRoom.getInventoryPlayerSize()) {
                        inventoryRoom.houseAddItem(inventoryRoom.getPlayerItem(Integer.parseInt(command.getSecondWord())));
                    } 
                    else {
                        System.out.println("Item not found");
                    }
                }
            }
        } 
        else {
            System.out.println("You need to be at home.... to store an item in your home");
        }
    }
    
    private void use(Command command){
        if(!command.hasSecondWord()){
            System.out.println("What item do you want to use?");
        }
        else{
            if(catchUserInput(command)!=false){
                int i = Integer.parseInt(command.getSecondWord());
                if (inventoryRoom.getInventoryPlayerSize() >= i){
                    Item useableitem = inventoryRoom.getPlayerItem(i);
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
                        if(currentRoom==rat.getCurrentRoom() && rat.getIsDead()==false){
                            if(player1.getTimeToken() <= 0 ){
                                System.out.println("you have no moves left");
                                currentRoom = home;
                                System.out.println("You wake up at home but you've been robbed half your money");
                                player1.setScore(player1.getScore()/2);
                                player1.setTimeToken(14);
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
                        if(currentRoom.getShortDescription() == "at the entrance to the scrapyard"){
                            if(player1.getTimeToken() <= 0){
                                System.out.println("you have no moves left");
                                currentRoom = home;
                                System.out.println("You wake up at home but you've been robbed half your money");
                                player1.setScore(player1.getScore()/2);
                                player1.setTimeToken(14);
                                player1.setDayToken(player1.getDayToken()-1);
                                if(rat.getIsDead()){
                                    rat.setIsDead(false);
                                }
                            }
                            else{
                                System.out.println("You used crowbar and smashed the lock");
                                currentRoom.getExit("south").setIsLocked(false);
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
                else{
                    System.out.println("Cannot use item you dont have");
                }
            }
        }
    }
    
    private void wallet(Command command){
        if(command.hasSecondWord()){
            System.out.println("No need for secondword");
        }
        else {
            System.out.println("You have " + player1.getScore() + "$$$");
        }
    }
    
    
    private boolean buildComputer(Command command) {
        if (currentRoom.getShortDescription() == "at your home") {
            if (!command.hasSecondWord()) {
                inventoryRoom.buildInventoryTotal();
                while (inventoryRoom.getInventoryComputerSize() != 3){
                    if(inventoryRoom.getInventoryComputerSize()==0){
                        System.out.println("Please insert a CPU for the first slot" + "\n" + inventoryRoom.showInventoryTotal());
                        String temp = parser.returnString() + "";
                        char[] charArray = temp.toCharArray();
                        if (charArray.length > 1) {
                            System.out.println("Please only enter 1 character");
                        } 
                        else if (!Character.isDigit(charArray[0])) {
                            System.out.println("Please only enter numbers");
                        }
                        else {
                            int i = Integer.parseInt(temp);
                            if (i > 0 && i <= inventoryRoom.getInventoryTotalSize()) {
                                if(CPU.contains(inventoryRoom.getInventoryTotalItem(i))){
                                    inventoryRoom.computerAddItem(inventoryRoom.getInventoryTotalItem(i));
                                }
                                else{
                                    System.out.println("Please add a CPU in this slot");
                                }
                            }
                        }
                    }
                    else if(inventoryRoom.getInventoryComputerSize()==1){
                        System.out.println("Please insert a GPU for the second slot" + "\n" + inventoryRoom.showInventoryTotal());
                        String temp = parser.returnString() + "";
                        char[] charArray = temp.toCharArray();
                        if (charArray.length > 1) {
                            System.out.println("Please only enter 1 character");
                        } 
                        else if (!Character.isDigit(charArray[0])) {
                            System.out.println("Please only enter numbers");
                        }
                        else {
                            int i = Integer.parseInt(temp);
                            if (i > 0 && i <= inventoryRoom.getInventoryTotalSize()) {
                                if(GPU.contains(inventoryRoom.getInventoryTotalItem(i))){
                                    inventoryRoom.computerAddItem(inventoryRoom.getInventoryTotalItem(i));
                                }
                                else{
                                    System.out.println("Please add a GPU in this slot");
                                }
                            }
                        }
                    }
                    else if(inventoryRoom.getInventoryComputerSize()==2){
                        System.out.println("Please insert a RAM for the third slot" + "\n" + inventoryRoom.showInventoryTotal());
                        String temp = parser.returnString() + "";
                        char[] charArray = temp.toCharArray();
                        if (charArray.length > 1) {
                            System.out.println("Please only enter 1 character");
                        } 
                        else if (!Character.isDigit(charArray[0])) {
                            System.out.println("Please only enter numbers");
                        }
                        else {
                            int i = Integer.parseInt(temp);
                            if (i > 0 && i <= inventoryRoom.getInventoryTotalSize()) {
                                if(RAM.contains(inventoryRoom.getInventoryTotalItem(i))){
                                    inventoryRoom.computerAddItem(inventoryRoom.getInventoryTotalItem(i));
                                }
                                else{
                                    System.out.println("Please add RAM in this slot");
                                }
                            }
                        }
                    }
                }
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
                return true;
            } 
            else {
                System.out.println("You dont need to write a second word");
            }
        }
        else {
            System.out.println("You need to be at home in order to build your PC");
        }
        return false;
    }

    
    //Creating a method that return a boolean for quitting the game, the method makes use of a Command variable named command
    private boolean quit(Command command) {
        //if there is a second word the program makes sure that you want to quit the game and not a room
        if (command.hasSecondWord()) {
            System.out.println("ARE YOU SURE YOU WANT TO QUIT THE GAME?");
            return false;
        } //otherwise the method returns true which ends the game loop.
        else {
            return true;
        }
    }
}
