package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Jeppe Enevold
 */
public class Highscore {        
    
    
    //FileWriter saveFile;
    private FileWriter scoreWriter;
    
    private FileReader loadFile;
    private BufferedReader scoreReader;    

    public Highscore(){
        try{
            scoreWriter = new FileWriter("src/data/Highscores.txt");
            loadFile = new FileReader("src/data/Highscores.txt");
            scoreReader = new BufferedReader(loadFile);
        }
        catch(IOException ex){
            System.out.println("Error: " + ex);
        }
    }
    
    public String save(String scores){
        try{
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




