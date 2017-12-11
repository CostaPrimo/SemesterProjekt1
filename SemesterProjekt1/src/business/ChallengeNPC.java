/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acquaintance.INPC;

/**
 *
 * @author Kim Christensen
 */
public class ChallengeNPC extends NPC implements INPC{
    private boolean isActive;
    private int encountered;
    private Room currentRoom;
    private Challenge challenge;
    public ChallengeNPC(String name, String description, Room room) {
        super(name, description);
        isActive = true;
        currentRoom = room;
        challenge = new Challenge();
        encountered = 0;
    }

    /**
     * @return the isActive
     */
    public boolean getIsActive(){
        return this.isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    public boolean getQuestion(int i, char choice){
        return challenge.selectAnswer(i, choice);
        
    }
    
    public String[] printQuestion(int i){
        return challenge.printQuestion(i);
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

    /**
     * @return the encountered
     */
    public int getEncountered() {
        return encountered;
    }

    /**
     * @param encountered the encountered to set
     */
    public void setEncountered(int encountered) {
        this.encountered = encountered;
    }

    @Override
    public String encounterMessage() {
        return "A stranger approaches you and introduces himself as Ludoman. He then says\n"
                + "Win or lose, what do you choose? Time to test your knowledge!\n";
    }

    /**
     * @return the isActive
     */
}
