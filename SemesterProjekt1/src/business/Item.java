package business;

import acquaintance.IItem;

/**
 *<h1>Item class!</h1>
 * @author Gruppe 20
 */
public class Item implements IItem {
    //Creating variables for the Item class
    private String Name, rarity;
    private int Buyprice, Sellprice;
    private boolean tooHeavy;
    
    //Creating a contructor for the Item class with rarity
    /**
     * Constructor for the item clss with rarity included
     * @param name The name of the item.
     * @param rarity The rarity of the item.
     * @param bp The cost of an item.
     * @param sp The money gained selling an item.
     */
    public Item(String name, String rarity, int bp, int sp){
        this.Name = name;
        this.Buyprice = bp;
        this.Sellprice = sp;
        this.rarity = rarity;
    }
    /**
     * Constructor for nonpickable items
     * @param name This item cannot be picked up, and there for only a name can be specified.
     */
    public Item(String name){
        this.Name = name;
        this.tooHeavy = true;
    }
    
    
    public String getName(){
        return this.Name;
    }
    
    
    //Method for getting the BuyPrice of an Item
    public int getBuyPrice(){
        return this.Buyprice;
    }
    
    //Method for getting the SellPrice of an Item
    public int getSellPrice(){
        return this.Sellprice;
    }

    /**
     * @return the tooHeavy
     */
    public boolean isTooHeavy() {
        return tooHeavy;
    }
    /**
     * ToString
     * @return String representation of an item used in the presentation layer.
     */
    @Override
	public String toString()
	{
            if(this.isTooHeavy()){
                return Name;
            }
            else {
		return Name + "  " + Buyprice+ ".- " + "/ " + Sellprice+ ".-";
            }
	}
}
