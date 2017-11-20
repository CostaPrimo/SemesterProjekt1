/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquaintance;


/**
 *
 * @author Kim Christensen
 */
public interface IBusiness {
    void injectData(IData dataLayer);
    void play();
    void setRoomRarity();
    boolean processCommand();
    void addItem();
    void buyItem();
    void dropItem();
    void goRoom();
    void inspectRoom();
    void printHelp();
    void sellItem();
    void storeItems();
    void use(int itemNumber);
    void wallet();
    //boolean buildComputer();
    boolean quit();
}
