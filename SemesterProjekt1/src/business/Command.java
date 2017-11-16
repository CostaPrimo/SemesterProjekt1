package business;

/** 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
//Create the class "Command".
public class Command {
//Invokes CommandWord and creates a new string "secondWord".
    private CommandWord commandWord;
    private String secondWord;

//Creates a constructor with the arguments commandWord and secondWord.
//It uses this. to use the objects in this class.    
    public Command(CommandWord commandWord, String secondWord){
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }
    
    
//Get commandWord.
    public CommandWord getCommandWord(){
        return commandWord;
    }


//Get secondWord.
    public String getSecondWord(){
        return secondWord;
    }

    
//Check if the command has a second word.
    public boolean hasSecondWord(){
        return (secondWord != null);
    }    
    
//Check if the command is unknown.
    public boolean isUnknown(){
        return (commandWord == CommandWord.UNKNOWN);
    }
}

