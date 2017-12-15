package business;

import acquaintance.INPC;

/**
 *<h1>Rat class!</h1>
 * @author gruppe20
 */
public class Rat extends NPC implements INPC{
    private Room currentRoom;
    private boolean isDead;
    /**
     * The constructor for the rat.
     * @param name The name of the rat.
     * @param description A short description for the rat.
     * @param room The current room the rat is in, this is the starting location.
     */
    public Rat(String name, String description,Room room) {
        super(name, description);
        currentRoom = room;
        isDead = false;
    }

    /**
     * @param room Set the current room
     */
    public void setCurrentRoom(Room room){
        currentRoom = room;
    }
    /**
     * @param bol True or false for the alive or dead status for the rat.
     */
    public void setIsDead(boolean bol){
        isDead = bol;
    }
    /**
     * @return boolean that indicates whether the rat is dead or alive.
     */
    public boolean getIsDead(){
        return this.isDead;
    }
    /**
     * @return Room the current room for the rat.
     */
    public Room getCurrentRoom(){
        return this.currentRoom;
    }
    /**
     * @return String representation of the rats encounter message.
     */
    @Override
    public String encounterMessage() {
        return "GRRRR\n";
    }
    
}
