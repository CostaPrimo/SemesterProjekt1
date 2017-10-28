package temp;
        // Importing Hashmap and Set which are both datastructures. 
        // Set won't allow duplicates, and hashmap maps keys and values.
        // Iterator is an iterator in a collection to go through data.
import java.util.Set;
import java.util.HashMap;
//import java.util.Iterator;


/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

        //Our public class is named Room.
public class Room 
{
        //Defining datatypes.
    private String description;
    private HashMap<String, Room> exits;
        // Making our constructor that takes a string argument called description. The argument is renamed to this.decsription.
        // exits is constructed and is defined as a new hashmap object
    public Room(String description){
        this.description = description;
        exits = new HashMap<String, Room>();
    }
        
    
        //Creating a setExit method which takes a String argument named direction and a Room object named neighbor 
    public void setExit(String direction, Room neighbor){
        //Values and keys are put in the hashmap defined earlier. Direction is the key and the value is neighbour. 
        exits.put(direction, neighbor);
    }
        
    
        //The getExitString method is created.
    private String getExitString(){
        //Exits are printed out using the hashmap, it loops through all exits and adds it to a returnstring until all exits have been printed.
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit + ".";
        }
        return returnString;
    }
    
        //Creating a string method that returns the description, aswell as the possible exists for a specific room using the method on line 45.
    public String getLongDescription(){
        return "You are " + description + ".\n" + getExitString();
    }
    
        // Creating a method that returns the description.
    public String getShortDescription(){
        return description;
    }
        
    
        //A method that shows exits based on location when invoked.
    public Room getExit(String direction){
        return exits.get(direction);
    }
}