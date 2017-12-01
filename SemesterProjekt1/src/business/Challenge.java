package business;

/**
 *
 * @author Gruppe 20
 */
public class Challenge {
    //Creating a string array
    
   private String[] multipleChoice;
   private String userSelect1;
   
   public Challenge(){
    multipleChoice = new String[10];
    multipleChoice[0] = "Question 1?";
    multipleChoice[1] = "Question 2?";
    multipleChoice[2] = "What is Mr. Mountain Dew's favorite drink?";
    multipleChoice[3] = "Question 4?";
    multipleChoice[4] = "test";
    multipleChoice[5] = "What is the name of the shopkeeper who sell crowbars, rat poison and other sorts of items?";
    multipleChoice[6] = "test";
    multipleChoice[7] = "test";
    multipleChoice[8] = "test";
    multipleChoice[9] = "test";
    
    
   }
   
   
   public boolean selectAnswer(int i, Parser ind){
        userSelect1 = multipleChoice[i];
        boolean iscorrect = false;
        int attempts = 2;
        if(userSelect1==multipleChoice[5]){      
            System.out.println(multipleChoice[5]);           
            System.out.println("A: Ludoman");
            System.out.println("B: Ali");
            System.out.println("C: Mr. Mountain Dew");
            System.out.println("D: Mohammed");

            
            while (iscorrect == false && attempts>0){
                String uselect1 = ind.returnString();
                switch(uselect1.toUpperCase()){
                    case "A":
                        uselect1 = "Answer 1";
                        System.out.println(uselect1 + " Is Incorrect\nTry again!");
                        attempts--;               
                        break;
                    case "B":
                        uselect1 = "Answer 2";
                        System.out.println(uselect1 + " Is Correct\n");
                        iscorrect = true;
                        break;
                    case "C":
                        uselect1 = "Answer 3";
                        System.out.println(uselect1 + " Is Incorrect\nTry again!\n");
                        attempts--;
                        break;
                    case "D":
                        uselect1 = "Answer 4";
                        System.out.println(uselect1 + " Is Incorrect\nTry again!\n");
                        attempts--;
                        break;
                    default:
                        uselect1 = "Incorrect, choice.\nTry again!\n";
                        System.out.println(uselect1);
                        break;
                }
                if(iscorrect!=true){
                    System.out.println("You have " + attempts + " attempts left");
                }
            }
            if (iscorrect == true){
                    System.out.println("CORRECT! ");
                    return true;
            }
            else{
                System.out.println("INCORRECT! ");
                return false;
            }
        }
        else if(userSelect1==multipleChoice[2]){
            System.out.println(multipleChoice[2]);           
            System.out.println("A: Pepsi");
            System.out.println("B: MonsterBullBooster");
            System.out.println("C: Mountain Dew");
            System.out.println("D: Dr. Pepper");

            
            while (iscorrect == false && attempts>0){
                String uselect1 = ind.returnString();
                switch(uselect1.toUpperCase()){
                    case "A":
                        uselect1 = "Answer 1";
                        System.out.println(uselect1 + " Is Incorrect\nTry again!");
                        attempts--;               
                        break;
                    case "B":
                        uselect1 = "Answer 2";
                        System.out.println(uselect1 + " Is Incorrect\n");
                        attempts--;
                        break;
                    case "C":
                        uselect1 = "Answer 3";
                        System.out.println(uselect1 + " Is Correct\n");
                        iscorrect = true;
                        break;
                    case "D":
                        uselect1 = "Answer 4";
                        System.out.println(uselect1 + " Is Incorrect\nTry again!\n");
                        attempts--;
                        break;
                    default:
                        uselect1 = "Incorrect, choice.\nTry again!\n";
                        System.out.println(uselect1);
                        break;
                }
                if(iscorrect!=true){
                    System.out.println("You have " + attempts + " attempts left");
                }
            }
            if (iscorrect == true){
                System.out.println("CORRECT! ");
                return true;
            }
            else{
                System.out.println("INCORRECT! ");
                return false;
            }
        }
        else{
            return false;
        }
   }    
}
