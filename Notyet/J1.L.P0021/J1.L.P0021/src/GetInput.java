
import java.util.ArrayList;
import java.util.Scanner;

public class GetInput {
    
    static final Scanner sc = new Scanner(System.in);
    
    static int getIntLimit(int min, int max) {
        while (true) {
            System.out.print("Enter your choice: ");
            try {
                int result = Integer.parseInt(getStringInput());
                if (result >= min && result <= max) {
                    return result;
                    
                }else{
                    System.err.println("Choice must be in range [" + min + "," + max + "]");
                }
                
            } catch (NumberFormatException e) {
                System.err.println("Please input real number!");
            }
        }
    }
    
    static String getStringInput() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not Empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    
    static String getNewID(ArrayList<Student> listStudent) {
        while (true) {
            String id = getStringInput();
            if (Validation.validateIDExist(id, listStudent)) {                
                System.err.println("ID Exist");
                System.out.print("Enter again: ");
            } else {
                return id;
            }
        }
    }
    
    static String getCourseName() {        
        while (true) {            
            String result = getStringInput();
            if (!result.matches("[123]{1}")) {                
                System.err.println("1: Java, 2: .Net, 3: C/C++");
                System.out.print("Enter again: ");
            } else {
                int courseID = Integer.parseInt(result);
                switch (courseID) {                    
                    case 1:
                        return "Java";
                    case 2:
                        return ".Net";
                    case 3:
                        return "C/C++";
                }
            }
        }
    }
    
    static String getYN(String regex, String message) {
        while (true) {            
            String result = getStringInput();
            if (!result.matches(regex)) {                
                System.err.println(message);
                System.out.print("Enter again: ");
            } else {                
                return result;
            }
        }
    }

    static String getIDExist(ArrayList<Student> listStudent) {
        while (true) {
            String id = getStringInput();
            if (!Validation.validateIDExist(id, listStudent)) {                
                System.err.println("ID not Exist");
                System.out.print("Enter again: ");
            } else {
                return id;
            }
        }
    }
    
}
