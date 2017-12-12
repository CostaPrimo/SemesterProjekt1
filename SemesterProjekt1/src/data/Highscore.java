package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The class that manages I/O for the Highscores.txt file
 * @author Gruppe 20
 */
public class Highscore {        
    public Highscore(){}
    
    /**
     * The method that saves to Highscores.txt
     * @param scores a string containing all the scores to be saved to Highscores.txt  
     */
    public void save(String scores){
        try{
            FileWriter scoreWriter = new FileWriter("src/data/Highscores.txt");
            scoreWriter.write(scores);
            scoreWriter.close();
        }
        catch(IOException ex){
        }
    }
    
    /**
    * The method that loads the data in Highscores.txt
    * @return the saved Highscore 
    */
    public String load(){
        String getLine;
        String outputLine = "";
        
        try{
            FileReader loadFile = new FileReader("src/data/Highscores.txt");
            BufferedReader scoreReader = new BufferedReader(loadFile);
            getLine = scoreReader.readLine();
            while (getLine != null){
                outputLine += getLine+"\n";
                getLine = scoreReader.readLine();
            }
            scoreReader.close();
            loadFile.close();
            return outputLine;
        }
        catch(IOException ex){
            return "Error loading file\nError:\n" + ex;
        }
    }
}




