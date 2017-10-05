
        
        public class Exercise05_03 {
  public static void main(String[] args) {
    System.out.printf("%-14s%-10s\n", "Celsius", "Fahrenheit");
    System.out.println("--------------------");

    int celsius = 0;
    while (celsius <= 100) {
      System.out.printf("%-14d%-10.1f\n", celsius, celsius * 9.0 / 5 + 32);
      celsius += 2;
    }
    
/** Alternatively use for loop    
    for (int celsius = 0; celsius <= 98; celsius += 2) {
      System.out.println(celsius + "\t\t" + celsius, celsius * 9.0 / 5 + 32);
    }
*/
  }
}
        // TODO code application logic her
