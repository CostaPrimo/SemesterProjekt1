package temp;

/**
 *
 * @author Gruppe 20
 */
public class Item {
    //Creating variables for the Item class
    private String Name;
//    private String Description;
    private int Buyprice;
    private int Sellprice;
//    private int score;
    
    //Creating a contructor for the Item class
    public Item(String name, int bp, int sp){
        this.Name = name;
        this.Buyprice = bp;
        this.Sellprice = sp;
    }
    //Method for getting the BuyPrice of an Item
    public int getBuyPrice(){
        return this.Buyprice;
    }
    //Method for getting the SellPrice of an Item
    public int getSellPrice(){
        return this.Sellprice;
    }
    
//    public void getDescription(){
//        
//    }
}
