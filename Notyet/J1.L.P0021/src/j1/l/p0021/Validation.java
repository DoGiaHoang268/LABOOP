
package j1.l.p0021;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ACER
 */

public class Validation {
    private final  Scanner sc = new Scanner(System.in);
      public String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
                System.out.print("Try again: ");
            } else {
                return result;
            }
        }
    }
     
    public int checkInt(String mess, int min, int max) {
        int result;
        System.out.print(mess);
        while (true) {
            try {
                result = Integer.parseInt(sc.nextLine().trim());
                if (result >= min && result <= max) {
                    break;
                } else {
                    System.err.print("Out of range! please enter in range "
                            + "[" + min + "," + max + "]: ");
                }
            } catch (NumberFormatException e) {
                System.err.print("Must enter a number: ");
            }
        }
        return result;
    }
    
    public String checkCode(ArrayList<Student> list){
        while(true){
            System.out.print("Enter your student id:");
            String code = checkInputString();
            boolean exist =false;
            for (Student student : list) {
                if (student.getId().equalsIgnoreCase(code)) {
                    exist=true;
                }
            }
            if (exist==true) {
                System.err.println("Code exist!");
                
            }else{
                return  code;
            }
        }
    }
    
    //check dạng chuẩn của fomatString
    public String  checkFormatString(String mess,String parternFomart){
       String result;
       while(true){
           System.out.print(mess);
           result=checkInputString();
           if (result.matches(parternFomart)) {
               break;
           }else{
               System.err.println("Wrong!!!");
              
           }
       }
       return result;
    }
    
    
    
    
}
