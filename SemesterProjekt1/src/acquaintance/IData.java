/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquaintance;

import org.json.JSONObject;

/**
 * The interface for the data layer
 * @author Gruppe 20
 */
public interface IData {
    /**
     * All the methods from the data layer to be used in the buisness layer
     */
    
    void saveGame(JSONObject object);
    JSONObject loadGame();
    void saveHighscore(String string);
    String loadHighscore();
    
}
