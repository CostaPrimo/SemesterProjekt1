package temp;

import java.util.Scanner;
//import java.util.StringTokenizer; ikke i brug indtil videre

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Parser 
{
//    vores 2 variabler
    private CommandWords commands;
    private Scanner reader;

//    vores no arg metode som defaulter vores variabler.
    public Parser() 
    {
//        Commands laver et objekt fra CommandWords klassen og Reader er vores scanner.
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }
//vores getter til at hente en command
    public Command getCommand() 
    {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");
//     her laver vi vores string inputline til at den skal have input fra brugeren
        inputLine = reader.nextLine();

//        her laver vi en ny scanner og tjekker om den får input 
//        og derefter sætter word1 til det ord vi skrev
//        samme med word2
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }
//        her returner vi word 1 og 2
        return new Command(commands.getCommandWord(word1), word2);
    }
// her viser vi alle commands
    public void showCommands()
    {
        commands.showAll();
    }
}
