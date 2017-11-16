package business;

import java.util.HashMap;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class CommandWords {
    //Creating a Private HashMap that is constructed from a String and CommandWord, this HashMap is named "validCommands"
    private HashMap<String, CommandWord> validCommands;

    //Creating a constructor for CommandWords
    public CommandWords(){
        //The Hashmap is defined and all the valid commandWords that isnt unknown are added to the HashMap
        validCommands = new HashMap<String, CommandWord>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    
    //Creating a method getCommandWord that returns a commandWord
    public CommandWord getCommandWord(String commandWord){
        //Creating and defining a CommandWord named command and add "commandWord" from the validCommands HashMap
        CommandWord command = validCommands.get(commandWord);
        
        //If the command has a value in the HashMap the CommandWord is returned, else the "Unknown" command is returned 
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    
    //Creating a method that returns True or False based on validity
    public boolean isCommand(String aString){
        return validCommands.containsKey(aString);
    }

    
    //Creating a method that prints all the valid commands
    public void showAll(){
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
