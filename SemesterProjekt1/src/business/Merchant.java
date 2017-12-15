package business;

import acquaintance.IItem;
import acquaintance.INPC;
import java.util.ArrayList;
import java.util.Collection;

/**
 *<h1>Merchant class!</h1>
 * @author Gruppe 20
 */
public class Merchant extends NPC implements INPC{
    private ArrayList<IItem>inventoryMerchant;
    
    public Merchant(String name, String description) {
        super(name, description);
        inventoryMerchant = new ArrayList<IItem>();
    }
   
    /**
     * This method will add all the items from the parameter to the inventorymerchant inventory.
     * @param allItems This parameter is a collection datatype.
     */
    public void addAllItems(Collection allItems){
        getInventoryMerchant().addAll(allItems);
    }
    /**
     * This method adds a single item to an inventory.
     * @param item 
     */
    public void addItem(Item item){
        getInventoryMerchant().add(item);
    }
    
    /**
     * This method shows the merchant inventory as a string. This was used in the text-based interface.
     * @return The String used to present the result.
     */
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
    /**
     * This method will show the encounter message for a store.
     * @return String This string is used in the presentation layer.
     */
    @Override
    public String encounterMessage() {
        return "Welcome to the store, please take a look around\n";
    }
}
