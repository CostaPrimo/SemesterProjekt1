package data;

import org.json.JSONObject;
import org.json.JSONWriter;
import org.json.JSONException;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Jeppe Enevold
 */
public class Gamestate {
    private JSONObject savestate;
    private FileWriter writer;
    private JSONWriter savewriter;

    
    public static void main(String[] args){
        Gamestate test = new Gamestate();
        Player temp = new Player("john");
        test.save(temp);
    }
    
    public Gamestate() {
        try{
            this.writer = new FileWriter("src/data/saveState.json");
            this.savewriter = new JSONWriter(writer);
        }
        catch(IOException ex){
            System.out.println("git gut\n"+ex);
        }
        
        this.savestate = new JSONObject()
                .put("player", new JSONObject())
                    .put("playerName", "null")
                    .put("currentRoom", "null")
                    .put("score", 1500)
                    .put("timeToken", 14)
                    .put("dayToken", 7)
                    .put("hasWon", false)
                .put("invetories", new JSONObject())
                    .put("inventoryHouse", "test")
                    .put("invetoryRoom", "test")
                    .put("iventoryPlayer", "test")
                .put("rat", new JSONObject())
                    .put("currentRoom", "null")
                    .put("isDead", false)
                .put("scrapyardCenter", new JSONObject())
                    .put("isLocked", true);
        
                
    }
    
    private void save(Player player){
        try{
            //savestate.write(writer);
            
            this.savewriter
                .object()
                    .key("player")
                    .value(123)
                .endObject();
            
        }
        catch(JSONException ex){
            System.out.println("Fail");
        }
    }
}