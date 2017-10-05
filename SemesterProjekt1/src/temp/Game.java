package temp;


// Creating public "game" class 
public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }
//    Creating a conctructor called "createRoom" where we name all the rooms and give them a description
    private void createRooms()
    {
        Room home, downtown, gamestop, merchant, scrapyardentrance, scrapyardmiddle, scrapyardwest, scrapyardeast, scrapyardsouth ;
      
        home = new Room("Home sweet home");
        downtown = new Room("Downtown connects the two shops");
        gamestop = new Room("Welcome to gamestop");
        merchant = new Room("You buying or selling");
        scrapyardentrance = new Room("Entrance to the scrapyard");
        scrapyardmiddle = new Room("Center of the scrapyard");
        scrapyardwest = new Room("West part of the scrapyard");
        scrapyardeast = new Room("East part of the scrapyard");
        scrapyardsouth = new Room("South part of the scrapyard");
        
        
//      Setting all the available exits from each of the rooms above
        home.setExit("south", downtown);
        
        downtown.setExit("north", home);
        downtown.setExit("east", merchant);
        downtown.setExit("west",gamestop);
        downtown.setExit("south", scrapyardentrance);
        
        merchant.setExit("west", downtown);
        gamestop.setExit("east", downtown);
        
        scrapyardentrance.setExit("north",downtown);
        scrapyardentrance.setExit("east", scrapyardeast);
        scrapyardentrance.setExit("west", scrapyardwest);
        scrapyardentrance.setExit("south", scrapyardmiddle);
        
        scrapyardeast.setExit("west", scrapyardentrance);
        scrapyardwest.setExit("east", scrapyardentrance);
        scrapyardmiddle.setExit("north", scrapyardentrance);
        scrapyardmiddle.setExit("south", scrapyardsouth);

       
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
        System.out.println("Type '" + CommandWord.HELP + "' IF YOU DONT KNOW WHAT TO DO");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }
    
//  Creating a boolean that prints a message when an unknown command occurs
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("YOU CANT DO THAT");
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
            System.out.println("WHERE DU YOU WANT TO GO? NORTH, EAST, WEST or SOÙTH");
            return;
        }

        //creating a string named direction which is then used to define nextRoom with the getExit method
        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);

        //If there isnt an exit defined for the given direction he program will let you know
        if (nextRoom == null) {
            System.out.println("TRY ANOTHER DIRECTION");
        }
        //If there is an exit in that given directionn set the CurrentRoom as nextRoom and print out room description
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
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
}
