package business;

import acquaintance.IItem;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Gruppe 20
 */
public class Merchant extends NPC {
    private ArrayList<IItem>inventoryMerchant;
    
    public Merchant(String name, String description) {
        super(name, description);
        inventoryMerchant = new ArrayList<IItem>();
    }
   
    
    public void addAllItems(Collection allItems){
        getInventoryMerchant().addAll(allItems);
    }
    
    public void addItem(Item item){
        getInventoryMerchant().add(item);
    }
    
    
    public String showMerchantInventory(){
        String contains = "";
        int count = 1;
        for(int i = 0; i < getInventoryMerchant().size();i++){
            contains += count + ": " + getInventoryMerchant().get(i).getName() + "\n";
            count++;
        }
        return contains;
    }
    
    
    public IItem getItemMerchant(int i){
        return getInventoryMerchant().get(i);
    }

    /**
     * @return the inventoryMerchant
     */
    public ArrayList<IItem> getInventoryMerchant() {
        return inventoryMerchant;
    }
}
