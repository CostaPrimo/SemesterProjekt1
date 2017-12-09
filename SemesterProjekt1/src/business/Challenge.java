package business;

/**
 *
 * @author Gruppe 20
 */
public class Challenge {
    //Creating a string array
    
   private String[] multipleChoice;
   private String userSelect1;
   private String output1Question = "";
   private String output1QuestionResult = "";
   private String output2Question = "";
   private String output2QuestionResult = "";
   
   public Challenge(){
    multipleChoice = new String[10];
    multipleChoice[0] = "Question 1?";
    multipleChoice[1] = "Question 2?";
    multipleChoice[2] = "What is Mr. Mountain Dew's favorite drink?";
    multipleChoice[3] = "Question 4?";
    multipleChoice[4] = "test";
    multipleChoice[5] = "What is the name of the shopkeeper who sell crowbars, rat poison and other sorts of items?";
   }
   
   
   public boolean selectAnswer(int i, char choice){
        userSelect1 = multipleChoice[i];
        boolean iscorrect = false;
        int attempts = 1;
        if(userSelect1==multipleChoice[5]){      
            output1Question += (multipleChoice[5]);           
            output1Question += "A: Ludoman";
            output1Question += "B: Ali";
            output1Question += "C: Mr. Mountain Dew";
            output1Question += "D: Mohammed";

            
            while (iscorrect == false && attempts>0){
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
