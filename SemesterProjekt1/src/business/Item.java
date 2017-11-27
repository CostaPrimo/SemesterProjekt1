package business;

import acquaintance.IItem;

/**
 *
 * @author Gruppe 20
 */
public class Item implements IItem {
    //Creating variables for the Item class
    private String Name, rarity;
    private int Buyprice, Sellprice;
    private boolean tooHeavy;
    
    //Creating a contructor for the Item class
    public Item(String name, String rarity, int bp, int sp){
        this.Name = name;
        this.Buyprice = bp;
        this.Sellprice = sp;
        this.rarity = rarity;
    }
    
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
    
    @Override
	public String toString()
	{
		return "Name " + Name + " BuyPrice " + Buyprice + " SellPrice" + Sellprice;
	}
}
