package business;

import acquaintance.INPC;
import acquaintance.IRat;

/**
 *
 * @author gruppe20
 */
public class Rat extends NPC implements IRat,INPC{
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
    
    @Override
    public boolean getIsDead(){
        return this.isDead;
    }
    
    @Override
    public Room getCurrentRoom(){
        return this.currentRoom;
    }

    @Override
    public String encounterMessage() {
        return "GRRRR\n";
    }
    
}
