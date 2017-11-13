/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

/**
 *
 * @author Kim Christensen
 */
public class ChallengeNPC extends NPC {
    private boolean isActive;
    private Room currentRoom;
    private Challenge challenge;
    public ChallengeNPC(String name, String description, Room room) {
        super(name, description);
        isActive = false;
        currentRoom = room;
        challenge = new Challenge();
    }

    /**
     * @return the isActive
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    public boolean getQuestion(int i, Parser ind){
        return challenge.selectAnswer(i, ind);
        
    }

    /**
     * @return the currentRoom
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * @param currentRoom the currentRoom to set
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    
    
    
}
