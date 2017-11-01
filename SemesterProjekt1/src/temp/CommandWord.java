package temp;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

/** 
* Enum define the constants GO, QUIT, HELP and UNKNOWN
* (they are constant as they are written with capitel leters)
* for the variables go, quit, help and?
*/

public enum CommandWord{
    GO("go"), INSPECT("inspect"), PICKUP("pickup"), DROP("drop"), STORE("store"), BUILD("build"), BUY("buy"), SELL("sell"), QUIT("quit"), HELP("help"), UNKNOWN("?"), USE("use"), WALLET("wallet");
    
    /**
     * CommandWord line addresed as a string, named commandString.
     * this. is used to referer to the variables in the constructor.
     */
    private String commandString;
    
    CommandWord(String commandString){
        this.commandString = commandString;
    }
    
    /**
     * The constructor returns the string value when commandString is referenced.  
     */
    public String toString(){
        return commandString;
    }
}
