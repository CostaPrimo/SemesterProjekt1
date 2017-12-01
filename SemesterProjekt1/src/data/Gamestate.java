package data;

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
    private FileWriter writer;
    private JSONStringer savewriter;
    
    public Gamestate() {
        try{
            this.writer = new FileWriter("src/data/gamesave.json");
            this.savewriter = new JSONStringer();
        }
        catch(IOException ex){
            System.out.println("git gut\n"+ex);
        }
                
    }
    
    public void save(JSONObject savestate){
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