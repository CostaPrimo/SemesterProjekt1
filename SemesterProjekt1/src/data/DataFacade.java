package data;

import acquaintance.IData;
import org.json.JSONObject;

/**
 *
 * @author Gruppe 20
 */
public class DataFacade implements IData {
    private Highscore highscorelist = new Highscore();
    private Gamestate gameSave = new Gamestate();
    private JSONObject loadedState;
    
    @Override
    public void saveHighscore(String highscoreList){
        highscorelist.save(highscoreList);
    }
    
    @Override
    public String loadHighscore(){
        return highscorelist.load();
    }
   
    @Override
    public void saveGame(JSONObject saveState){
        gameSave.save(saveState);
    }
    
    @Override
    public JSONObject loadGame(){
        loadedState = gameSave.load();
        return loadedState;
    }
}
