/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

/**
 *
 * @author nitra
 */
public class Item {
    private String Name;
//    private String Description;
    private int Buyprice;
    private int Sellprice;
//    private int score;
    
    public Item(String name, int bp, int sp){
        this.Name = name;
        this.Buyprice = bp;
        this.Sellprice = sp;
    }
    public int getBuyPrice(){
        return this.Buyprice;
    }
    public int getSellPrice(){
        return this.Sellprice;
    }
    
//    public void getDescription(){
//        
//    }
}
