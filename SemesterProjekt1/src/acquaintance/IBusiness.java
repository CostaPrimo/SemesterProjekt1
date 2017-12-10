/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquaintance;

import business.Room;
import java.util.ArrayList;


/**
 *
 * @author Gruppe 20
 */
public interface IBusiness {
    void injectData(IData dataLayer);
    void play();
    //boolean processCommand();
    String addItem(int itemNumber);
    String buyItem(int itemNumber);
    String dropItem(int itemNumber);
    String goRoom(String direction2);
    String[] loadHighscore();
    void inspectRoom();
    void loadGame();
    void printHelp();
    void saveGame();
    void saveHighscore();
    String sellItem(int itemNumber);
    String sleep();
    String storeItems(int itemNumber);
    String use(int itemNumber);
    int wallet();
    int getDayToken();
    int getTimeToken();
    Room getCurrentRoom();
    Room getRatCurrentRoom();
    void setCurrentRoom(Room currentRoom);
    ArrayList<IItem> getItemMerchant();
    ArrayList<IItem> getItemPlayer();
    ArrayList<IItem> getItemGamestop();
    ArrayList<IItem> getItemRoom();
    ArrayList<IItem> getInventoryTotal();
    ArrayList<IItem> getInventoryComputer();
    ArrayList<IItem> getInventoryHouse();
    String addParts(int itemNumber);
    String removeparts(int itemNumber);
    void setPlayerName(String playerName);
    String[] buildComputer();
    boolean requiredPartsChecker();
    boolean timeToBuild();
    boolean quit();
    char getChoice();
    void setChoice(char choice);
    boolean getIsActive();
}
