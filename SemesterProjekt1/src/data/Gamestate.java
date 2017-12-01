package data;

import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
/**
 *
 * @author Jeppe Enevold
 */
public class Gamestate {
    private FileWriter writer;
    private FileReader reader;
    private BufferedReader saveReader;
    private JSONStringer savewriter;
    private JSONObject savedState;
    
    public Gamestate() {
        try{
            this.writer = new FileWriter("src/data/gamesave.json");
            this.reader = new FileReader("src/data/gamesave.json");
            this.saveReader = new BufferedReader(this.reader);
            this.savewriter = new JSONStringer();
        }
        catch(IOException ex){
            System.out.println("Error\n"+ex);
        }
                
    }
    
    public void save(JSONObject savestate){
        try{
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
            System.out.println("Error\n"+ex);
        }
        catch(IOException ex){
            System.out.println("Error\n"+ex);
        }
    }
    
    public JSONObject load(){
        String getLine;
        String jsontext = "";
        
        try{
            getLine = saveReader.readLine();
            while (getLine != null){
                jsontext += getLine;
                getLine = saveReader.readLine();
            }
            saveReader.close();
        }
        catch(IOException ex){
            System.out.println("");
        }
        
        this.savedState = new JSONObject(jsontext);
        return this.savedState;
    }
}