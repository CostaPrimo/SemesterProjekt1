/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquaintance;

import org.json.JSONObject;

/**
 *
 * @author Kim Christensen
 */
public interface IData {
    void injectPlayer(IPlayer player);
    void injectInventory(IInventory inventory);
    void injectRat(IRat rat);
    void saveGame();
    JSONObject loadGame();
    void saveHighscore();
    String loadHighscore();
    
}
