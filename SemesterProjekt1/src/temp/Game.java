package temp;


// Creating public "game" class 
public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Inventory inventoryPlayer, inventoryRoom;
    Item JGPU, NGPU, RGPU, EGPU, LGPU;
    Item JRAM, NRAM, RRAM, ERAM, LRAM;
    Item JCPU, NCPU, RCPU, ECPU, LCPU;
        
    public Game() 
    {
        createRooms();
        createItems();
        createInventories();
        parser = new Parser();
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
     
    }
    
    private void createInventories(){
        inventoryPlayer = new Inventory();
        inventoryRoom = new Inventory("junk");
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

        home.setExit("downtown", downtown);
        
        downtown.setExit("home", home);
        downtown.setExit("merchant", merchant);
        downtown.setExit("gamestop",gamestop);
        downtown.setExit("scrapyardentrance", scrapyardentrance);
        
        merchant.setExit("downtown", downtown);
        gamestop.setExit("downtown", downtown);
        
        scrapyardentrance.setExit("downtown",downtown);
        scrapyardentrance.setExit("scrapyardyeast", scrapyardeast);
        scrapyardentrance.setExit("scrapyardwest", scrapyardwest);
        scrapyardentrance.setExit("scrapyardmiddle", scrapyardmiddle);
        
        scrapyardeast.setExit("scrapyardentrance", scrapyardentrance);
        scrapyardwest.setExit("scrapyardentrance", scrapyardentrance);
        scrapyardmiddle.setExit("scrapyardentrance", scrapyardentrance);
        scrapyardmiddle.setExit("scrapyardsouth", scrapyardsouth);

       
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
                inventoryRoom.setRarity(inventoryRoom.roomRamdomizer());
            }
            else if (currentRoom.getShortDescription() == "at the east part of the scrapyard"){
                inventoryRoom.setRarity(inventoryRoom.roomRamdomizer());
            }
            else if (currentRoom.getShortDescription() == "at the south part of the scrapyard"){
                inventoryRoom.setRarity(inventoryRoom.roomRamdomizer());
            }
            else if (currentRoom.getShortDescription() == "at the west part of the scrapyard"){
                inventoryRoom.setRarity(inventoryRoom.roomRamdomizer());
            }
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
            System.out.println("Which item do you want to drop?" + "\n" + inventoryPlayer.showPlayerInventory());
        }
        else{
        inventoryPlayer.dropItem(Integer.parseInt(command.getSecondWord()));
        }
    }
    private void addItem(Command command){
        
        if(!command.hasSecondWord()) {
            System.out.println("Which item do you want to add?" + "\n" + inventoryPlayer.showPlayerInventory());
        }
        else{
        inventoryPlayer.addItem(RCPU);
        }
    }
}
