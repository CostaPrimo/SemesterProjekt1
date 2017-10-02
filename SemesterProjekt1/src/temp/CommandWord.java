package temp;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

/**
* Enum definere konstanterne GO, QUIT, HELP og UNKNOWN 
*(de er konstante da de er med stort)
* til variablerne go, quit, help og ?.
*/

public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?");
    
    /**
     * CommandWord linjen bliver lavet til en string, benævnt commandString.
     * this. bruges for at referer til de overnævnte variabler i constructoren.
     */
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    /**
     * constructoren retunere string værdierne når commandString hentes.  
     */
    public String toString()
    {
        return commandString;
    }
}
