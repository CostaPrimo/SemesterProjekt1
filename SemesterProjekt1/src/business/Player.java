package business;

import acquaintance.IPlayer;

/**
 *
 * @author Kim
 */
public class Player implements IPlayer {
    
    private String name = "";
    private int score = 1500;
    private int timeToken = 14;
    private int dayToken = 7;
    private boolean hasWon = false;
    
    public Player(String name){
        this.name = name;
    }

    /**
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public boolean getHasWon(){
        return hasWon;
    }
    
    /**
     * @return the score
     */
    @Override
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the timeToken
     */
    @Override
    public int getTimeToken() {
        return timeToken;
    }

    /**
     * @param timeToken the timeToken to set
     */
    public void setTimeToken(int timeToken) {
        this.timeToken = timeToken;
    }

    /**
     * @return the dayToken
     */
    @Override
    public int getDayToken() {
        return dayToken;
    }

    /**
     * @param dayToken the dayToken to set
     */
    public void setDayToken(int dayToken) {
        this.dayToken = dayToken;
    }
    
}
