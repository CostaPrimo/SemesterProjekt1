package business;

import acquaintance.INPC;

/**
 *
 * @author gruppe20
 */
public class Rat extends NPC implements INPC{
    private Room currentRoom;
    private boolean isDead;
    
    public Rat(String name, String description,Room room) {
        super(name, description);
        currentRoom = room;
        isDead = false;
    }

    
    public void setCurrentRoom(Room room){
        currentRoom = room;
    }
    
    public void setIsDead(boolean bol){
        isDead = bol;
    }
    
    public boolean getIsDead(){
        return this.isDead;
    }
    
    public Room getCurrentRoom(){
        return this.currentRoom;
    }

    @Override
    public String encounterMessage() {
        return "GRRRR\n";
    }
    
}
