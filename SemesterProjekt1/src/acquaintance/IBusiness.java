/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquaintance;

import business.Item;
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
    void addItem(int itemNumber);
    void buyItem(int itemNumber);
    void dropItem(int itemNumber);
    void goRoom(String direction2);
    void inspectRoom();
    void printHelp();
    void sellItem(int itemNumber);
    void sleep();
    void storeItems(int itemNumber);
    void use(int itemNumber);
    void wallet();
    Room getCurrentRoom();
    void setCurrentRoom(Room currentRoom);
    ArrayList<Item> getItemMerchant();
    ArrayList<Item> getItemPlayer();
    //boolean buildComputer();
    boolean quit();
}
