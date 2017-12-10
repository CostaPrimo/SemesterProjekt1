package data;

import acquaintance.IData;
import org.json.JSONObject;

/**
 *
 * @author Gruppe 20
 */
public class DataFacade implements IData {
    private Highscore highscorelist = new Highscore();
    private Gamestate gameSave = new Gamestate();
    
    private JSONObject loadedState;
    
    /*
    private String sortScores(IPlayer player){
        
        String newEntry = player.getName()+ " " + player.getScore()+"\n";
        String currentScores = highscorelist.load()+newEntry;
        String newScores = "";
        
        String[]scoreEntries = currentScores.split("\n");
        int[]entryPoints = new int[scoreEntries.length];
        String[]tempArray;
        
        for(int i = 0; i<scoreEntries.length;i++){
            tempArray = scoreEntries[i].split(" ");
            entryPoints[i]= Integer.parseInt(tempArray[1]);
        }
        
        Arrays.sort(entryPoints, 0, entryPoints.length);
        
        
        for(int j = 0; j<scoreEntries.length;j++){
            int k = scoreEntries.length-1;
            while(k>=0){
                tempArray = scoreEntries[j].split(" ");
                if(Integer.parseInt(tempArray[1])== entryPoints[k]){
                    newScores += scoreEntries[j]+"\n";
                    k++;
                    j=0;
                }
            }
        }
        
        return newScores;
    }
    */
    
    
    @Override
    public void saveHighscore(String highscoreList){
        highscorelist.save(highscoreList);
    }
    
    @Override
    public String[] loadHighscore(){
        return highscorelist.load().split("\n");
    }
   
    @Override
    public void saveGame(JSONObject saveState){
        gameSave.save(saveState);
    }
    
    @Override
    public JSONObject loadGame(){
        loadedState = gameSave.load();
        return loadedState;
    }
    
}
