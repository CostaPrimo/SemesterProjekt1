package business;

/**
 *<h1>Challenge class!</h1>
 * @author Gruppe 20
 */
public class Challenge {
    //Creating a string array
    
   private String[] multipleChoice;
   private String userSelect1;
   private String[] output1Question;
   /**
    * Constructing our challenge class which initializes our questions in the StringArray
    */
   public Challenge(){
    multipleChoice = new String[10];
    multipleChoice[0] = "Question 1?";
    multipleChoice[1] = "Question 2?";
    multipleChoice[2] = "What is Mr. Mountain Dew's favorite drink?\n";
    multipleChoice[3] = "Question 4?";
    multipleChoice[4] = "test";
    multipleChoice[5] = "What is the name of the shopkeeper who sell crowbars, rat poison and other sorts of items?\n";
    output1Question = new String[5];
   }
   /**
    * This method will print the question and possible answers.
    * @param i This parameter is used to compare the int i (daytoken) and then pick the right question to present.
    * @return String[] This will be used in the challengeNPC class.
    */
   public String[] printQuestion(int i){
       if(i == 5){
        output1Question[0] = multipleChoice[5];           
        output1Question[1] = "A: Ludoman\n";
        output1Question[2] = "B: Ali\n";
        output1Question[3] = "C: Mr. Mountain Dew\n";
        output1Question[4] = "D: Mohammed\n";
       }
       if(i == 2){
        output1Question[0] = multipleChoice[2];           
        output1Question[1] = "A: Pepsi\n";
        output1Question[2] = "B: MonsterBullBooster\n";
        output1Question[3] = "C: Mountain Dew\n";
        output1Question[4] = "D: Dr. Pepper\n";
       }
       return output1Question;
   }
   /**
    * This method will evaluate whether the player answered the question correct or not.
    * @param i Thie current question to evaluate. 
    * @param choice The choice the user clicked.
    * @return boolean True or false whether the answer was correct or not.
    */
   public boolean selectAnswer(int i, char choice){
        userSelect1 = multipleChoice[i];
        boolean iscorrect = false;
        int attempts = 1;
        if(userSelect1==multipleChoice[5]){      
                switch(choice){
                    case 'a':
                        System.out.println(choice + " Is Incorrect\n");
                        attempts--;               
                        break;
                    case 'b':
                        System.out.println(choice + " Is Correct\n");
                        iscorrect = true;
                        break;
                    case 'c':
                        System.out.println(choice + " Is Incorrect\n");
                        attempts--;
                        break;
                    case 'd':
                        System.out.println(choice + " Is Incorrect\n");
                        attempts--;
                        break;
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
            
                switch(choice){
                    case 'a':
                        System.out.println(choice + " Is Incorrect\nTry again!");
                        attempts--;               
                        break;
                    case 'b':
                        System.out.println(choice + " Is Incorrect\n");
                        attempts--;
                        break;
                    case 'c':
                        System.out.println(choice + " Is Correct\n");
                        iscorrect = true;
                        break;
                    case 'd':
                        System.out.println(choice + " Is Incorrect\nTry again!\n");
                        attempts--;
                        break;
                    default:
                        System.out.println(choice);
                        break;
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
