package acquaintance;
import org.json.JSONObject;

/**
 * The interface for the data layer
 * Contains all the methods to be used in other layers
 * @author Gruppe 20
 */
public interface IData {
    
    void saveGame(JSONObject object);
    JSONObject loadGame();
    void saveHighscore(String string);
    String loadHighscore();
    
}
