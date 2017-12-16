package business;
        // Importing Hashmap and Set which are both datastructures. 
        // Set won't allow duplicates, and hashmap maps keys and values.
        // Iterator is an iterator in a collection to go through data.
import acquaintance.IRoom;
import java.util.Set;
import java.util.HashMap;
//import java.util.Iterator;


/**
 * <h1>Room class!</h1>
 * @author Gruppe 20
 */


public class Room implements IRoom {
        //Defining datatypes.
    private String name;
    private String description;
    private HashMap<String, Room> exits;
    private boolean isLocked;
    /**
     * Making our constructor that takes a string argument called description. The argument is renamed to this.decsription.
     * Exits is constructed and is defined as a new hashmap object
     * @param name This parameter is the name of the room.
     * @param description This parameter is thhe description
     */
    public Room(String name, String description){
        this.name = name;
        this.description = description;
        exits = new HashMap<String, Room>();
    }
    /**
     * Alternative constructor. The difference is that this room can be locked or unlocked.
     * @param description
     * @param isLocked 
     */
        public Room(String description, boolean isLocked){
        this.description = description;
        this.isLocked = isLocked;
        exits = new HashMap<String, Room>();
    }
      
    
    
    /**
     * This method takes a String argument named direction and a Room object named neighbor 
     * @param direction Which direction a specific exit is located.
     * @param neighbor which room is the room next to this room in the exit direction.
     */
    public void setExit(String direction, Room neighbor){
        //Values and keys are put in the hashmap defined earlier. Direction is the key and the value is neighbour. 
        exits.put(direction, neighbor);
    }
        
    
    /**
     * This method will get all the possible exits and combine it into a string. For instance south, west, and so on.
     * @return String which shows the possible exits. It uses a loop to loop through all the exit and the keys, which is the direction.
     */
    public String getExitString(){
        //Exits are printed out using the hashmap, it loops through all exits and adds it to a returnstring until all exits have been printed.
        String returnString = "Exits: ";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += exit + " ";
        }
        return returnString;
    }
    
    /**
     * This method will show the description of the room aswell as the exits.
     * @see #getExitString() 
     * @return String 
     */
    @Override
    public String getLongDescription(){
        return "You are " + description + ".\n" + getExitString();
    }
    
        // Creating a method that returns the description.
    @Override
    public String getShortDescription(){
        return description;
    }
    
    /**
     * This method shows exits based on location when invoked.
     * @param direction which direction the exit should be shown from the map.
     * @return This will return the room in the direction specified. For instance the room name to the south.
     */
    @Override
    public Room getExit(String direction){
        return exits.get(direction);
    }

    /**
     * @return the isLocked
     */
    @Override
    public boolean getIsLocked() {
        return isLocked;
    }

    /**
     * @param isLocked the isLocked to set
     */
    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    /**
     * @return the name
     */
    @Override
    public String getName() {
        return this.name;
    }
    
}