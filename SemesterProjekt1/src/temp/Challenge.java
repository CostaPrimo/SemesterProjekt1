/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

/**
 *
 * @author Simon
 */
public class Challenge {
    //Creating a string array
    
   private String[] multipleChoice;
   private String userSelect1;
   public Challenge(){
    multipleChoice = new String[10];
    multipleChoice[0] = "What does Simon love?";
    multipleChoice[1] = "Question 2";
    multipleChoice[2] = "What is question 3?";
    multipleChoice[3] = "What does Simon like?";
    multipleChoice[4] = "test";
    multipleChoice[5] = "test";
    multipleChoice[6] = "test";
    multipleChoice[7] = "test";
    multipleChoice[8] = "test";
    multipleChoice[9] = "test";
    
    
   }
   
   
   public void selectAnswer(int i, Parser ind){
        userSelect1 = multipleChoice[i];
        boolean iscorrect = false;
        int attempts = 2;
        if(userSelect1==multipleChoice[0]){      
            System.out.println(multipleChoice[0]);           
            System.out.println("A: Kebab");
            System.out.println("B: Titties");
            System.out.println("C: Coffee");
            System.out.println("D: blub");
            System.out.println("");
            
            while (iscorrect == false && attempts>0){
                String uselect1 = ind.returnString();
                switch(uselect1.toUpperCase()){
                    case "A":
                        uselect1 = "Kebab";
                        System.out.println(uselect1 + " Is Incorrect\nTry again!");
                        attempts--;               
                        break;
                    case "B":
                        uselect1 = "Titties";
                        System.out.println(uselect1 + " Is Correct\n");
                        iscorrect = true;
                        break;
                    case "C":
                        uselect1 = "Coffee";
                        System.out.println(uselect1 + " Is Incorrect\nTry again!\n");
                        attempts--;
                        break;
                    case "D":
                        uselect1 = "blub";
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
                    System.out.println("YOU ARE AMAZING");
                }
                else if (iscorrect == false){
                    System.out.println("YOU SUCK");
                }
        }
  
   }
           
    
}
