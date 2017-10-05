package temp;


public class Main {
    
    public static void main(String[] args) {
        Challenge c = new Challenge();
        Parser p = new Parser();
        Game game = new Game();
        game.play();
        
        c.selectAnswer(0, p);
        
    }
}

