/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Gruppe 20
 */
public class Merchant extends NPC {
    private ArrayList<Item>inventoryMerchant;
    public Merchant(String name, String description) {
        super(name, description);
        inventoryMerchant = new ArrayList<>();
    }
    public void addItem(Item item){
        inventoryMerchant.add(item);
    }
    public void addAllItems(Collection allItems){
        inventoryMerchant.addAll(allItems);
    }
    
    public String showMerchantInventory(){
        String contains = "";
        int count = 1;
        for(int i = 0; i < inventoryMerchant.size();i++){
            contains += count + ": " + inventoryMerchant.get(i).getName() + "\n";
            count++;
        }
        return contains;
    }
    
   public Item getItemMerchant(int i){
       return inventoryMerchant.get(i-1);
   }
}
