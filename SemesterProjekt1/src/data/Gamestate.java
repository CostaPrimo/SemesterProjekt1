package data;

import business.Player;
import org.json.JSONObject;
import org.json.JSONStringer;
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
    private JSONStringer savewriter;

    
    public static void main(String[] args){
        Player temp = new Player("Bob");
        Gamestate test = new Gamestate(temp);
        test.save();
    }
    
    public Gamestate(Player player) {
        try{
            this.writer = new FileWriter("src/data/gamesave.json");
            this.savewriter = new JSONStringer();
        }
        catch(IOException ex){
            System.out.println("git gut\n"+ex);
        }
        
        this.savestate = new JSONObject()
                /*
                .put("playerName", "null")
                .put("currentRoom", "null")
                .put("score", 1500)
                .put("timeToken", 14)
                */
                .put("player", player)
                .put("dayToken", 7)
                .put("hasWon", false)
                .put("inventoryHouse", "test")
                .put("invetoryRoom", "test")
                .put("iventoryPlayer", "test")
                .put("currentRoom", "null")
                .put("isDead", false)
                .put("isLocked", true);
        
                
    }
    
    private void save(){
        try{
            //savestate.write(writer);
            this.writer.write(
                this.savewriter
                    .object()
                        .key("savestate")
                        .value(savestate)
                    .endObject()
            .toString());
            this.writer.close();
            System.out.println("success");
            
        }
        catch(JSONException ex){
            System.out.println("Fail\n"+ex);
        }
        catch(IOException ex){
            System.out.println("Fail\n"+ex);
        }
    }
}