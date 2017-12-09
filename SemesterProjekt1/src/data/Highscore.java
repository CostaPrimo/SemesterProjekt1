package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Jeppe Enevold
 */
public class Highscore {        
    
    public Highscore(){

    }
    
    public String save(String scores){
        try{
            FileWriter scoreWriter = new FileWriter("src/data/Highscores.txt");
            scoreWriter.write(scores);
            scoreWriter.close();
            return "Game Saved";
        }
        catch(IOException ex){
            return "Save Error\nError: " + ex;
        }
    }
    
    public String load(){
        String getLine;
        String outputLine = "";
        
        try{
            FileReader loadFile = new FileReader("src/data/Highscores.txt");
            BufferedReader scoreReader = new BufferedReader(loadFile);
            getLine = scoreReader.readLine();
            while (getLine != null){
                outputLine += getLine;
                getLine = scoreReader.readLine();
            }
            scoreReader.close();
            return outputLine;
        }
        catch(IOException ex){
            return "Error loading file\nError:\n" + ex;
        }
        
    }

}




