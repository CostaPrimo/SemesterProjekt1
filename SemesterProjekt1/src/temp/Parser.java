package temp;

import java.util.Scanner;
//import java.util.StringTokenizer; not in use so far

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Parser 
{
//    The two variables in our class
    private CommandWords commands;
    private Scanner reader;

//    The no arg constructer which creates our default parser
    public Parser(){
//        Commands creates and object from the CommandWords class & reader is our scanner.
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }


    //The getter to get a command
    public Command getCommand(){
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");
//     Here we make a string to store our input from the user.
        inputLine = reader.nextLine();

//        Here we create a new scanner which has the input from the string we just made.her laver vi en ny scanner og tjekker om den får input 
//        And the we set word 1 and word 2 to the input we gave it.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }
//        And then we return word 1 and word 2.
        return new Command(commands.getCommandWord(word1), word2);
    }


    // This method shows all the commands we have.
    public void showCommands(){
        commands.showAll();
    }
    
    
    // this method we use to be able to use our scanner in other classes so we dont have to import it everytime.
    public String returnString(){
        return reader.next();
    }
}
