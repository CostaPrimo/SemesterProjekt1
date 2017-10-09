/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author nitra
 */
public class Inventory {
    private ArrayList<Item> inventoryPlayer;
    private ArrayList<Item> inventoryHouse;
    private ArrayList<Item> inventoryRoom;
    private int maxStorage;
    
    public Inventory() {
    maxStorage = 3;
    inventoryPlayer = new ArrayList<Item>();
    
}
    public void addItem(Item item){
        if (inventoryPlayer.size()<maxStorage){
            inventoryPlayer.add(item);
        }
        else {
            System.out.println("Your inventory is full");
        }
    }
    public void dropItem(int i){
        if(inventoryPlayer.size()>=i){
            inventoryPlayer.remove(i);
        }
        else{
            System.out.println("Cant drop item thats not in your inventory");
        }
    }
    public void houseAddItem(Item item){
        if (inventoryPlayer.contains(item)==true){
            inventoryHouse.add(inventoryPlayer.get(inventoryPlayer.indexOf(item)));
            inventoryPlayer.remove(inventoryPlayer.indexOf(item));
            System.out.println("Item stored");
        }
        else{
            System.out.println("This item is not in your inventory!");
        }
    }
    public void housePickItem(Item item){
        if (inventoryHouse.contains(item)==true){
            inventoryPlayer.add(inventoryHouse.get(inventoryHouse.indexOf(item)));
            inventoryHouse.remove(inventoryHouse.indexOf(item));
            System.out.println("Item picked up");
        }
        else{
            System.out.println("This item is not in your storage!");
        }
    }
    
}
