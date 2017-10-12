package temp;


public class Main {
    
    public static void main(String[] args) {
        //Stuff for testing
        Challenge c = new Challenge();
        Parser p = new Parser();
        Item CPU = new Item("i9 5 GHz", 7000, 3500);
        Inventory temp = new Inventory();
        
        temp.addItem(CPU);
        temp.addItem(CPU);
        temp.addItem(CPU);
        temp.addItem(CPU);
        
        
        c.selectAnswer(0, p);
        
        //Actual serious stuff
        Game game = new Game();
        game.play();       
    }
}

