/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

/**
 *
 * @author Kim
 */
public class Player {
    
    private String name = "";
    private int score = 1500;
    private int timeToken = 14;
    private int dayToken = 7;
    public Player(String name){
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the score
     */
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
