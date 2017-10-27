package temp;
import java.util.ArrayList;
import javafx.scene.chart.Chart;

// Creating public "game" class 
public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Inventory inventoryRoom;
    Item JGPU, NGPU, RGPU, EGPU, LGPU;
    Item JRAM, NRAM, RRAM, ERAM, LRAM;
    Item JCPU, NCPU, RCPU, ECPU, LCPU;
    ArrayList<Item> junk, normal, rare, epic, legendary;
    private int score = 0;
    public Game() 
    {
        createRooms();
        createInventories();
        createItemList();
        createItems();
        parser = new Parser();
    }
    
    private void createItemList(){
        junk = new ArrayList <>();
        normal = new ArrayList <>();
        rare = new ArrayList <>();
        epic = new ArrayList <>();
        legendary = new ArrayList <>();
        
        
    }
    private void createItems(){
        JGPU = new Item("GTX 550ti", "junk", 600, 400);
        NGPU = new Item("GTX 760", "normal", 900, 600);
        RGPU = new Item("GTX 960", "rare", 1500, 1000);
        EGPU = new Item("GTX 1070", "epic", 3500, 2300);
        LGPU = new Item("GTX Titan XP", "legendary", 8000, 4000);
        JRAM = new Item("DDR 512 MB","junk", 50, 30);
        NRAM = new Item("DDR2 2 GB","normal", 100, 50);
        RRAM = new Item("DDR3 4 GB","rare", 300, 150);
        ERAM = new Item("DDR3 8 GB","epic", 1000, 500);
        LRAM = new Item("DDR4 16 GB","legendary", 2000, 1000);
        JCPU = new Item("i3 1.8 GHz", "junk", 600, 400);
        NCPU = new Item("i5 2.5 GHz", "normal", 1200, 800);
        RCPU = new Item("i7 3.7 GHz", "rare", 3000, 2000);
        ECPU = new Item("Threadripper 4 GHz", "epic", 5000, 3300);
        LCPU = new Item("i9 6 GHz", "legendary", 7000, 4600);
     
        junk.add(JGPU); junk.add(JRAM); junk.add(JCPU);
        normal.add(NGPU); normal.add(NRAM); normal.add(NCPU);
        rare.add(RGPU); rare.add(RRAM); rare.add(RCPU);
        epic.add(EGPU); epic.add(ERAM); epic.add(ECPU);
        legendary.add(LGPU); legendary.add(LRAM); legendary.add(LCPU);
    }
    
    private void createInventories(){
        
        inventoryRoom = new Inventory("nothing"); //Why do we set a default value here?? It broke the game because no rarity room = junk = 3 storage
        
    }
//    Creating a conctructor called "createRoom" where we name all the rooms and give them a description
    private void createRooms()
    {
        Room home, downtown, gamestop, merchant, scrapyardentrance, scrapyardmiddle, scrapyardwest, scrapyardeast, scrapyardsouth ;
      
        home = new Room("at your home");
        downtown = new Room("at downtown");
        gamestop = new Room("at gamestop");
        merchant = new Room("at the merchant");
        scrapyardentrance = new Room("at the entrance to the scrapyard");
        scrapyardmiddle = new Room("at the center of the scrapyard");
        scrapyardwest = new Room("at the west part of the scrapyard");
        scrapyardeast = new Room("at the east part of the scrapyard");
        scrapyardsouth = new Room("at the south part of the scrapyard");
        
        
//      Setting all the available exits from each of the rooms above

        home.setExit("south", downtown);
        
        downtown.setExit("north", home);
        downtown.setExit("east", merchant);
        downtown.setExit("west",gamestop);
        downtown.setExit("south", scrapyardentrance);
        
        merchant.setExit("west", downtown);
        gamestop.setExit("east", downtown);
        
        scrapyardentrance.setExit("north",downtown);
        scrapyardentrance.setExit("south", scrapyardmiddle);
        
        scrapyardeast.setExit("west", scrapyardmiddle);
        scrapyardwest.setExit("east", scrapyardmiddle);
        scrapyardsouth.setExit("north", scrapyardmiddle);
        scrapyardmiddle.setExit("north", scrapyardentrance);
        scrapyardmiddle.setExit("south", scrapyardsouth);
        scrapyardmiddle.setExit("east", scrapyardeast);
        scrapyardmiddle.setExit("west", scrapyardwest);

       
        currentRoom = home;
    }
//  Creating a constructor for the end message using boolean when game is finished
    public void play() 
    {            
        printWelcome();

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("FINALLY DONE");
    }
//  Creating a method for a welcome message when starting the game and adding in a commandS
    private void printWelcome()
    {
        System.out.println();
        System.out.println("THIS IS THE SCRAPYARD GAME");
        System.out.println("A WORLD OF SCRAP, FUN, AND ADVENTURES");
        System.out.println("TYPE '" + CommandWord.HELP + "' IF YOU DONT KNOW WHAT TO DO");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }
    
//  Creating a boolean that prints a message when an unknown command occurs
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
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
        else if (commandWord == CommandWord.DROP){
            dropItem(command);
        }
        else if (commandWord == CommandWord.PICKUP){
            addItem(command);
        }
        else if (commandWord == CommandWord.INSPECT){
            inspectRoom(command);
        }
        else if (commandWord == CommandWord.STORE){
            storeItems(command);
        }
        else if (commandWord == CommandWord.BUILD) {
            wantToQuit = buildComputer(command);
            
        }
        return wantToQuit;
        
        
    }
//  Making a method that prints our help messages when using the command "printHelp"
    private void printHelp() 
    {
        System.out.println("WHAT??!");
        System.out.println("DONT YOU UNDERSTAND");
        System.out.println();
        System.out.println("USE THE COMMANDS: ");
        parser.showCommands();
    }
//Creating a method goRoom along with a Command variable named command
    private void goRoom(Command command) 
    {
        //If the command doesnt have a second word it ask for more arguments
        if(!command.hasSecondWord()) {
            System.out.println("WHERE DU YOU WANT TO GO?");
            return;
        }

        //creating a string named direction which is then used to define nextRoom with the getExit method
        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);

        //If there isnt an exit defined for the given direction he program will let you know
        if (nextRoom == null) {
            System.out.println("CANT GO THAT WAY");
        }
        //If there is an exit in that given directionn set the CurrentRoom as nextRoom and print out room description
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            if (currentRoom.getShortDescription() == "at the center of the scrapyard"){
                inventoryRoom.emptyRoom();
                inventoryRoom.setRarity(inventoryRoom.roomRamdomizer());
                //<editor-fold defaultstate="collapsed" desc="Center">
                

                if (inventoryRoom.getRarity() == "junk"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(junk.get(random));
                    }
                }
                else if (inventoryRoom.getRarity() == "normal"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(normal.get(random));
                    }
                }
                else if (inventoryRoom.getRarity() == "rare"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(rare.get(random));
                    }
                }
                else if (inventoryRoom.getRarity() == "epic"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(epic.get(random));
                    }
                }
                else if (inventoryRoom.getRarity() == "legendary"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(legendary.get(random));
                    }
                }
            }
            //</editor-fold>
            else if (currentRoom.getShortDescription() == "at the east part of the scrapyard"){
                inventoryRoom.emptyRoom();
                inventoryRoom.setRarity(inventoryRoom.roomRamdomizer());
                //<editor-fold defaultstate="collapsed" desc="east">
                
                if (inventoryRoom.getRarity() == "junk"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(junk.get(random));
                    }
                }
                else if (inventoryRoom.getRarity() == "normal"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(normal.get(random));
                    }
                }
                else if (inventoryRoom.getRarity() == "rare"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(rare.get(random));
                    }
                }
                else if (inventoryRoom.getRarity() == "epic"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(epic.get(random));
                    }
                }
                else if (inventoryRoom.getRarity() == "legendary"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(legendary.get(random));
                    }
                }
                
            }
            //</editor-fold>
            else if (currentRoom.getShortDescription() == "at the south part of the scrapyard"){
                inventoryRoom.emptyRoom();
                inventoryRoom.setRarity(inventoryRoom.roomRamdomizer());
                //<editor-fold defaultstate="collapsed" desc="south">
                
                if (inventoryRoom.getRarity() == "junk"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(junk.get(random));
                    }
                }
                else if (inventoryRoom.getRarity() == "normal"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(normal.get(random));
                    }
                }
                else if (inventoryRoom.getRarity() == "rare"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(rare.get(random));
                    }
                }
                else if (inventoryRoom.getRarity() == "epic"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(epic.get(random));
                    }
                }
                else if (inventoryRoom.getRarity() == "legendary"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(legendary.get(random));
                    }
                }
            }
            //</editor-fold>
            else if (currentRoom.getShortDescription() == "at the west part of the scrapyard"){
                inventoryRoom.emptyRoom();
                inventoryRoom.setRarity(inventoryRoom.roomRamdomizer());
                //<editor-fold defaultstate="collapsed" desc="west">
                
                if (inventoryRoom.getRarity() == "junk"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(junk.get(random));
                    }
                }
                else if (inventoryRoom.getRarity() == "normal"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(normal.get(random));
                    }
                }
                else if (inventoryRoom.getRarity() == "rare"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(rare.get(random));
                    }
                }
                else if (inventoryRoom.getRarity() == "epic"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(epic.get(random));
                    }
                }
                else if (inventoryRoom.getRarity() == "legendary"){
                    for (int i = 0; i <  inventoryRoom.getMaxStorageRoom(); i++){
                        int random = (int) (Math.random()*3);
                        inventoryRoom.roomAddItem(legendary.get(random));
                    }
                }
            }
            //</editor-fold>
            else { 
                inventoryRoom.emptyRoom();
            }
           
        }
    }

    //Creating a method that return a boolean for quitting the game, the method makes use of a Command variable named command
    private boolean quit(Command command) 
    {
        //if there is a second word the program makes sure that you want to quit the game and not a room
        if(command.hasSecondWord()) {
            System.out.println("ARE YOU SURE YOU WANT TO QUIT THE GAME?");
            return false;
        }
        //otherwise the method returns true which ends the game loop.
        else {
            return true;
        }
    }
    
    private void dropItem(Command command){
        
        if(!command.hasSecondWord()) {
            System.out.println("Which item do you want to drop?" + "\n" + inventoryRoom.showPlayerInventory());
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
        inventoryRoom.dropItem(Integer.parseInt(command.getSecondWord()));
            }
        }
    }
    private void addItem(Command command){
        
        if(!command.hasSecondWord()) {
            System.out.println("Which item do you want to add?" + "\n" + inventoryRoom.showRoomInventory());
        }
        else{
            char [] charArray = command.getSecondWord().toCharArray();
            if (charArray.length>1){
                System.out.println("Please only enter 1 character");
            }
            else if (!Character.isDigit(charArray[0])){
                System.out.println("Please only enter numbers");
            }
            else {
                int i = Integer.parseInt(command.getSecondWord());
                
                if(i>0 && i<=inventoryRoom.getMaxStorageRoom()){
                    inventoryRoom.roomPickItem(inventoryRoom.getRoomItem(i-1));
                }
                else{
                    System.out.println("There's no items there");
                }
            }
        }
    }
    private void inspectRoom(Command command){
        
        if(command.hasSecondWord()) {
            System.out.println("You dont need a second word");
        }
        else{
            
            System.out.println("The item(s) you found in the room are:" + "\n" + inventoryRoom.showRoomInventory());
        }
    }
    private void storeItems(Command command) {
        if(currentRoom.getShortDescription() == "at your home"){
            if(!command.hasSecondWord()){
                System.out.println("Which item do you wish to store?" + "\n" + inventoryRoom.showPlayerInventory());
            }
            else{

                char [] charArray = command.getSecondWord().toCharArray();        
                if (charArray.length>1){
                    System.out.println("Please only enter 1 character");
                }
                else if (!Character.isDigit(charArray[0])){
                    System.out.println("Please only enter numbers");
                }
                else {
                    int i = Integer.parseInt(command.getSecondWord());
                    if (i> 0 && i <= inventoryRoom.getInventoryPlayerSize()) {
                        inventoryRoom.houseAddItem(inventoryRoom.getPlayerItem(Integer.parseInt(command.getSecondWord())));
                    }
                    else {
                        System.out.println("Item not found");
                        }
                }
            }
        }
        else{
            System.out.println("You need to be at home.... to store an item in your home");
        }
    }
    private boolean buildComputer (Command command){
        inventoryRoom.buildInventoryTotal();
        if(currentRoom.getShortDescription() == "at your home"){
        if (!command.hasSecondWord()){
            System.out.println("Which item do you want to build into your computer?" + "\n" + inventoryRoom.showInventoryTotal() );
        }
        else{
            char [] charArray = command.getSecondWord().toCharArray();
            if (charArray.length>1){
                System.out.println("Please only enter 1 character");
            }
            else if (!Character.isDigit(charArray[0])){
                System.out.println("Please only enter numbers");
            }
            
            else {
                int i = Integer.parseInt(command.getSecondWord());
                if (i> 0 && i <= inventoryRoom.getInventoryPlayerSize()) {
                    inventoryRoom.computerAddItem(inventoryRoom.getInventoryTotalItem(Integer.parseInt(command.getSecondWord())));
                    if(inventoryRoom.getInventoryComputerSize() == 3){
                        for(int j = 0; j < inventoryRoom.getInventoryComputerSize();j++){
                            score += inventoryRoom.getComputerItem(j).getBuyPrice();
                            System.out.println("Your added item is " + inventoryRoom.getComputerItem(j).getName() + " with the value of " + inventoryRoom.getComputerItem(j).getBuyPrice());
                        }
                        System.out.println("Your total score is " + score);
                        return true;
                    }
                }
                else {
                    System.out.println("Item not found");
                    
                    }
            }
            
        }
        }
        else{
            System.out.println("You need to be at home in order to build your PC");
        }
        return false;
    // Trying to think if I can create a input validation method instead of retyping
   // private String inputTester(Command command){
        
    //}
    }
}
