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
 * @author Gruppe 20
 */
public class Gamestate {
    
    public Gamestate(){}
    
    public void save(JSONObject savestate){
        try{
            FileWriter writer = new FileWriter("src/data/gamesave.json");
            JSONStringer savewriter = new JSONStringer();
            writer.write(
                savewriter
                    .object()
                        .key("savestate")
                        .value(savestate)
                    .endObject()
            .toString());
            writer.close();
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
        String getLine="";
        String jsontext = "";
        
        try{
            FileReader reader = new FileReader("src/data/gamesave.json");
            BufferedReader saveReader = new BufferedReader(reader);
            while (getLine != null){
                jsontext += getLine;
                getLine = saveReader.readLine();
            }
            saveReader.close();
        }
        catch(IOException ex){
            System.out.println("Error\n"+ex);
        }
        
        JSONObject savedState = new JSONObject(jsontext);
        return savedState;
    }
}