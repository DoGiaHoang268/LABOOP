
import java.util.Scanner;

/**
 *
 * @author Hoang Do Gia
 */
public class Validation {
 private final static Scanner sc = new Scanner(System.in);
    //check data type int in this case is choice
     public static int checkInt(String mess, int min, int max) { 
        int number;
        while (true) {
            System.out.print(mess); 
            try {
                number = Integer.parseInt(sc.nextLine().trim());
                if (number >= min && number <= max) {  
                    return number;
                } else {  
                    System.err.println("Number must in rage " + min + " to " + max); 
                }
            } catch (NumberFormatException e) {
                System.err.println("Must is number format!Please! "); 
            }
        }

    }
      //check data type int in this case is choice
      public static double checkDouble(String mess, double min, double max) {
        double number;
        while (true) {
            System.out.print(mess); 
            try {
                number = Double.parseDouble(sc.nextLine().trim());
                if (number >= min && number <= max) { 
                    return number;
                } else {  
                    System.err.println("Number must in rage " + min + " to " + max); 
                }
            } catch (NumberFormatException e) {
                System.err.println("Must is number format!Please! "); 
            }
        }

    }
      
      
     public static String CheckOperator(String message){
         String operator;
         while(true){
             System.out.print(message);
             operator = sc.nextLine().trim();
             if(operator.matches("[+-/^=]{1}")|| operator.equalsIgnoreCase("*")){
                 return operator;
             }else{
                 System.out.print("Please input (+, -, *, /, ^)");
             }
         }
         
     }
     
}
