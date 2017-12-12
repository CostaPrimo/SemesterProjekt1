package data;
import acquaintance.IData;
import org.json.JSONObject;

/**
 * The class that manages the I/O methods for the game
 * @author Gruppe 20
 */
public class DataFacade implements IData {
    private Highscore highscorelist = new Highscore();
    private Gamestate gameSave = new Gamestate();
    private JSONObject loadedState;
    
    /**
     * @param highscoreList data to be saved
     * @see Highscore#save(java.lang.String) 
     */
    @Override
    public void saveHighscore(String highscoreList){
        highscorelist.save(highscoreList);
    }
    
    /**
     * @return loaded data in form of a string
     * @see Highscore#load() 
     */
    @Override
    public String loadHighscore(){
        return highscorelist.load();
    }
   
    /**
     * @param saveState the JSONObject to be saved
     * @see Gamestate#save(org.json.JSONObject) 
     */
    @Override
    public void saveGame(JSONObject saveState){
        gameSave.save(saveState);
    }
    
    /**
     * @return the loaded data in form of a JSONObject
     * @see Gamestate#load() 
     */
    @Override
    public JSONObject loadGame(){
        loadedState = gameSave.load();
        return loadedState;
    }
}
