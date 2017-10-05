package temp;
        // Hashmap, set og Iterator importeres. Det sætter vores datastruktur op samt begrænsninger/regler. 
        // Set betyder der ikke må være duplicate af værdier i vores hashmap som vores iterator kører gennem.
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

        //Klassen defineres som værende public og kaldes room.
public class Room 
{
        //Nogle datatyper defineres.
    private String description;
    private HashMap<String, Room> exits;
        // Der vil herunder blive lavet en constructor der sætter decsription og exists.
        // Exit defineres som en ny enhed i hashmappet taget op i mod hvilket rum man er i. Der tages input her fra en variabel kaldet description
    public Room(String description) 
    {
        //Det som der indtastes når et objekt laves ud fra denne klasse, blive lagt i nogle nye variable.
        this.description = description;
        exits = new HashMap<String, Room>();
    }
        //Her laves der en funktion der hedder setExit der tager en streng kaldet direction samt et objekt af typen Room kaldet neighbor. 
    public void setExit(String direction, Room neighbor) 
    {
        //Her putter den en værdi ind i hashmappet. Direktion er key og værdien er neighbour. Dette gemmes i exist hashmappet.
        exits.put(direction, neighbor);
    }
        // Der laves en funktion der er af typen streng der returnerer description for det pågældende rum i KORT udgave.
    public String getShortDescription()
    {
        return description;
    }
        //Der laves en funktion der er af typen streng der returnerer "You are" og descriptionen for  det pågældende rum og indsætter existstring som laves på linje 45.
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }
        //Der laves en privat-funktion som udelukkende bruges i denne klasse til at printe ud de forskellige exists
	private String getExitString()
    {
        //Her printes exits ud og det gøres vha. hashmappet. Return string tilføjes der mere på i takt med at loopet gøres igennem. Alle udgange  for det pågældende rum gemmes i variablen.
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit + ".";
        }
        return returnString;
    }
        //Her er der en metode der udprinter exists ud fra den direction man er i.
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}